package com.game.role.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.common.proto.PbHead;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbCreateRoleReq {

    /**
     * 名字
     */
    @Protobuf(fieldType = FieldType.STRING, order = 1)
    String name;

    /**
     * 性别
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer sex;


    /**
     * 角色外观信息
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 3)
    PbHead head;

    /**
     * 天命
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    List<Integer> destinyArray;

}
