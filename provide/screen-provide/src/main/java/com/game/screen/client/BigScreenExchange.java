package com.game.screen.client;


import com.game.ex.FlowContextEx;
import com.game.screen.cmd.BigScreenCmd;
import com.iohao.game.action.skeleton.protocol.wrapper.IntValue;
import lombok.experimental.UtilityClass;

/**
 * 大地图模块，对外提供的访问 api
 */
@UtilityClass
public class BigScreenExchange {

    public void prepareRoleData(FlowContextEx flowContext) {
        var cmd = BigScreenCmd.of(BigScreenCmd.prepareRoleData);
        flowContext.invokeModuleVoidMessage(cmd);
    }

    public void joinRoleScreen(FlowContextEx flowContext, int mapCode) {
        var cmd = BigScreenCmd.of(BigScreenCmd.joinRoleScreen);
        flowContext.invokeModuleVoidMessage(cmd, IntValue.of(mapCode));
    }

    /**
     * 所有涉及到刷新角色属性的地方都要调用这个方法
     * Action 需要加上  @IoThread
     */
    public static void refreshRoleProperty(FlowContextEx flowContext) {
        var cmd = BigScreenCmd.of(BigScreenCmd.refreshRoleProperty);
        flowContext.invokeModuleMessage(cmd);
    }

    /**
     * 开始渡劫
     */
    public static void startRescue(FlowContextEx flowContext) {
        var cmd = BigScreenCmd.of(BigScreenCmd.startRescue);
        flowContext.invokeModuleMessage(cmd);
    }

}
