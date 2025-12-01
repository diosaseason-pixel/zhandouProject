package com.game.screen.factory;

import com.game.common.entity.PropEntity;
import com.game.common.execl.TableManager;
import com.game.common.model.SceneObject;
import com.game.common.utils.BattlePropUtils;
import com.game.ex.FlowContextEx;
import com.game.role.client.RoleExchange;
import com.game.role.execl.BornDestinyTable;
import com.game.role.execl.RoleTable;
import com.game.role.proto.PbInternalPlayer;
import com.game.screen.mapper.RoleObjectMapper;
import com.game.screen.model.RoleObject;
import com.game.storage.client.ItemExchange;
import com.game.storage.proto.PbInternalItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 角色对象工厂
 * 专门负责创建角色对象
 */
@Slf4j
@Component
public class RoleObjectFactory implements SceneObjectFactory {

    @Override
    public SceneObject createObject(int objId, FlowContextEx flowContext) {
        return createRoleObject(objId, flowContext);
    }

    /**
     * 创建角色对象
     *
     * @param objId       对象ID
     * @param flowContext 流程上下文
     * @return 角色对象
     */
    public RoleObject createRoleObject(int objId, FlowContextEx flowContext) {
        var roleInfo = RoleExchange.findRoleInfo(flowContext, flowContext.getRoleId());

        if (roleInfo == null) {
            log.error("创建RoleObject失败，roleInfo为空，roleId={}", flowContext.getRoleId());
            return null;
        }
        // 创建RoleObject实例
        RoleObject roleObject = RoleObjectMapper.ME.toRoleObject(roleInfo, objId);

        // 设置基础属性
        if (!calculateProp(flowContext, roleObject, roleInfo)) {
            log.error("计算角色属性失败，roleId={}", roleInfo.getId());
            return null;
        }

        // 最大血量 = baseHp + (baseHp * 血量百分百加成)
        int maxHp = roleObject.getBaseHp() + (roleObject.getBaseHp() * (roleObject.getHpPct() / 10000));
        roleObject.setHpMax(maxHp);
        roleObject.setCurHp(maxHp);

        // 当前Mp
        roleObject.setCurMp(maxHp);

        // 当前移动速度
        roleObject.setCurMoveSpeed(roleObject.getMoveSpeed());

        roleObject.setStatus(0);
        roleObject.setRet(0);
        return roleObject;
    }

    /**
     * 计算角色对象的属性
     */
    public boolean calculateProp(FlowContextEx flowContext, RoleObject roleObject, PbInternalPlayer player) {
        // 角色基础属性
        var roleTable = TableManager.getTable(RoleTable.class).get(roleObject.getLevel());
        if (roleTable == null) {
            log.error("角色表数据不存在，level={}", roleObject.getLevel());
            return false;
        }
        PropEntity baseProp = roleTable.getLevelProp();
        BattlePropUtils.addBattleProp(roleObject, baseProp);

        // 天命属性
        for (Integer destinyId : player.destiny) {
            var bornDestinyTable = TableManager.getTable(BornDestinyTable.class).get(destinyId);
            if (bornDestinyTable == null) {
                log.error("天命表数据不存在，destinyId={}", destinyId);
                return false;
            }
            PropEntity bornDestinyProp = bornDestinyTable.getProperties();
            BattlePropUtils.addBattleProp(roleObject, bornDestinyProp);
        }

        // 穿戴的法宝 基础属性
        var weaponList = ItemExchange.getEquipWeapon(flowContext);
        for (PbInternalItem pbItem : weaponList) {
            if (pbItem.getProp() != null) {
                BattlePropUtils.addBattleProp(roleObject, pbItem.getProp());
            }
        }
        return true;
    }
}