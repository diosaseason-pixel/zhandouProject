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
 * 待机反馈
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbBigScreenIdleResp {

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer m;

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer n;


    /**
     * 错误码
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer code;

    public PbBigScreenIdleResp() {}

    public PbBigScreenIdleResp(Integer m, Integer n, Integer code) {
        this.m = m;
        this.n = n;
        this.code = code;
    }
}
