package com.game.player;

import com.game.common.LogicServerKit;
import com.game.player.action.CreateRoleAction;
import com.game.player.action.RoleLoginAction;
import com.game.player.event.ItemDataPusher;
import com.game.utils.SpringContextUtils;
import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilder;
import com.iohao.game.action.skeleton.eventbus.EventBus;
import com.iohao.game.action.skeleton.eventbus.EventBusRunner;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.core.client.BrokerClientBuilder;
import org.springframework.stereotype.Component;

/**
 * 玩家逻辑服
 */
@Component
public class PlayerLogicServer extends AbstractBrokerClientStartup {

    @Override
    public BarSkeleton createBarSkeleton() {
        // 业务框架构建器
        BarSkeletonBuilder builder = LogicServerKit
                .createBuilder(CreateRoleAction.class);

        // 登录后推送角色信息
        builder.addInOut(new RoleLoginAction.RoleLoginAfter());

        builder.addRunner(new EventBusRunner() {
            @Override
            public void registerEventBus(EventBus eventBus, BarSkeleton skeleton) {
                eventBus.register(SpringContextUtils.getBean(ItemDataPusher.class));
            }
        });

        return builder.build();
    }

    @Override
    public BrokerClientBuilder createBrokerClientBuilder() {
        BrokerClientBuilder builder = LogicServerKit.newBrokerClientBuilder();
        builder.appName("玩家逻辑服");
        return builder;
    }
}
