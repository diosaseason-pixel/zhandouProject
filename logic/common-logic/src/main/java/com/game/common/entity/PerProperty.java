package com.game.common.entity;

import lombok.Data;

@Data
public class PerProperty {
    /**
     * 属性Id
     */
    int properCode;

    /**
     * 整数值
     */
    long intValue;

    /**
     * 字符串值
     */
    String strValue;
}
