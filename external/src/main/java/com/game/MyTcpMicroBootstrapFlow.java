package com.game;

import com.iohao.game.external.core.config.ExternalGlobalConfig;
import com.iohao.game.external.core.micro.PipelineContext;
import com.iohao.game.external.core.netty.micro.TcpMicroBootstrapFlow;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.checkerframework.checker.units.qual.Length;

import java.nio.ByteOrder;

public class MyTcpMicroBootstrapFlow extends TcpMicroBootstrapFlow {

    @Override
    public void option(ServerBootstrap bootstrap) {
        super.option(bootstrap);
    }

    @Override
    public void pipelineCodec(PipelineContext context) {
        // 数据包长度 = 长度域的值 + lengthFieldOffset + lengthFieldLength + lengthAdjustment。
        context.addLast(new LengthFieldBasedFrameDecoder(
                // 小端排序
                ByteOrder.LITTLE_ENDIAN,
                // 最大长度
                ExternalGlobalConfig.CoreOption.packageMaxSize,
                // 长度字段的偏移量， 从 0 开始
                0,
                // 字段的长度, 如果使用的是 short ，占用2位；（消息头用的 byteBuf.writeShort 来记录长度的）
                // 字段的长度, 如果使用的是 int   ，占用4位；（消息头用的 byteBuf.writeInt   来记录长度的）
                2,
                // 要添加到长度字段值的补偿值：长度调整值 = 内容字段偏移量 - 长度字段偏移量 - 长度字段的字节数
                -2,
                // 跳过的初始字节数： 跳过0位; (跳过消息头的 0 位长度)
                0,
                true));

        // tcp socket 编解码
        context.addLast("codec", new MyTcpExternalCodec());
    }
}
