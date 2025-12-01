package com.game.storage.proto;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.common.entity.PropEntity;
import com.game.common.execl.MetaWrapItem;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 添加物品内部请求
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbInternalItem {
    /**
     * 物品Id
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer itemIdx;

    /**
     * 物品数量
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer count;

    /**
     * 物品类型
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer itemType;

    /**
     * 物品绑定
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer bind;

    /**
     * 装备属性
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 5)
    PropEntity prop;

    public static PbInternalItem of(MetaWrapItem item) {
        var commonItem = new PbInternalItem();
        commonItem.setItemIdx(item.getItemIdx());
        commonItem.setCount(item.getItemNum());
        commonItem.setItemType(item.getItemType());
        commonItem.setBind(item.getItemBind());
        return commonItem;
    }
}
