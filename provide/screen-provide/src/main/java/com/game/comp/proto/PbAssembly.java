package com.game.comp.proto;


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
public class PbAssembly {

    /**
     * 类型
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer type;

    /**
     * ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer id;
}
