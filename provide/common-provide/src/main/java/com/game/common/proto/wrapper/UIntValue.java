package com.game.common.proto.wrapper;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.iohao.game.action.skeleton.protocol.wrapper.IntValue;
import lombok.ToString;

@ToString
@ProtobufClass
public class UIntValue {

    @Protobuf(fieldType = FieldType.UINT32, order = 1)
    public int value;

    public static IntValue of(int value) {
        var theValue = new IntValue();
        theValue.value = value;
        return theValue;
    }
}
