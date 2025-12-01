package com.game.role.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.common.proto.PbLoginPlayer;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbCreateRoleResp {

    /**
     * 错误码
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer code;


    /**
     * 角色信息
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 2)
    PbLoginPlayer player;

}
