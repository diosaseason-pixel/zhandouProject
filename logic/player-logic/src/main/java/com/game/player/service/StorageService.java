package com.game.player.service;

import com.game.common.entity.PropEntity;
import com.game.common.execl.TableManager;
import com.game.kit.TimeKit;
import com.game.player.entity.ItemEntity;
import com.game.player.entity.StorageEntity;
import com.game.player.repository.StorageRepository;
import com.game.storage.constant.ItemConstant;
import com.game.storage.execl.WeaponTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * 玩家背包服务
 */
@Slf4j
@Service
@AllArgsConstructor
public class StorageService {

    private final StorageRepository storageRepository;

    /**
     * 获取玩家背包信息
     *
     * @param roleId 角色ID
     * @return 背包实体
     */
    public StorageEntity getStorage(long roleId) {
        var optional = storageRepository.findById(roleId);
        return optional.orElseGet(() -> createStorage(roleId));
    }

    /**
     * 获取 指定类型的物品列表
     */
    public List<ItemEntity> getStorageItems(long roleId, int storageType) {
        var storage = getStorage(roleId);
        return storage.getItemList().get(storageType);
    }

    /**
     * 创建玩家背包
     *
     * @param roleId 角色ID
     * @return 新创建的背包实体
     */
    public StorageEntity createStorage(long roleId) {
        StorageEntity storage = new StorageEntity();
        storage.setId(roleId);
        storage.setItemList(new HashMap<>());

        // 初始化各个存储区
        storage.getItemList().put(ItemConstant.StorageType.PACKAGE, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.EQUIPWEAR, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.DEPOT, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.HEART, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.HEARTWEAR, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.WEAPONWEAR, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.HEROEQUIPWEAR, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.SELF_WEAPON_WEAR, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.MAGIC_FIRE_WEAR, new ArrayList<>());
        storage.getItemList().put(ItemConstant.StorageType.PUBLIC_SPACE, new ArrayList<>());

        return storageRepository.save(storage);
    }

    /**
     * 添加物品到背包
     *
     * @param roleId     角色Id
     * @param itemEntity 物品
     * @return 是否是新增物品
     */
    public boolean addItemProp(long roleId, ItemEntity itemEntity) {
        StorageEntity storage = getStorage(roleId);
        List<ItemEntity> itemList = storage.getItemList().get(ItemConstant.StorageType.PACKAGE);

        // 检查是否已存在相同物品
        for (ItemEntity item : itemList) {
            // 道具只需要判断物品ID和绑定状态
            if (item.getItemIdx() == itemEntity.getItemIdx() && item.getBind() == itemEntity.getBind()) {
                // 如果物品已存在，增加数量
                item.setCount(item.getCount() + itemEntity.getCount());
                storageRepository.save(storage);
                return false;
            }
        }

        // 生成物品 流水号 唯一uuid
        if (StringUtils.isEmpty(itemEntity.getItemId())) {
            String itemId = generateItemId(roleId);
            itemEntity.setItemId(itemId);
        }

        // 如果没有设置创建时间，则设置
        if (itemEntity.getCreateTime() <= 0) {
            itemEntity.setCreateTime(TimeKit.currentSecond());
        }

        // 如果物品不存在，添加新物品
        itemList.add(itemEntity);
        storageRepository.save(storage);
        return true;
    }

    /**
     * 添加法宝到背包
     */
    public boolean addItemWeapon(long roleId, ItemEntity itemEntity) {
        StorageEntity storage = getStorage(roleId);
        List<ItemEntity> itemList = storage.getItemList().get(ItemConstant.StorageType.PACKAGE);

        var table = TableManager.getTable(WeaponTable.class).get(itemEntity.getItemIdx());
        if (table == null) {
            return false;
        }

        // 生成物品 流水号 唯一uuid
        if (StringUtils.isEmpty(itemEntity.getItemId())) {
            String itemId = generateItemId(roleId);
            itemEntity.setItemId(itemId);
        }

        // 通过 table propMin propMax 随机生成 物品属性
        PropEntity randomProp = PropEntity.generateProps(table.getPropMin(), table.getPropMax());
        itemEntity.setProp(randomProp);

        // 如果没有设置创建时间，则设置
        if (itemEntity.getCreateTime() <= 0) {
            itemEntity.setCreateTime(TimeKit.currentSecond());
        }

        // 添加到背包
        itemList.add(itemEntity);
        storageRepository.save(storage);
        return true;
    }

    /**
     * 移动物品
     */
    public boolean moveItem(long roleId, String itemId, int fromType, int toType) {
        var storage = this.getStorage(roleId);

        var fromList = storage.getItemList().get(fromType);
        var toList = storage.getItemList().get(toType);

        // 检查源存储区是否存在物品
        var entity = fromList.stream()
                .filter(item -> item.getItemId() != null && item.getItemId().equals(itemId))
                .findFirst()
                .orElse(null);

        if (entity == null) {
            log.error("物品不存在，roleId={}, itemId={}, fromType={}, toType={}", roleId, itemId, fromType, toType);
            return false;
        }

        // 从源存储区移除物品
        fromList.remove(entity);

        // 添加到目标存储区
        toList.add(entity);

        // 保存更改
        storageRepository.save(storage);
        return true;
    }

    /**
     * 查找指定类型和ID的物品
     */
    public List<ItemEntity> findItems(long roleId, int itemIdx, int storageType) {
        var itemList = getStorageItems(roleId, storageType);
        return itemList.stream()
                .filter(item -> item.getItemIdx() == itemIdx)
                .sorted((a, b) -> {
                    // 优先使用绑定的物品
                    if (a.getBind() != b.getBind()) {
                        return b.getBind() - a.getBind();
                    }
                    // 数量少的优先
                    return a.getCount() - b.getCount();
                })
                .toList();
    }

    /**
     * 更新物品
     */
    private void removeItem(long roleId, ItemEntity entity, int storageType) {
        var storage = getStorage(roleId);
        var itemList = storage.getItemList().get(storageType);
        itemList.removeIf(item -> StringUtils.equals(entity.getItemId(), item.getItemId()));
        storageRepository.save(storage);
    }

    /**
     * 更新物品
     */
    private void updateItem(long roleId, ItemEntity entity, int storageType) {
        var storage = getStorage(roleId);
        var itemList = storage.getItemList().get(storageType);
        itemList.removeIf(item -> StringUtils.equals(entity.getItemId(), item.getItemId()));
        itemList.add(entity);
        storageRepository.save(storage);
    }

    /**
     * 减少物品数量
     */
    public ReduceItemResult reduceItem(long roleId, int itemIdx, int count, int storageType) {
        ReduceItemResult result = new ReduceItemResult();

        // 查找物品
        var items = findItems(roleId, itemIdx, storageType);

        if (items.isEmpty()) {
            log.error("物品不存在，roleId={}, itemIdx={}", roleId, itemIdx);
            return result;
        }

        // 检查物品总数是否足够
        int totalCount = items.stream().mapToInt(ItemEntity::getCount).sum();
        if (totalCount < count) {
            log.error("物品数量不足，roleId={}, itemIdx={}, need={}, has={}", roleId, itemIdx, count, totalCount);
            return result;
        }

        // 扣减物品
        int remainCount = count;
        List<ItemEntity> removedItems = new ArrayList<>();

        for (var item : items) {
            if (remainCount <= 0) {
                break;
            }

            int currentCount = item.getCount();
            if (currentCount <= remainCount) {
                // 物品数量不足，全部使用
                remainCount -= currentCount;
                removedItems.add(item);
                result.getRemovedItemIds().add(item.getItemId());
                this.removeItem(roleId, item, storageType);
            } else {
                // 物品数量足够，部分使用
                int reduceAmount = remainCount;
                item.setCount(currentCount - reduceAmount);
                remainCount = 0;
                result.getUpdatedItems().add(item);
                this.updateItem(roleId, item, storageType);
            }
        }

        // 设置操作成功标志
        result.setSuccess(true);
        return result;
    }

    /**
     * 减少物品数量的结果
     */
    @Data
    public static class ReduceItemResult {
        /**
         * 操作是否成功
         */
        private boolean success;
        /**
         * 被移除的物品ID
         */
        private List<String> removedItemIds = new ArrayList<>();
        /**
         * 被更新的物品
         */
        private List<ItemEntity> updatedItems = new ArrayList<>();
    }

    /**
     * 生成唯一的物品流水号，使用UUID格式
     *
     * @param roleId 角色ID
     * @return 新生成的UUID格式物品流水号
     */
    private String generateItemId(long roleId) {
        // 获取当前服务器ID (从角色ID中提取，角色ID = 服务器ID * 1000000 + 序列号)
        int serverId = (int) (roleId / 1000000);

        // 生成一个随机的UUID
        UUID uuid = UUID.randomUUID();

        // 使用UUID的高32位的前8位保存服务器ID信息，确保合服后也不会冲突
        long mostSigBits = uuid.getMostSignificantBits();
        mostSigBits = (mostSigBits & 0x00FFFFFFFFFFFFFFL) | ((long) serverId << 56);

        // 创建一个新的UUID，高32位包含服务器ID信息
        UUID customUuid = new UUID(mostSigBits, uuid.getLeastSignificantBits());

        // 返回标准UUID格式字符串
        return customUuid.toString();
    }
}