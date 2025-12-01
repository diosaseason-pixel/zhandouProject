package com.game.screen;

import com.game.common.LogicServerKit;
import com.game.screen.action.MoveAction;
import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilder;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.core.client.BrokerClientBuilder;

/**
 * 大地图逻辑服
 */
public class BigScreenLogicServer extends AbstractBrokerClientStartup {

    @Override
    public BarSkeleton createBarSkeleton() {
        // 业务框架构建器
        BarSkeletonBuilder builder = LogicServerKit
                .createBuilder(MoveAction.class);

        return builder.build();
    }

    @Override
    public BrokerClientBuilder createBrokerClientBuilder() {
        BrokerClientBuilder builder = LogicServerKit.newBrokerClientBuilder();
        builder.appName("大地图场景逻辑服");
        return builder;
    }

}
