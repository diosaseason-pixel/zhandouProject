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

/**
 * 选择角色
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbRoleLoginResp {

    /**
     * code
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer code;

    /**
     * 频道Id
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer lineId;

    /**
     * 角色信息
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 3)
    PbLoginPlayer player;


}
