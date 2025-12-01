package com.game.storage.proto;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加物品内部请求
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbInternalItemList {

    /**
     * 物品列表
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 1)
    List<PbInternalItem> itemList = new ArrayList<>();

    public PbInternalItemList() {
    }

    public PbInternalItemList(List<PbInternalItem> itemList) {
        this.itemList = itemList;
    }
}
