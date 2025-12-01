package com.game.player.entity;

import com.game.common.entity.PropEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 玩家信息实体类
 */
@Data
@Document(collection = "player_info")
@FieldDefaults(level = AccessLevel.PRIVATE)
@CompoundIndexes({
        @CompoundIndex(name = "userId_serverId_idx", def = "{'userId': 1, 'serverId': 1}")
})
public class PlayerEntity {
    public static final String SEQUENCE_NAME = "player_info_sequence";

    /**
     * 玩家ID
     */
    @Id
    private long id;

    /**
     * 用户ID
     */
    private int userId;

    /**
     * 服务器ID
     */
    private int serverId;

    /**
     * 玩家名称
     */
    @Indexed(unique = true, name = "name_idx")
    private String name;

    /**
     * 地图代码
     */
    private String mapCode;

    /**
     * X坐标
     */
    private int posX;

    /**
     * Y坐标
     */
    private int posY;

    /**
     * X方向
     */
    private int directionX;

    /**
     * Y方向
     */
    private int directionY;

    /**
     * 性别
     */
    private int sex;

    /**
     * 头像信息
     */
    private HeadEntity head;

    /**
     * 等级
     */
    private int level;

    /**
     * 经验值
     */
    private long exp;

    /**
     * 钻石
     */
    private long diamond;

    /**
     * 绑定钻石
     */
    private long bindDiamond;

    /**
     * 金币
     */
    private long coin;

    /**
     * 绑定金币
     */
    private long bindCoin;

    /**
     * 最后登录时间
     */
    private long lastTime;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 删除时间
     */
    private long deleteTime;

    /**
     * 账号解冻时间
     */
    private long unfreezeAccountTime;

    /**
     * 发言解冻时间
     */
    private long unfreezeSpeechTime;

    /**
     * 版本号
     */
    private long version;

    /**
     * 仙玉
     */
    private long payCoin;

    /**
     * 绑定仙玉
     */
    private long fairyCrystal;

    /**
     * 战斗力
     */
    private long combatValue;

    /**
     * 角色充值次数
     */
    private int roleRechargeCount;

    /**
     * 气运
     */
    private List<Integer> destiny;

    /**
     * 健康值
     */
    private int healthy;

    /**
     * 初始属性
     */
    private PropEntity prop;

}
