package com.game.role.proto;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
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
public class PbRoleLoginReq {

    /**
     * 玩家ID
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 1)
    Long playerId;


    /**
     * 玩家ID
     */
    @Protobuf(fieldType = FieldType.STRING, order = 2)
    String uuid;

    /**
     * userId
     */
    @Protobuf(fieldType = FieldType.INT32, order = 3)
    Integer userId;

    /**
     * reconnect
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer reconnect;


}
