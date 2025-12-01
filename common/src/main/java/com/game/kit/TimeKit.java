package com.game.kit;


import lombok.experimental.UtilityClass;

@UtilityClass
public class TimeKit {


    /**
     * 当前时间戳 秒
     */
    public int currentSecond() {
        return (int)(System.currentTimeMillis() / 1000);
    }

}
