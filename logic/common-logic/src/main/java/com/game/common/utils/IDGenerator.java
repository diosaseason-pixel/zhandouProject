package com.game.common.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ID生成器工具类
 * 负责生成各种类型的唯一ID
 */
public class IDGenerator {

    private IDGenerator() {
        // 私有构造函数，防止实例化
    }
    
    // 用于生成物品对象ID的计数器
    private static final AtomicInteger OBJECT_ID_GENERATOR = new AtomicInteger(1);
    
    /**
     * 生成唯一的物品对象ID
     * 
     * @return 新生成的物品对象ID
     */
    public static int generateObjectId() {
        return OBJECT_ID_GENERATOR.getAndIncrement();
    }

} 