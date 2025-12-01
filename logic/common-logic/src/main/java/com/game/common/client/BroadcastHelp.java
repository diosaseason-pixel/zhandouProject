package com.game.common.client;


import com.iohao.game.action.skeleton.core.CmdInfo;
import com.iohao.game.action.skeleton.core.commumication.BroadcastContext;
import com.iohao.game.bolt.broker.core.client.BrokerClientHelper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BroadcastHelp {

    public BroadcastContext getBroadcastContext() {
        return BrokerClientHelper.getBroadcastContext();
    }

    public void broadcast(int cmd, Object data, long userId) {
        getBroadcastContext().broadcast(CmdInfo.of(0, cmd), data, userId);
    }


}
