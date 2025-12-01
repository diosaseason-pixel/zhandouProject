package com.game.screen.cmd;

import com.game.common.cmd.InternalCmdModule;
import com.iohao.game.action.skeleton.core.CmdInfo;

public interface BigScreenCmd {
    int cmd = InternalCmdModule.bigScreenCmd;
    /**
     * 获取登录角色列表
     */
    int prepareRoleData = 1001;

    /**
     * joinRoleScreen
     */
    int joinRoleScreen = 1002;

    /**
     * 刷新角色属性
     */
    int refreshRoleProperty = 1003;

    /**
     * 开始渡劫
     */
    int startRescue = 1004;

    static CmdInfo of(int subCmd) {
        return CmdInfo.of(cmd, subCmd);
    }
}
