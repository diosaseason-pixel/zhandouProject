package com.game.comp.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbAssemblyList {

    /**
     * 是否已完成
     */
    @Protobuf(fieldType = FieldType.BOOL, order = 1)
    Boolean useFinish = false;

    /**
     * 类型
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer type;

    /**
     * ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    List<Integer> ids = Lists.newArrayList();
}
