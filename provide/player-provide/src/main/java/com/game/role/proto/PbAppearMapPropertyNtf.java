package com.game.role.proto;


import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbAppearMapPropertyNtf {

//    string mapCode = 1;
//    string mapName = 2;
//    uint32 mapProperty = 3;
//    fixed64 endTime = 4;
//    fixed64 prepareEndTime = 5;
//    uint32 battleType = 6;
//    uint32 heroSkillIdArray = 7;
//    uint32 monsterSkillIdArray = 8;
//    uint32 againChallenge = 9;

    /**
     * 地图代码
     */
    @Protobuf(fieldType = FieldType.STRING, order = 1)
    String mapCode;

    /**
     * 地图名称
     */
    @Protobuf(fieldType = FieldType.STRING, order = 2)
    String mapName;

    /**
     * 地图属性
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer mapProperty;

    /**
     * 结束时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 4)
    Long endTime;

    /**
     * 准备结束时间
     */
    @Protobuf(fieldType = FieldType.FIXED64, order = 5)
    Long prepareEndTime;

    /**
     * 战斗类型
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 6)
    Integer battleType;

    /**
     * 英雄技能ID数组
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 7)
    List<Integer> heroSkillIdArray;

    /**
     * 怪物技能ID数组
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 8)
    List<Integer> monsterSkillIdArray;

    /**
     * 再次挑战
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 9)
    Integer againChallenge;
}
