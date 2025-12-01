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
 * 物品变更通知
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbItemChangeNtf {

    /**
     * 消息Id
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer msgId;

    /**
     * 消息变更
     **/
    @Protobuf(fieldType = FieldType.OBJECT, order = 2)
    List<PbObjProperty> changeItem = new ArrayList<>();

    /**
     * 物品
     **/
    @Protobuf(fieldType = FieldType.OBJECT, order = 3)
    List<PbItem> changeCommonItem = new ArrayList<>();


}
