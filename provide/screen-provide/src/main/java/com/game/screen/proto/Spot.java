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
 * 坐标点
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class Spot {

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer newM;

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer newN;

}
