package com.game.storage.cmd;

import com.game.common.cmd.InternalCmdModule;
import com.iohao.game.action.skeleton.core.CmdInfo;

public interface ItemCmd {
    int cmd = InternalCmdModule.itemCmd;
    // 添加物品
    int addPackageItem = 1001;
    // 获取已穿戴的法术
    int getEquipWeapon = 1005;

    static CmdInfo of(int subCmd) {
        return CmdInfo.of(cmd, subCmd);
    }
}
