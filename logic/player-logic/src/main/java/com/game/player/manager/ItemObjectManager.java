package com.game.player.manager;

import com.game.common.execl.TableManager;
import com.game.common.utils.IDGenerator;
import com.game.player.entity.ItemEntity;
import com.game.player.entity.StorageEntity;
import com.game.player.mapper.ItemObjectMapper;
import com.game.player.service.StorageService;
import com.game.storage.constant.ItemConstant;
import com.game.storage.execl.WeaponTable;
import com.game.storage.model.ItemObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 物品对象管理器
 * 负责管理玩家的物品数据，包括加载、添加、移除
 * 与客户端交互 物品需要一个 objId 唯一id, 玩家上线时 将所有物品数据加载到内存中 方便后续物品交互
 */
@Slf4j
@Component
public class ItemObjectManager {

    @Resource
    StorageService storageService;

    private final Map<Long, Map<Integer, List<ItemObject>>> playerItems = new ConcurrentHashMap<>();

    /**
     * 获取玩家物品
     */
    public Map<Integer, List<ItemObject>> getStorage(long roleId) {
        return playerItems.computeIfAbsent(roleId, k -> new ConcurrentHashMap<>());
    }

    /**
     * 获取物品列表
     */
    public List<ItemObject> getStorageItemList(long roleId, int storageType) {
        return getStorage(roleId).computeIfAbsent(storageType, k -> new ArrayList<>());
    }

    /**
     * 获取物品对象
     */
    public ItemObject findItemObject(long roleId, int storageType, long objectId) {
        var itemList = this.getStorageItemList(roleId, storageType);
        for (ItemObject itemObject : itemList) {
            if (itemObject.getObjId() == objectId) {
                return itemObject;
            }
        }
        return null;
    }

    /**
     * 将数据中的内容加载到 ItemManager
     */
    public Map<Integer, List<ItemObject>> loadStorage(long roleId) {
        // 清除当前缓存
        var storage = getStorage(roleId);
        storage.clear();

        // 从 StorageService 获取数据
        StorageEntity storageEntity = storageService.getStorage(roleId);
        if (storageEntity == null) {
            log.warn("加载玩家物品失败，玩家背包数据不存在: roleId={}", roleId);
            return storage;
        }

        // 转换并加载到内存缓存中
        var itemList = storageEntity.getItemList();
        for (var entry : itemList.entrySet()) {
            List<ItemObject> itemObjects = entry.getValue().stream()
                    .map(this::convertToItemObject)
                    .collect(Collectors.toList());
            storage.put(entry.getKey(), itemObjects);
        }

        log.info("玩家物品加载完成: roleId={}, 存储类型数量={}", roleId, storage.size());
        return storage;
    }

    /**
     * 将ItemEntity转换为ItemObject并设置唯一对象ID
     *
     * @param itemEntity 物品实体
     * @return 转换后的物品对象
     */
    public ItemObject convertToItemObject(ItemEntity itemEntity) {
        // 为每个物品生成唯一的对象ID
        int objectId = IDGenerator.generateObjectId();
        ItemObject itemObject = ItemObjectMapper.ME.convert(itemEntity);
        // 设置物品的对象ID
        itemObject.setObjId(objectId);
        // 是否绑定
        itemObject.setBind(itemEntity.getBind());

        // table 属性
        if (itemEntity.getItemType() == ItemConstant.Type.WEAPON) {
            var table = TableManager.getTable(WeaponTable.class).get(itemEntity.getItemIdx());
            itemObject.setRealQuality(table.getQuality());
        }

        return itemObject;
    }

    public ItemObject addItemProp(long roleId, ItemEntity item) {
        // 判断物品是否已经存在
        var itemList = this.getStorageItemList(roleId, ItemConstant.StorageType.PACKAGE);
        for (ItemObject itemObject : itemList) {
            // 道具只需要判断物品ID和绑定状态
            if (itemObject.getItemIdx() == item.getItemIdx() && itemObject.getBind() == item.getBind()) {
                // 如果物品已存在，增加数量
                itemObject.setCount(itemObject.getCount() + item.getCount());
                return itemObject;
            }
        }

        // 如果物品不存在，添加新物品
        var itemObject = convertToItemObject(item);
        // 添加到背包
        itemList.add(itemObject);
        return itemObject;
    }

    public ItemObject addItemWeapon(long roleId, ItemEntity item) {
        var itemList = this.getStorageItemList(roleId, ItemConstant.StorageType.PACKAGE);
        var itemObject = convertToItemObject(item);
        itemList.add(itemObject);
        return itemObject;
    }

    public boolean moveItem(long roleId, ItemObject itemObject, int fromType, int toType) {
        // 从源存储区移除物品
        var fromList = this.getStorageItemList(roleId, fromType);
        fromList.remove(itemObject);

        // 添加到目标存储区
        var toList = this.getStorageItemList(roleId, toType);
        toList.add(itemObject);
        return true;
    }

    /**
     * 根据物品ID查找物品对象
     */
    public ItemObject findItemObjectByItemId(long roleId, int storageType, String itemId) {
        var itemList = this.getStorageItemList(roleId, storageType);
        for (ItemObject itemObject : itemList) {
            if (itemObject.getItemId().equals(itemId)) {
                return itemObject;
            }
        }
        return null;
    }

    /**
     * 更新物品数量
     */
    public ItemObject updateItemCount(long roleId, int storageType, String itemId, int newCount) {
        ItemObject itemObject = findItemObjectByItemId(roleId, storageType, itemId);
        if (itemObject != null) {
            itemObject.setCount(newCount);
        }
        return itemObject;
    }

    /**
     * 移除物品
     */
    public ItemObject removeItem(long roleId, int storageType, String itemId) {
        var itemList = this.getStorageItemList(roleId, storageType);
        ItemObject itemObject = findItemObjectByItemId(roleId, storageType, itemId);
        if (itemObject != null) {
            itemList.remove(itemObject);
        }
        return itemObject;
    }
}
