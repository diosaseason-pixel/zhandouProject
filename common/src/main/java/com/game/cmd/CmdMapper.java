package com.game.cmd;


import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CmdMapper {

    public static final Map<Integer, Integer> C2S_MAP = new HashMap<>();

    static {
        // 这里添加 CCmd 到 SCmd 的映射关系
        C2S_MAP.put(CCmd.HEARTBEAT, SCmd.HEARTBEAT);
        C2S_MAP.put(CCmd.USER_LOGIN, SCmd.USER_LOGIN);
        C2S_MAP.put(CCmd.CREATE_ROLE, SCmd.CREATE_ROLE);
        C2S_MAP.put(CCmd.ROLE_LOGIN, SCmd.ROLE_LOGIN);
        C2S_MAP.put(CCmd.WHOLE_IDLE, SCmd.WHOLE_IDLE);
        C2S_MAP.put(CCmd.WHOLE_MOVE, SCmd.WHOLE_MOVE);
        C2S_MAP.put(CCmd.SYS_SETING, SCmd.SYS_SETING);
        C2S_MAP.put(CCmd.UPDATE_LV, SCmd.UPDATE_LV);
        C2S_MAP.put(CCmd.RESCUE_START, SCmd.RESCUE_START);
        C2S_MAP.put(CCmd.SIGN_IN, SCmd.SIGN_IN);
        C2S_MAP.put(CCmd.PERSONAL_COMP_LIST, SCmd.PERSONAL_COMP_LIST);
        C2S_MAP.put(CCmd.WEAPON_EQUIP, SCmd.WEAPON_EQUIP);
        C2S_MAP.put(CCmd.WEAPON_UNEQUIP, SCmd.WEAPON_UNEQUIP);
        C2S_MAP.put(CCmd.FINISH_PERSONAL_COMP, SCmd.FINISH_PERSONAL_COMP);
    }

}
