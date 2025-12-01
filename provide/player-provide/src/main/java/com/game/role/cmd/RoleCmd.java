package com.game.role.cmd;

import com.game.common.cmd.InternalCmdModule;
import com.iohao.game.action.skeleton.core.CmdInfo;

public interface RoleCmd {
    int cmd = InternalCmdModule.roleCmd;
    /** 获取登录角色列表 */
    int getLoginPlayerList = 1001;
    // 获取角色信息
    int findRoleInfo = 1002;

    static CmdInfo of(int subCmd) {
        return CmdInfo.of(cmd, subCmd);
    }
}
