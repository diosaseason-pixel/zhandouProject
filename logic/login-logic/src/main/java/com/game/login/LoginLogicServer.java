package com.game.login;

import com.game.common.LogicServerKit;
import com.game.login.action.LoginAction;
import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilder;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.core.client.BrokerClientBuilder;

/**
 * 登录逻辑服
 */
public class LoginLogicServer extends AbstractBrokerClientStartup {

    @Override
    public BarSkeleton createBarSkeleton() {
        // 业务框架构建器
        BarSkeletonBuilder builder = LogicServerKit
                .createBuilder(LoginAction.class);

        return builder.build();
    }

    @Override
    public BrokerClientBuilder createBrokerClientBuilder() {
        BrokerClientBuilder builder = LogicServerKit.newBrokerClientBuilder();
        builder.appName("登录逻辑服");
        return builder;
    }
}
