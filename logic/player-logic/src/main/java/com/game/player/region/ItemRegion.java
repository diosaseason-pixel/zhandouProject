package com.game.player.region;

import com.game.cmd.SCmd;
import com.game.common.client.BroadcastHelp;
import com.game.common.execl.TableManager;
import com.game.common.proto.PbHeroPropertyChangeNtf;
import com.game.common.proto.PbObjProperty;
import com.game.ex.FlowContextEx;
import com.game.player.entity.ItemEntity;
import com.game.player.manager.ItemObjectManager;
import com.game.player.mapper.ItemMapper;
import com.game.player.service.PlayerService;
import com.game.player.service.StorageService;
import com.game.screen.util.SceneObjectProtoUtil;
import com.game.storage.constant.ItemConstant;
import com.game.storage.execl.WeaponTable;
import com.game.storage.model.ItemObject;
import com.game.storage.proto.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 物品模块
 */
@Slf4j
@Component
@AllArgsConstructor
public class ItemRegion {

    private final StorageService storageService;
    private final ItemObjectManager itemObjectManager;
    private final PlayerService playerService;

    public void addValueProp(FlowContextEx flowContext, ItemEntity item) {
        long userId = flowContext.getUserId();
        int itemIdx = item.getItemIdx();
        int count = item.getCount();

        // 添加到玩家身上
        long changeValue = 0;
        switch (itemIdx) {
            case ItemConstant.PropIdx.Coin: // 灵石
                changeValue = playerService.addCoin(flowContext.getRoleId(), count);
                break;
            case ItemConstant.PropIdx.FairyCrystal: // 绑定仙玉
                changeValue = playerService.addFairyCrystal(flowContext.getRoleId(), count);
                break;
            case ItemConstant.PropIdx.EXP:  // 经验
                changeValue = playerService.addExp(flowContext.getRoleId(), count);
                break;
            default:
                log.error("未知的货币类型物品: {}", item);
                return;
        }

        // 发送角色属性变更通知
        int expendAttr = ItemConstant.ExpendAttr.get(itemIdx);
        var property = new PbObjProperty();
        property.objId = flowContext.getObjectId();
        property.addProperty(expendAttr, changeValue);

        BroadcastHelp.broadcast(SCmd.HERO_ATTR_CHANGE, new PbHeroPropertyChangeNtf(property, true), userId);
    }

    public void reduceValuePropItem(FlowContextEx flowContext, int itemIdx, int count) {
        long userId = flowContext.getUserId();
        long roleId = flowContext.getRoleId();

        // 从玩家身上扣除
        long changeValue = 0;
        switch (itemIdx) {
            case ItemConstant.PropIdx.Coin: // 灵石
                changeValue = playerService.reduceCoin(roleId, count);
                break;
            case ItemConstant.PropIdx.FairyCrystal: // 仙玉
                changeValue = playerService.reduceFairyCrystal(roleId, count);
                break;
            case ItemConstant.PropIdx.PayCoin:
                changeValue = playerService.reduceFairyCrystal(roleId, count);
                break;
            case ItemConstant.PropIdx.EXP:
                changeValue = playerService.reduceExp(roleId, count);
                break;
            default:
                log.error("不支持的货币类型: {}", itemIdx);
                return;
        }

        // 发送角色属性变更通知
        int expendAttr = ItemConstant.ExpendAttr.get(itemIdx);
        var property = new PbObjProperty();
        property.objId = flowContext.getObjectId();
        property.addProperty(expendAttr, changeValue);
        BroadcastHelp.broadcast(SCmd.HERO_ATTR_CHANGE, new PbHeroPropertyChangeNtf(property, true), userId);
    }

    /**
     * 从背包中减少物品
     */
    private boolean reducePackageItem(FlowContextEx flowContext, ItemEntity itemReq, BiFunction<ItemObject, Integer, Void> callback) {
        int itemIdx = itemReq.getItemIdx();
        int count = itemReq.getCount();
        int storageType = ItemConstant.StorageType.PACKAGE;

        // 如果是货币类型的物品
        if (ItemConstant.ValueProp.containsKey(itemIdx)) {
            this.reduceValuePropItem(flowContext, itemIdx, count);
            return true;
        }

        long roleId = flowContext.getRoleId();

        // 使用服务层方法减少物品
        StorageService.ReduceItemResult dbResult = storageService.reduceItem(roleId, itemIdx, count, storageType);

        if (!dbResult.isSuccess()) {
            return false;
        }

        // 处理被移除的物品
        for (String itemId : dbResult.getRemovedItemIds()) {
            ItemObject obj = itemObjectManager.removeItem(roleId, storageType, itemId);
            if (obj != null && callback != null) {
                callback.apply(obj, obj.getCount());
            }
        }

        // 处理被更新的物品
        for (ItemEntity item : dbResult.getUpdatedItems()) {
            ItemObject obj = itemObjectManager.updateItemCount(roleId, storageType, item.getItemId(), item.getCount());
            if (obj != null && callback != null) {
                callback.apply(obj, count - obj.getCount());
            }
        }
        return true;
    }

    /**
     * 减少物品数量并发送通知
     */
    public boolean reduceItemAndNotify(FlowContextEx flowContext, int itemIdx, int count, int storageType) {
        if (count <= 0) {
            log.error("减少物品数量必须大于0，roleId={}, itemIdx={}, count={}", flowContext.getRoleId(), itemIdx, count);
            return false;
        }

        // 构造物品对象
        ItemEntity itemReq = new ItemEntity();
        itemReq.setItemIdx(itemIdx);
        itemReq.setCount(count);

        List<ItemObject> removedObjects = new ArrayList<>();
        List<ItemObject> updatedObjects = new ArrayList<>();

        // 减少物品
        boolean success = reducePackageItem(flowContext, itemReq, (itemObject, reduceCount) -> {
            if (reduceCount >= itemObject.getCount()) {
                // 完全移除
                removedObjects.add(itemObject);
            } else {
                // 部分减少
                updatedObjects.add(itemObject);
            }
            return null;
        });

        if (!success) {
            return false;
        }

        // 发送移除物品的通知
        if (!removedObjects.isEmpty()) {
            var notify = new PbRemovePackageItemNtf();
            notify.parcelId = storageType;
            removedObjects.forEach(itemObject -> {
                notify.objIds.add(itemObject.getObjId());
            });
            flowContext.broadcastMe(SCmd.ITEM_OUTOF_STORAGE, notify);
        }

        // 发送更新物品的通知
        if (!updatedObjects.isEmpty()) {
            var notify = new PbPackageItemNtf();
            notify.parcelId = storageType;
            for (ItemObject itemObject : updatedObjects) {
                notify.itemList.add(SceneObjectProtoUtil.toProto(itemObject));
            }
            flowContext.broadcastMe(SCmd.ITEM_PROPERTY_CHANGE, notify);
        }
        return true;
    }

    /**
     * 减少物品数量
     */
    public boolean reduceItemAndNotify(FlowContextEx flowContext, int itemIdx, int count) {
        return reduceItemAndNotify(flowContext, itemIdx, count, ItemConstant.StorageType.PACKAGE);
    }

    private void addPackageItem(FlowContextEx flowContext, ItemEntity item, BiFunction<ItemObject, Boolean, Void> callback) {
        // 是否是货币类型的物品
        if (ItemConstant.ValueProp.containsKey(item.getItemIdx())) {
            this.addValueProp(flowContext, item);
            return;
        }

        long roleId = flowContext.getRoleId();

        // 添加物品
        boolean isNewItem = false;
        ItemObject itemObject = null;
        if (item.getItemType() == ItemConstant.Type.PROP) {
            // 道具
            isNewItem = storageService.addItemProp(roleId, item);
            itemObject = itemObjectManager.addItemProp(roleId, item);
        } else if (item.getItemType() == ItemConstant.Type.WEAPON) {
            // 法宝
            isNewItem = storageService.addItemWeapon(roleId, item);
            if (!isNewItem) {
                return;
            }
            itemObject = itemObjectManager.addItemWeapon(roleId, item);
        }

        // 执行回调函数
        if (callback != null && itemObject != null) {
            callback.apply(itemObject, isNewItem);
        }
    }


    /**
     * 添加物品到背包并通知客户端
     */
    public void addItemAndNotify(FlowContextEx flowContext, PbInternalAddItemReq req) {
        List<ItemEntity> itemEntityList = ItemMapper.ME.convertList(req.itemList);

        List<ItemObject> newItem = new ArrayList<>();
        List<ItemObject> propertyChange = new ArrayList<>();

        // 添加物品到背包
        for (ItemEntity item : itemEntityList) {
            this.addPackageItem(flowContext, item, (itemObject, isNewItem) -> {
                if (isNewItem) {
                    newItem.add(itemObject);
                } else {
                    propertyChange.add(itemObject);
                }
                return null;
            });
        }

        // 新增的物品
        if (!newItem.isEmpty()) {
            var notify = new PbPackageItemNtf();
            notify.parcelId = ItemConstant.StorageType.PACKAGE;
            for (ItemObject itemObject : newItem) {
                notify.itemList.add(SceneObjectProtoUtil.toProto(itemObject));
            }
            flowContext.broadcastMe(SCmd.ITEM_INTO_STORAGE, notify);
        }

        // 变更的物品
        if (!propertyChange.isEmpty()) {
            var notify = new PbPackageItemNtf();
            notify.parcelId = ItemConstant.StorageType.PACKAGE;
            for (ItemObject itemObject : propertyChange) {
                notify.itemList.add(SceneObjectProtoUtil.toProto(itemObject));
            }
            flowContext.broadcastMe(SCmd.ITEM_PROPERTY_CHANGE, notify);
        }

        // 物品获得通知
        if (!itemEntityList.isEmpty() && req.isShow) {
            var notify = new PbItemChangeNtf();
            notify.msgId = req.msgId;
            for (ItemEntity item : itemEntityList) {
                var itemObject = itemObjectManager.convertToItemObject(item);
                notify.changeItem.add(SceneObjectProtoUtil.toProto(itemObject));
            }
            flowContext.broadcastMe(SCmd.ITEM_CHANGE, notify);
        }
    }


    public boolean moveItemAndNotify(FlowContextEx flowContext, int objectId, int fromType, int toType) {
        long roleId = flowContext.getRoleId();

        // 移动物品
        var itemObject = itemObjectManager.findItemObject(flowContext.getRoleId(), fromType, objectId);
        if (itemObject == null) {
            log.error("物品不存在，roleId={}, objectId={}", flowContext.getRoleId(), objectId);
            return false;
        }

        // 移动物品
        boolean isMoved = itemObjectManager.moveItem(roleId, itemObject, fromType, toType);
        if (!isMoved) {
            log.error("物品移动失败，roleId={}, objectId={}", flowContext.getRoleId(), objectId);
            return false;
        }

        isMoved = storageService.moveItem(roleId, itemObject.getItemId(), fromType, toType);
        if (!isMoved) {
            log.error("物品移动失败，roleId={}, objectId={}", flowContext.getRoleId(), objectId);
            return false;
        }

        // 通知客户端
        var notify = new PbItemMovePackage();
        notify.sourceId = fromType;
        notify.targetId = toType;
        notify.objId = objectId;
        flowContext.broadcastMe(SCmd.ITEM_MOVE_PACKAGE, notify);
        return true;
    }

    public int isEquipWeapon(FlowContextEx flowContext, int position) {
        // 获取当前角色的法宝物品
        var itemList = this.itemObjectManager.getStorageItemList(flowContext.getRoleId(), ItemConstant.StorageType.WEAPONWEAR);
        for (ItemObject itemObject : itemList) {
            var table = TableManager.getTable(WeaponTable.class).get(itemObject.getItemIdx());
            if (table != null && table.getPosition() == position) {
                return itemObject.getObjId();
            }
        }
        return 0;
    }
}
