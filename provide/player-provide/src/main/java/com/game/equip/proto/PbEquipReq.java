package com.game.equip.proto;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.common.proto.PbIdValuePair;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbEquipReq {

    /**
     * 对象id
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer objId;

    /**
     * 穿戴位置
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer pos;

    /**
     * 装备id
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 3)
    List<PbIdValuePair> equipList;
}
