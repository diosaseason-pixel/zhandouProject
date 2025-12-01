package com.game.common.proto.wrapper;

import com.iohao.game.action.skeleton.core.codec.DataSelfEncode;
import lombok.ToString;

@ToString
public final class ByteArrayValue implements DataSelfEncode {

    private final byte[] data;

    public ByteArrayValue(byte[] data) {
        this.data = data.clone();
    }

    @Override
    public byte[] getEncodeData() {
        return data;
    }
}
