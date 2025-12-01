package com.game.screen.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 待机
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbBigScreenObjIdle {

    /**
     * objectId
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer objId;

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer m;

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer n;

    /**
     * 朝向
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer direction;
}

