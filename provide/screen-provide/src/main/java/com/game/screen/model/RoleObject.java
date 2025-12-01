package com.game.screen.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RoleObject extends HeroObject {
    // Buff列表
    private Map<Integer, BuffObject> buffMap = new HashMap<>();

    private int ret;  // 出现类型

    public RoleObject(int objId) {
        super(objId);
    }

}
