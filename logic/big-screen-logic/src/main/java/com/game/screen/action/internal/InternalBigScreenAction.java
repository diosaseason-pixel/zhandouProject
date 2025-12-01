package com.game.screen.action.internal;

import com.game.attr.Attr;
import com.game.cmd.SCmd;
import com.game.common.annotation.IoThread;
import com.game.common.proto.PbBaseResp;
import com.game.common.proto.PbHeroPropertyChangeNtf;
import com.game.common.proto.PbObjProperty;
import com.game.common.proto.PbPerProperty;
import com.game.ex.FlowContextEx;
import com.game.role.proto.PbAppearMapPropertyNtf;
import com.game.screen.cmd.BigScreenCmd;
import com.game.screen.factory.SceneObjectFactoryRegistry;
import com.game.screen.manager.PlayerObjectManager;
import com.game.screen.manager.ScreenManager;
import com.game.screen.model.RoleObject;
import com.game.screen.proto.PbBigScreenObjAppearNtf;
import com.game.screen.util.SceneObjectProtoUtil;
import com.google.common.collect.Lists;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.protocol.wrapper.IntValue;
import com.iohao.game.widget.light.room.flow.GameFlowContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@ActionController(BigScreenCmd.cmd)
public class InternalBigScreenAction {

    @Resource
    private ScreenManager screenManager;

    @Resource
    private SceneObjectFactoryRegistry factoryRegistry;

    @Resource
    private PlayerObjectManager playerObjectManager;

    /**
     * 准备角色数据
     */
    @IoThread
    @ActionMethod(BigScreenCmd.prepareRoleData)
    public void prepareRoleData(FlowContextEx flowContext) {
        long userId = flowContext.getUserId();
        int serverId = flowContext.getServerId();

        // 使用工厂创建角色对象，传入角色ID
        int objId = 307295146; // 这个ID可能需要从其他地方获取
        RoleObject player = factoryRegistry.createRoleObject(objId, flowContext);
        log.info("joinRoleScreen, userId={}, serverId={} player={}", userId, serverId, player);

        // 将角色对象添加到PlayerManager中
        flowContext.setObjectId(objId);
        playerObjectManager.addPlayer(flowContext.getRoleId(), player);

        var proto = SceneObjectProtoUtil.toProto(player);

        // 推送给客户端
        flowContext.broadcastMe(SCmd.HERO_DATA_INFO, proto);
    }

    /**
     * 加入到场景中
     */
    @IoThread
    @ActionMethod(BigScreenCmd.joinRoleScreen)
    public void joinRoleScreen(FlowContextEx flowContext, IntValue mapCode) {
        var player = playerObjectManager.getPlayer(flowContext.getRoleId());
        if (player == null) {
            this.prepareRoleData(flowContext);
            player = playerObjectManager.getPlayer(flowContext.getRoleId());
        }

        // 角色对象加入到场景中
        var room = screenManager.getOrCreateScreen(mapCode.value);
        GameFlowContext gameFlowContext = GameFlowContext.of(room, flowContext);
        screenManager.enterRoom(gameFlowContext);

        // 发送地图属性通知
        PbAppearMapPropertyNtf mapPropertyNtf = new PbAppearMapPropertyNtf();
        mapPropertyNtf.setMapCode("1000");
        mapPropertyNtf.setMapName("清风山");
        flowContext.broadcastMe(SCmd.APPEAR_MAP_PROPERTY, mapPropertyNtf);

        // 角色出现 通知
        var notify = new PbBigScreenObjAppearNtf();
        notify.objId = player.getObjId();
        notify.objType = 1;
        notify.ret = player.getRet();
        notify.m = player.getMapPosX();
        notify.n = player.getMapPosY();
        notify.direction = 3;

        room.broadcastRange(SCmd.WHOLE_OBJ_APPEAR, notify);
    }

    /**
     * 刷新角色属性
     */
    @ActionMethod(BigScreenCmd.refreshRoleProperty)
    public PbBaseResp refreshRoleProperty(FlowContextEx flowContext) {
        // 角色对象
        var roleObject = playerObjectManager.getPlayer(flowContext.getRoleId());

        // 重新创建角色对象, 重新加载属性
        RoleObject newRole = factoryRegistry.createRoleObject(flowContext.getObjectId(), flowContext);

        // 获取变化的属性
        var oldProperty = SceneObjectProtoUtil.toProto(roleObject);
        var newProperty = SceneObjectProtoUtil.toProto(newRole);

        log.info("old {} new {}", roleObject.getAc(), newRole.getAc());

        // 创建一个只包含变化属性的PbObjProperty对象
        var property = new PbObjProperty();
        property.objId = newRole.getObjId();
        property.objType = newRole.getObjectType();

        // 比较新旧属性，找出变化的属性
        for (PbPerProperty newProp : newProperty.getObjProps()) {
            PbPerProperty oldProp = oldProperty.isContains(newProp.getProperCode());
            if (oldProp == null || !Objects.equals(oldProp.intValue, newProp.intValue)) {
                // 属性不存在或者值发生变化，添加到变化列表
                property.addProperty(newProp);
            }
        }

        if (property.objProps.isEmpty()) {
            return PbBaseResp.ok();
        }

        // 更新角色对象
        playerObjectManager.addPlayer(flowContext.getRoleId(), newRole);

        // 发送属性变化通知
        var notify = new PbHeroPropertyChangeNtf();
        notify.isShow = true;
        notify.objProperty = property;
        flowContext.broadcastMe(SCmd.HERO_ATTR_CHANGE, notify);

        // 发送外观改变通知
        this.checkAppearanceChange(flowContext, property);
        return PbBaseResp.ok();
    }

    /**
     * 开始渡劫
     */
    public PbBaseResp startRescue(FlowContextEx flowContext) {
        // 角色对象
        var roleObject = playerObjectManager.getPlayer(flowContext.getRoleId());


        return PbBaseResp.ok();
    }

    /**
     * 对象外观改变
     */
    public void checkAppearanceChange(FlowContextEx flowContext, PbObjProperty property) {
        // 检查一下外观是否变更
        List<Integer> properCodes = Lists.newArrayList(
                Attr.Hero.Eye,
                Attr.Hero.HairId,
                Attr.Hero.BodyId,
                Attr.Hero.ModelId,
                Attr.Hero.FashionSuit,
                Attr.Hero.FashionHair,
                Attr.Hero.FashionFaceDecoration,
                Attr.Hero.FashionClothes,
                Attr.Hero.RescueStatus,
                Attr.Hero.JoinRescueStatus,
                Attr.Hero.GuildName,
                Attr.Hero.GuildOfficeId,
                Attr.Hero.CurHeroTitleId,
                Attr.Hero.RideState,
                Attr.Hero.RideId,
                Attr.Hero.EquipSelfMagicShow,
                Attr.Hero.PetCatchStatus,
                Attr.Hero.DisplayName,

                Attr.Hero.Level,
                Attr.Hero.HpMax,
                Attr.Hero.CurHp,
                Attr.Hero.MpMax,
                Attr.Hero.CurMp
        );

        PbObjProperty changeProperty = new PbObjProperty();
        property.getObjProps().forEach(prop -> {
            if (properCodes.contains(prop.getProperCode())) {
                changeProperty.addProperty(prop);
            }
        });

        if (changeProperty.getObjProps().isEmpty()) {
            return;
        }

        // 发送外观改变通知
        changeProperty.objId = property.objId;
        changeProperty.objType = property.objType;
        flowContext.broadcastMe(SCmd.OBJ_APPEARANCE_CHANGE, changeProperty);
    }


}
