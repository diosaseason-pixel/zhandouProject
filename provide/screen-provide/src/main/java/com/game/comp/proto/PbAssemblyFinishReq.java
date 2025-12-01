package com.game.comp.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 请求完成组装
 */
@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbAssemblyFinishReq {
    
    /**
     * 类型
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer type;
    
    /**
     * ID
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 2)
    Integer id;
    
    /**
     * 参数
     */
    @Protobuf(fieldType = FieldType.UINT32, order = 3)
    Integer param;
}
