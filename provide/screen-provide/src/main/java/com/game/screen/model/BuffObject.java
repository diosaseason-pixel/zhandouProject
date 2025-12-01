package com.game.screen.model;

import lombok.Data;

import java.util.List;

/**
 * @Date : 2025-04-20
 * @Author : Generated from Lua script
 * @Desc : Buff实体类
 */
@Data
public class BuffObject {
    private int buffId;         // Buff ID
    private int count;          // Buff叠加次数
    private long beginTime;     // 开始时间戳 (毫秒)
    private long endTime;       // 结束时间戳 (毫秒)
    private int fromObjId;      // 来源对象ID
    private int fromObjType;    // 来源对象类型
    private int level;          // Buff等级
    private int objId;          // 目标对象ID
    private int addValue;       // 附加值
    private List<Integer> affixAddValueArr; // 词缀附加值数组

    private BuffConfig config;  // Buff配置

    @Data
    public static class BuffConfig {
        private int id;        // 配置ID
        private int type;      // Buff类型
        private int buffType;  // Buff子类型
        private int timeComposition; // 持续时间组成类型
    }
}
