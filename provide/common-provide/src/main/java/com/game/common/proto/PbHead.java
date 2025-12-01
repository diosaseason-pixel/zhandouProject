package com.game.common.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * 角色头部/外观信息
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbHead {

    /** 发型 */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer hair;

    /** 身体类型 */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer body;

    /** 脸型 */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer faceShape;

    /** 眉毛 */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer eyeBrow;

    /** 眼睛 */
    @Protobuf(fieldType = FieldType.UINT32, order = 5)
    Integer eye;

    /** 鼻子 */
    @Protobuf(fieldType = FieldType.UINT32, order = 6)
    Integer nose;

    /** 嘴巴 */
    @Protobuf(fieldType = FieldType.UINT32, order = 7)
    Integer mouth;

    /** 面部装饰 */
    @Protobuf(fieldType = FieldType.UINT32, order = 8)
    Integer faceDecoration;

    /** 模型ID */
    @Protobuf(fieldType = FieldType.UINT32, order = 9)
    Integer modelId;

    /** 时装数组 */
    @Protobuf(fieldType = FieldType.UINT32, order = 10)
    List<Integer> fashionArr;

    /** 性别 */
    @Protobuf(fieldType = FieldType.UINT32, order = 11)
    Integer sex;
}
