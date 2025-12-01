package com.game.screen.proto;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.game.common.proto.PbPerProperty;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 大世界 对象出现
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbBigScreenObjAppearNtf {

//    message com.yofijoy.core.proto.CS_BigScreenObjAppearNtf {
//        uint32 objId = 1;
//        uint32 objType = 2;
//        uint32 ret = 3;
//        uint32 m = 4;
//        uint32 n = 5;
//        uint32 direction = 6;
//        uint32 status = 7;
//  .base.PerProperty objprops = 8;
//        com.yofijoy.core.proto.spot moveList = 9;
//    }

    /**
     * 对象ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer objId;

    /**
     * 对象类型
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer objType;

    /**
     * 返回值
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer ret;

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 4)
    Integer m;

    /**
     * 坐标点
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 5)
    Integer n;

    /**
     * 方向
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 6)
    Integer direction;

    /**
     * 状态
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 7)
    Integer status;

    /**
     * 属性
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 8)
    PbPerProperty objProps;

    /**
     * 移动列表
     */
    @Protobuf(fieldType = FieldType.OBJECT, order = 9)
    Spot moveList;
}
