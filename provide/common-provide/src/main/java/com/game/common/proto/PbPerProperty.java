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
 * @Date : 2025-04-20
 * @Author : Generated from Lua script
 * @Desc : 属性类
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbPerProperty {

//    message .base.PerProperty {
//        int32 properCode = 1;
//        fixed64 intValue = 2;
//        bytes strValue = 3;
//    }

    /**
     * 属性代码
     */
    @Protobuf(fieldType = FieldType.INT32, order = 1)
    Integer properCode;

    /**
     * 整数值
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 2)
    Long intValue;

    /**
     * 字符串值
     */
    @Protobuf(fieldType = FieldType.STRING, order = 3)
    String strValue;

    public PbPerProperty() {

    }

    public PbPerProperty(int properCode, long intValue) {
        this.properCode = properCode;
        this.intValue = intValue;
    }

    public PbPerProperty(int properCode, String strValue) {
        this.properCode = properCode;
        this.strValue = strValue;
    }

}
