package com.game.rescue.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.role.proto.PbSimplePlayer;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * 渡劫信息
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbRescue {

    /**
     * 状态
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Long status;

    /**
     * 帮助渡劫的玩家列表
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 2)
    List<PbSimplePlayer> helpPlayerArray;

    /**
     * 抢劫 渡劫的玩家列表
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 3)
    List<PbSimplePlayer> grabPlayerArray;

    /**
     * 气运列表
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    List<Integer> destinyIdArray;

    /**
     * 开始时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 5)
    Long startTime;

    /**
     * 成功概率
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 6)
    Integer successRate;

    /**
     * 地图代码
     */
    @Protobuf(fieldType = FieldType.STRING, order = 7)
    String mapCode;

    /**
     * 坐标
     */
    @Protobuf(fieldType = FieldType.FIXED32, order = 8)
    Float x;

    /**
     * 坐标
     */
    @Protobuf(fieldType = FieldType.FIXED32, order = 9)
    Float y;

    /**
     * 渡劫的人
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 10)
    PbSimplePlayer rescuer;

    /**
     * 开始时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 11)
    Long beginTime;

    /**
     * 帮助渡劫 对象Id列表
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 12)
    List<Integer> helpPlayerObjIdArray;


    /**
     * 抢劫渡劫 对象Id列表
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 13)
    List<Integer> grabPlayerObjIdArray;

    /**
     * 渡劫 对象Id列表
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 14)
    Integer rescuerObjId;


}
