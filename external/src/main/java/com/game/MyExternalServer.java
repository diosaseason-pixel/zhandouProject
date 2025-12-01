package com.game;

import com.iohao.game.bolt.broker.core.client.BrokerAddress;
import com.iohao.game.bolt.broker.core.common.IoGameGlobalConfig;
import com.iohao.game.external.core.ExternalServer;
import com.iohao.game.external.core.config.ExternalGlobalConfig;
import com.iohao.game.external.core.config.ExternalJoinEnum;
import com.iohao.game.external.core.netty.DefaultExternalServer;
import com.iohao.game.external.core.netty.DefaultExternalServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * 游戏对外服
 */
@Slf4j
public class MyExternalServer {

    /**
     * 游戏对外服列表
     */
    public List<ExternalServer> listExternalServer(int externalPort) {
        // tcp
        ExternalServer tcpExternalServer = createTcpExternalServer(ExternalJoinEnum.TCP.cocPort(externalPort));
        return List.of(tcpExternalServer);
    }

    /**
     * 创建对外服
     *
     * @param externalPort 端口
     */
    public ExternalServer createTcpExternalServer(int externalPort) {
        // 游戏对外服配置
        extractedConfig();

        // 游戏对外服 - 构建器
        DefaultExternalServerBuilder builder = DefaultExternalServer.newBuilder(externalPort)
                // websocket 方式连接；如果不设置，默认也是这个配置
                .externalJoinEnum(ExternalJoinEnum.TCP)
                // Broker （游戏网关）的连接地址；如果不设置，默认也是这个配置
                .brokerAddress(new BrokerAddress("127.0.0.1", IoGameGlobalConfig.brokerPort));

        // 自定义编解码器
        builder.setting().setMicroBootstrapFlow(new MyTcpMicroBootstrapFlow());

        // 构建游戏对外服 https://www.yuque.com/iohao/game/ea6geg
        return builder.build();
    }

    private void extractedConfig() {
        // https://www.yuque.com/iohao/game/nap5y8p5fevhv99y

    }

    public static void main(String[] args) {

        // 强制设置编码（必须在 Spring Boot 启动之前设置）
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("sun.jnu.encoding", "UTF-8");
        System.setProperty("user.language", "zh");
        System.setProperty("user.country", "CN");

        // 设置标准输出流的编码
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
            System.setErr(new java.io.PrintStream(System.err, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 游戏对外服端口
        ExternalServer externalServer = new MyExternalServer()
                .createTcpExternalServer(ExternalGlobalConfig.externalPort);

        externalServer.startup();
    }

}