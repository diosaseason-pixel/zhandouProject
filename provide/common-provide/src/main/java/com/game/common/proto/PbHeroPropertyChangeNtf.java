package com.game.common.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 角色属性改变
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbHeroPropertyChangeNtf {


    /** 角色属性 */
    @Protobuf(fieldType = FieldType.OBJECT, order = 1)
    PbObjProperty objProperty;

    @Protobuf(fieldType = FieldType.BOOL, order = 2)
    boolean isShow;

    public PbHeroPropertyChangeNtf() {

    }

    public PbHeroPropertyChangeNtf(PbObjProperty objProperty, boolean isShow) {
        this.objProperty = objProperty;
        this.isShow = isShow;
    }
}
