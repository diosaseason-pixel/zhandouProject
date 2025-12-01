package com.game.common.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.cmd.Code;
import com.game.common.FileMerge;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbBaseResp {

    /**
     * 错误码
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer code;

    @Protobuf(fieldType = FieldType.FIXED64, order = 2)
    Long value;

    @Protobuf(fieldType = FieldType.FIXED64, order = 3)
    Long value1;

    @Protobuf(fieldType = FieldType.FIXED64, order = 4)
    Long value2;

    public PbBaseResp() {
    }

    public PbBaseResp(int code) {
        this.code = code;
    }

    public static PbBaseResp ok() {
        return new PbBaseResp(Code.CODE_OK);
    }

    public static PbBaseResp error(int code) {
        return new PbBaseResp(code);
    }

}
