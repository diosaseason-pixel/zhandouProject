package com.game.common.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 玩家登录信息
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbLoginPlayer {

    /** 玩家ID */
    @Protobuf(fieldType = FieldType.FIXED64, order = 1)
    Long id;

    /** 用户ID */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer userId;

    /** 服务器ID */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer serverId;

    /** 玩家名称 */
    @Protobuf(fieldType = FieldType.STRING, order = 4)
    String name;

    /** 性别 */
    @Protobuf(fieldType = FieldType.UINT32, order = 5)
    Integer sex;

    /** 角色外观信息 */
    @Protobuf(fieldType = FieldType.OBJECT, order = 6)
    PbHead head;

    /** 等级 */
    @Protobuf(fieldType = FieldType.UINT32, order = 7)
    Integer level;

    /** 删除时间 */
    @Protobuf(fieldType = FieldType.FIXED64, order = 8)
    Long deleteTime;

    /** 创建时间 */
    @Protobuf(fieldType = FieldType.FIXED64, order = 9)
    Long createTime;

    /** 账号解冻时间 */
    @Protobuf(fieldType = FieldType.FIXED64, order = 10)
    Long unfreezeAccountTime;

    /** 发言解冻时间 */
    @Protobuf(fieldType = FieldType.FIXED64, order = 11)
    Long unfreezeSpeechTime;

    /** 地图代码 */
    @Protobuf(fieldType = FieldType.STRING, order = 12)
    String mapCode;

    /** 角色充值次数 */
    @Protobuf(fieldType = FieldType.UINT32, order = 13)
    Integer roleRechargeCount;
}
