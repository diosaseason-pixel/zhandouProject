package com.game.rescue.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbGetRescueNtf {

    /**
     * 渡劫信息
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 1)
    PbRescue rescue;

    /**
     * 加入渡劫信息
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 2)
    PbJoinRescue joinRescue;

}
