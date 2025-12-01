package com.game.player.action;


import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.common.annotation.IoThread;
import com.game.common.execl.MetaWrapItem;
import com.game.common.execl.TableManager;
import com.game.common.proto.PbBaseResp;
import com.game.ex.FlowContextEx;
import com.game.player.entity.ItemEntity;
import com.game.player.entity.PlayerEntity;
import com.game.player.region.ItemRegion;
import com.game.player.service.PlayerService;
import com.game.player.service.StorageService;
import com.game.role.execl.RoleTable;
import com.game.screen.client.BigScreenExchange;
import com.game.storage.constant.ItemConstant;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 角色升级
 */
@Slf4j
@Component
@ActionController(0)
public class UpdateLevelAction {

    @Resource
    PlayerService playerService;

    @Resource
    StorageService storageService;

    @Resource
    ItemRegion itemRegion;

    /**
     * 角色升级
     */
    @IoThread
    @ActionMethod(CCmd.UPDATE_LV)
    public PbBaseResp updateLevel(FlowContextEx flowContext) {
        // 1. 扣除物品
        var response = this.reduceLevelUpItem(flowContext);
        if (response.code != Code.CODE_OK) {
            return response;
        }

        // 2. 升级
        playerService.levelUp(flowContext.getRoleId(), 1);
        log.info("角色升级成功，roleId={}", flowContext.getRoleId());

        // 发送属性变化通知
        BigScreenExchange.refreshRoleProperty(flowContext);
        return PbBaseResp.ok();
    }

    /**
     * 开始渡劫
     */
    @IoThread
    @ActionMethod(CCmd.RESCUE_START)
    public PbBaseResp rescueStart(FlowContextEx flowContext) {
        // 1. 扣除物品
        var response = this.reduceLevelUpItem(flowContext);
        if (response.code != Code.CODE_OK) {
            return response;
        }

        // 通知场景服务器开始渡劫
        BigScreenExchange.startRescue(flowContext);
        return PbBaseResp.ok();
    }

    /**
     * 角色升级 扣除物品
     */
    private PbBaseResp reduceLevelUpItem(FlowContextEx flowContext) {
        var roleId = flowContext.getRoleId();
        var role = playerService.findPlayerById(roleId);
        if (role == null) {
            log.error("角色升级失败，角色不存在，roleId={}", roleId);
            return PbBaseResp.error(Code.CODE_ERROR);
        }

        int currentLevel = role.getLevel();
        int needExp = this.queryLvUpNeedExp(currentLevel);

        if (needExp == 0) {
            log.error("已经满级了 {}", currentLevel);
            return PbBaseResp.error(Code.CODE_ERROR);
        }

        // 2. 经验是否足够
        if (role.getExp() < needExp) {
            log.error("角色升级失败，角色等级数据经验不足，roleId={}, currentLevel={}, needExp={}", roleId, currentLevel, needExp);
            return PbBaseResp.error(Code.CODE_ERROR);
        }

        // 3. 背包内是否有足够的物品
        MetaWrapItem needItem = this.queryLvUpNeedItem(role);
        if (needItem == null) {
            log.error("角色升级失败，角色物品不足，roleId={}, currentLevel={}, needItem={}", roleId, currentLevel, needItem);
            return PbBaseResp.error(Code.CODE_ITEM_COUNT_NOT_ENOUGH);
        }

        // 4. 扣除物品
        boolean success = itemRegion.reduceItemAndNotify(flowContext, needItem.getItemIdx(), needItem.getItemNum());
        if (!success) {
            log.error("角色升级失败，扣除物品失败，roleId={}, currentLevel={}, needItem={}", roleId, currentLevel, needItem);
            return PbBaseResp.error(Code.CODE_ERROR);
        }
        return PbBaseResp.ok();
    }

    /**
     * 升级所需材料物品是否足够
     */
    private MetaWrapItem queryLvUpNeedItem(PlayerEntity role) {
        int currentLevel = role.getLevel();
        var curLvMeta = TableManager.getTable(RoleTable.class).get(currentLevel);
        if (curLvMeta == null) {
            log.error("查询升级所需物品失败，角色等级数据不存在，level={}", currentLevel);
            return null;
        }

        var needItem = curLvMeta.getNeedItem().getFirst();
        if (ItemConstant.PropIdx.Coin == needItem.getItemIdx()) {
            // 3.1 需要消耗金币
            long currentCoin = role.getCoin() + role.getBindCoin();
            if (currentCoin < needItem.getItemNum()) {
                log.error("角色升级失败，角色金币不足，roleId={}, currentLevel={}, needCoin={}", role.getId(), currentLevel, needItem.getItemNum());
                return null;
            }
        } else {
            // 3.2 需要消耗物品
            var itemList = storageService.getStorageItems(role.getId(), ItemConstant.StorageType.PACKAGE);
            var items = itemList.stream().filter(i -> i.getItemIdx() == needItem.getItemIdx()).toList();

            // 物品是否存在
            if (items.isEmpty()) {
                log.error("角色升级失败，角色物品不存在，roleId={}, currentLevel={}, needItem={}", role.getId(), currentLevel, needItem);
                return null;
            }

            // 物品数量是否足够
            int totalCount = items.stream().mapToInt(ItemEntity::getCount).sum();
            if (totalCount < needItem.getItemNum()) {
                log.error("角色升级失败，角色物品不足，roleId={}, currentLevel={}, needItem={}, hasCount={}", role.getId(), currentLevel, needItem, totalCount);
                return null;
            }
        }

        return needItem;
    }

    /**
     * 查询升级所需经验
     */
    private int queryLvUpNeedExp(int level) {
        var curLvMeta = TableManager.getTable(RoleTable.class).get(level);
        if (curLvMeta == null) {
            log.error("查询升级所需经验失败，角色等级数据不存在，level={}", level);
            return 0;
        }

        var curNeedExp = curLvMeta.getNeedExp();
        if (curNeedExp == 0) {
            log.error("升级失败, 已经满级了 {}", level);
            return 0;
        }
        return curNeedExp;
    }


}
