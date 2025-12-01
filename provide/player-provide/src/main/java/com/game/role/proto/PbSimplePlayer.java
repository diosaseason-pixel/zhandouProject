package com.game.role.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.common.proto.PbHead;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 简易玩家信息
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbSimplePlayer {

    /**
     * 玩家ID
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 1)
    Long id;

    /**
     * 用户ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer userId;

    /**
     * 服务器ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer serverId;

    /**
     * 玩家名称
     */
    @Protobuf(fieldType = FieldType.STRING, order = 4)
    String name;

    /**
     * 地图代码
     */
    @Protobuf(fieldType = FieldType.STRING, order = 5)
    String mapCode;

    /**
     * X坐标
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 6)
    Integer posX;

    /**
     * Y坐标
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 7)
    Integer posY;

    /**
     * X方向
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 8)
    Integer directionX;

    /**
     * Y方向
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 9)
    Integer directionY;

    /**
     * 性别
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 10)
    Integer sex;

    /**
     * 角色外观信息
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 11)
    PbHead head;

    /**
     * 等级
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 12)
    Integer level;

    /**
     * 经验
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 13)
    Long exp;

    /**
     * 钻石
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 14)
    Long diamond;

    /**
     * 绑定钻石
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 15)
    Long bindDiamond;

    /**
     * 金币
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 16)
    Long coin;

    /**
     * 绑定金币
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 17)
    Long bindCoin;

    /**
     * 最后在线时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 18)
    Long lastTime;

    /**
     * 创建时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 19)
    Long createTime;

    /**
     * 删除时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 20)
    Long deleteTime;

    /**
     * 模型ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 21)
    Integer modelId;

    /**
     * 忙碌状态
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 22)
    Integer busyStatus;

    /**
     * 公会名称
     */
    @Protobuf(fieldType = FieldType.STRING, order = 23)
    String guildName;

    /**
     * 骑乘状态
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 24)
    Integer rideState;

    /**
     * 称号ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 25)
    Integer titleId;

    /**
     * 仙晶
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 26)
    Long fairyCrystal;

    /**
     * 战斗力
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 27)
    Long combatValue;
}
