package com.game.common.proto;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.game.common.FileMerge;
import com.iohao.game.widget.light.protobuf.ProtoFileMerge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
@ProtoFileMerge(fileName = FileMerge.fileName, filePackage = FileMerge.filePackage)
public class PbObjProperty {

    //    message .base.ObjProperty {
//        uint32 objId = 1;
//        int32 objType = 2;
//  .base.PerProperty objprops = 3;
//    }

    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    Integer objId;

    @Protobuf(fieldType = FieldType.INT32, order = 2)
    Integer objType;

    @Protobuf(fieldType = FieldType.OBJECT, order = 3)
    List<PbPerProperty> objProps = new ArrayList<>();


    public void addProperty(PbPerProperty other) {
        var property = this.isContains(other.properCode);
        if (property != null) {
            this.objProps.remove(property);
        }
        this.objProps.add(other);
    }

    public void addProperty(int propertyCode, long value) {
        this.objProps.add(new PbPerProperty(propertyCode, value));
    }


    public PbPerProperty isContains(int propertyCode) {
        for (PbPerProperty property : objProps) {
            if (property.getProperCode() == propertyCode) {
                return property;
            }
        }
        return null;
    }
}
