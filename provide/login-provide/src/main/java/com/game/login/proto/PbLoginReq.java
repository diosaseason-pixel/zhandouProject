package com.game.login.proto;


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
public class PbLoginReq {

    /**
     * 用户id
     */
    @Protobuf(fieldType = FieldType.STRING, order = 1)
    String uuid;

    /**
     * token
     */
    @Protobuf(fieldType = FieldType.STRING, order = 2)
    String token;

    /**
     * 设备id
     */
    @Protobuf(fieldType = FieldType.STRING, order = 3)
    String deviceNo;

    /**
     * 服务器Id
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer serviceId;
}
