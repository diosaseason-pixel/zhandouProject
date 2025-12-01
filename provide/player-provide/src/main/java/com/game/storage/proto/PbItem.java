package com.game.storage.proto;


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
public class PbItem {
    /** 物品Id */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer objId;

    /** 物品数量 */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer num;

    /** 参数 */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer args;

}
