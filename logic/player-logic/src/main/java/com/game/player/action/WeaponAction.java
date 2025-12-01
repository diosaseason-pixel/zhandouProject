package com.game.player.action;

import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.common.annotation.IoThread;
import com.game.common.execl.TableManager;
import com.game.common.proto.PbBaseResp;
import com.game.common.proto.wrapper.UIntValue;
import com.game.equip.proto.PbEquipReq;
import com.game.ex.FlowContextEx;
import com.game.player.entity.PlayerEntity;
import com.game.player.manager.ItemObjectManager;
import com.game.player.region.ItemRegion;
import com.game.player.service.PlayerService;
import com.game.screen.client.BigScreenExchange;
import com.game.storage.constant.ItemConstant;
import com.game.storage.execl.WeaponTable;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ActionController(0)
@AllArgsConstructor
public class WeaponAction {

    private final ItemObjectManager itemObjectManager;
    private final PlayerService playerService;
    private final ItemRegion itemRegion;

    /**
     * 法宝穿戴
     */
    @IoThread
    @ActionMethod(CCmd.WEAPON_EQUIP)
    public PbBaseResp equipWeapon(PbEquipReq request, FlowContextEx flowContext) {
        // 处理装备武器的逻辑
        log.info("装备武器请求: {}", request);

        long roleId = flowContext.getRoleId();
        int objectId = request.getObjId();

        // 查找背包中的法宝物品
        var itemObject = itemObjectManager.findItemObject(roleId, ItemConstant.StorageType.PACKAGE, objectId);
        if (itemObject == null) {
            log.error("装备法术失败，物品不存在，roleId={}, objectId={}", roleId, objectId);
            return PbBaseResp.error(Code.CODE_PARAM_ERROR);
        }

        int itemIdx = itemObject.getItemIdx();
        // 获取法宝配置数据
        var itemData = TableManager.getTable(WeaponTable.class).get(itemIdx);
        if (itemData == null) {
            log.error("装备法术失败，物品数据不存在，roleId={}, objectId={}", roleId, objectId);
            return PbBaseResp.error(Code.CODE_PARAM_ERROR);
        }

        // 检查等级要求
        int needLevel = itemData.getNeedLv();
        PlayerEntity player = playerService.findPlayerById(roleId);
        if (player.getLevel() < needLevel) {
            return PbBaseResp.error(Code.CODE_LEVEL_LIMIT);
        }

        int equipId = itemRegion.isEquipWeapon(flowContext, itemData.getPosition());
        if (equipId != 0) {
            // 先将已穿戴的物品移动到背包
            itemRegion.moveItemAndNotify(flowContext, equipId, ItemConstant.StorageType.WEAPONWEAR, ItemConstant.StorageType.PACKAGE);
        }

        // 移动物品到装备位置
        itemRegion.moveItemAndNotify(flowContext, objectId, ItemConstant.StorageType.PACKAGE, ItemConstant.StorageType.WEAPONWEAR);

        // 发送属性变化通知
        BigScreenExchange.refreshRoleProperty(flowContext);
        return PbBaseResp.ok();
    }

    @IoThread
    @ActionMethod(CCmd.WEAPON_UNEQUIP)
    public PbBaseResp unequipWeapon(UIntValue intValue, FlowContextEx flowContext) {
        // 处理卸下武器的逻辑
        log.info("卸下武器请求: {}", intValue);

        long roleId = flowContext.getRoleId();
        int objectId = intValue.value;

        // 查找已装备的法宝物品
        var itemObject = itemObjectManager.findItemObject(roleId, ItemConstant.StorageType.WEAPONWEAR, objectId);
        if (itemObject == null) {
            log.error("卸下法术失败，物品不存在或未装备，roleId={}, objectId={}", roleId, objectId);
            return PbBaseResp.error(Code.CODE_PARAM_ERROR);
        }

        // 将物品从装备位置移动到背包
        itemRegion.moveItemAndNotify(flowContext, objectId, ItemConstant.StorageType.WEAPONWEAR, ItemConstant.StorageType.PACKAGE);

        // 发送属性变化通知
        BigScreenExchange.refreshRoleProperty(flowContext);
        return PbBaseResp.ok();
    }
}
