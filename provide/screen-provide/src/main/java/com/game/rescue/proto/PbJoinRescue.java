package com.game.rescue.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 加入渡劫信息
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbJoinRescue {

    /**
     * 状态
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer status;

    /**
     * 帮助渡劫的玩家数量
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer helpCount;

    /**
     * 抢劫 渡劫的玩家数量
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer grabCount;

    /**
     * 加入类型
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer joinType;

    /**
     * 渡劫者ID
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 5)
    Long rescuerId;

    /**
     * 上次开始时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 6)
    Long lastStartTime;

    /**
     * 渡劫阶段
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 7)
    Integer rescuerStage;
}
