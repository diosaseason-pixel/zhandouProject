package com.game;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alipay.remoting.rpc.RpcCommandType;
import com.game.cmd.CmdMapper;
import com.game.kit.CryptoKit;
import com.iohao.game.action.skeleton.core.CmdKit;
import com.iohao.game.action.skeleton.core.DataCodecKit;
import com.iohao.game.action.skeleton.protocol.BarMessage;
import com.iohao.game.action.skeleton.protocol.HeadMetadata;
import com.iohao.game.action.skeleton.protocol.RequestMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.extern.slf4j.Slf4j;
import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class MyTcpExternalCodec extends MessageToMessageCodec<ByteBuf, BarMessage> {

    /**
     * 消息编码
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, BarMessage message, List<Object> out) throws Exception {

        // 错误信息
        if (message.hasError()) {
            log.info("hasError ");
            return;
        }

        // 序列化
        byte[] data = message.getData();
        int cmd = message.getHeadMetadata().getCmdInfo().getSubCmd();
        int length = data.length + 6;

        if (CmdMapper.C2S_MAP.containsKey(cmd)) {
            cmd = CmdMapper.C2S_MAP.get(cmd);
        }

        ByteBuf buffer = ctx.alloc().buffer(length);
        // 消息长度
        buffer.writeIntLE(length);
        // 消息类型
        buffer.writeShortLE(cmd);
        // 消息
        buffer.writeBytes(data);
        out.add(buffer);

        log.info("encode {} {}", cmd, length);
    }

    /**
     * 消息解码
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        // 标记当前读取索引
        msg.markReaderIndex();
        // 读取消息长度
        int length = msg.readUnsignedShortLE() - 2;
        log.info("receive message: length {} {}", length, msg.readableBytes());

        // 检查是否有足够的字节读取消息
        if (msg.readableBytes() < length) {
            msg.resetReaderIndex();
            return;
        }

        // 消息类型
        int cmd = msg.readUnsignedShortLE();

        log.info("receive message: cmd {} length {}", cmd, length);

        // 消息体
        byte[] data = new byte[msg.readableBytes()];
        msg.readBytes(data);

        // 解密消息
        data = CryptoKit.AesDecryptECB(data, "spqh4hpstria0q9h");

        // 构建请求体
        HeadMetadata headMetadata = new HeadMetadata()
                .setCmdMerge(CmdKit.merge(0, cmd))
                .setRpcCommandType(RpcCommandType.REQUEST_ONEWAY)
                .setCmdCode(1);

        // 请求消息
        RequestMessage message = new RequestMessage();
        message.setHeadMetadata(headMetadata);
        message.setData(data);

        // 【游戏对外服】接收【游戏客户端】的消息
        out.add(message);
    }
}
