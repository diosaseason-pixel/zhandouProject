package com.game.role.client;


import com.game.common.proto.PbLoginPlayer;
import com.game.ex.FlowContextEx;
import com.game.role.cmd.RoleCmd;
import com.game.role.proto.PbInternalPlayer;
import com.iohao.game.action.skeleton.protocol.wrapper.LongValue;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * 角色模块，对外提供的访问 api
 */
@UtilityClass
public class RoleExchange {

    /**
     * 获取登录角色列表
     */
    public List<PbLoginPlayer> getLoginPlayerList(FlowContextEx flowContext) {
        var cmd = RoleCmd.of(RoleCmd.getLoginPlayerList);
        var message = flowContext.invokeModuleMessage(cmd);
        return message.listValue(PbLoginPlayer.class);
    }

    /**
     * 获取角色信息
     */
    public PbInternalPlayer findRoleInfo(FlowContextEx flowContext, long roleId) {
        var cmd = RoleCmd.of(RoleCmd.findRoleInfo);
        var message = flowContext.invokeModuleMessage(cmd, LongValue.of(roleId));
        return message.getData(PbInternalPlayer.class);
    }

}
