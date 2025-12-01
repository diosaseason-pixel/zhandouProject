package com.game.storage.proto;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.common.proto.PbObjProperty;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

/**
 * 背包物品
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbPackageItemNtf {

    /**
     * 包裹Id
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer parcelId;


    /**
     * 物品列表
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 2)
    List<PbObjProperty> itemList = new ArrayList<>();
}
