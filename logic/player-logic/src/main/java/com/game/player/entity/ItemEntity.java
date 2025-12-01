package com.game.player.entity;


import com.game.common.entity.PropEntity;
import lombok.Data;

@Data
public class ItemEntity {
    /**
     * 道具ID
     */
    int itemIdx;

    /**
     * 物品流水号
     */
    String itemId;

    /**
     * 物品数量
     */
    int count;

    /**
     * 物品类型
     */
    int itemType;

    /**
     * 是否绑定
     */
    int bind;

    /**
     * 法宝随机属性
     */
    PropEntity prop;

    /**
     * 创建时间
     */
    int createTime;
}
