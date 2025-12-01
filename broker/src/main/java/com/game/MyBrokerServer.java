package com.game;

import com.iohao.game.bolt.broker.core.common.IoGameGlobalConfig;
import com.iohao.game.bolt.broker.server.BrokerServer;
import com.iohao.game.bolt.broker.server.BrokerServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


/**
 *  Broker （游戏网关）
 */
@Slf4j
public class MyBrokerServer {

    public BrokerServer createBrokerServer() {
        // broker （游戏网关）默认端口 10200
        return createBrokerServer(IoGameGlobalConfig.brokerPort);
    }

    public BrokerServer createBrokerServer(int port) {
        // Broker Server （游戏网关服） 构建器
        BrokerServerBuilder brokerServerBuilder = BrokerServer.newBuilder()
                // broker （游戏网关）端口
                .port(port);

        // 构建游戏网关
        return brokerServerBuilder.build();
    }

    public static void main(String[] args) throws InterruptedException {

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
        BrokerServer brokerServer = new MyBrokerServer().createBrokerServer();
        // 启动 游戏网关
        brokerServer.startup();

        TimeUnit.SECONDS.sleep(1);
    }

}