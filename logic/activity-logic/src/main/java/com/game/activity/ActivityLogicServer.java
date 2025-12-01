package com.game.activity;

import com.game.activity.action.SignInAction;
import com.game.common.LogicServerKit;
import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilder;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilderParamConfig;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.core.client.BrokerClientBuilder;

public class ActivityLogicServer extends AbstractBrokerClientStartup {

    @Override
    public BarSkeleton createBarSkeleton() {
        // 业务框架构建器
        BarSkeletonBuilder builder = LogicServerKit
                .createBuilder(SignInAction.class);

        var config = new BarSkeletonBuilderParamConfig()
                .scanActionPackage(SignInAction.class)
                // 扫描 action 类所在包
                .scanActionPackage(SignInAction.class);

        return builder.build();
    }

    @Override
    public BrokerClientBuilder createBrokerClientBuilder() {
        BrokerClientBuilder builder = LogicServerKit.newBrokerClientBuilder();
        builder.appName("活动逻辑服");
        return builder;
    }
}
