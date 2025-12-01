package com.game;

import com.game.activity.ActivityLogicServer;
import com.game.login.LoginLogicServer;
import com.game.player.PlayerLogicServer;
import com.game.screen.BigScreenLogicServer;
import com.google.common.collect.Lists;
import com.iohao.game.action.skeleton.ext.spring.ActionFactoryBeanForSpring;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.external.core.ExternalServer;
import com.iohao.game.external.core.config.ExternalGlobalConfig;
import com.iohao.game.external.core.netty.simple.NettyRunOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


/**
 * 单体启动
 */
@Slf4j
@SpringBootApplication
public class OneApplication {

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

        // 启动SpringBoot
        var context = SpringApplication.run(OneApplication.class, args);

        // 游戏逻辑服列表
        List<AbstractBrokerClientStartup> logicServers = listLogic();

        // 游戏对外服
        List<ExternalServer> externalServers = new MyExternalServer()
                .listExternalServer(ExternalGlobalConfig.externalPort);

        new NettyRunOne()
                // 游戏对外服列表
                .setExternalServerList(externalServers)
                // Broker（游戏网关服）
                .setBrokerServer(new MyBrokerServer().createBrokerServer())
                // 游戏逻辑服列表
                .setLogicServerList(logicServers)
                // 启动游戏服务器
                .startup();
    }


    /**
     * 逻辑服列表
     */
    static List<AbstractBrokerClientStartup> listLogic() {
        return Lists.newArrayList(
                // 登录
                new LoginLogicServer(),
                // 角色
                new PlayerLogicServer(),
                // 大地图
                new BigScreenLogicServer(),
                // 活动
                new ActivityLogicServer()
        );
    }

    @Bean
    public ActionFactoryBeanForSpring actionFactoryBean() {
        // 将业务框架交给 spring 管理
        return ActionFactoryBeanForSpring.me();
    }

    private static class CustomBeanNameGenerator implements BeanNameGenerator {
        @Override
        public String generateBeanName(BeanDefinition d, BeanDefinitionRegistry r) {
            return d.getBeanClassName();
        }
    }


}