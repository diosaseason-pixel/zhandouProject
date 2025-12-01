package com.game.login.proto;

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
public class PbRoleListResp {

    /**
     * 状态码
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer code;

    /**
     * 角色列表
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 2)
    List<PbLoginPlayer> loginPlayerArray;

    /**
     * 特权卡ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer privilegeCardId;

    /**
     * 充值道具数量
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer rechargeItemCount;

    /**
     * 游戏内角色ID
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 5)
    Long inGamePlayerId;
}
