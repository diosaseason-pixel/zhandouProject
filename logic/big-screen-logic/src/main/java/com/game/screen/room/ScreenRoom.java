package com.game.screen.room;

import com.alipay.remoting.util.ConcurrentHashSet;
import com.iohao.game.action.skeleton.core.CmdInfo;
import com.iohao.game.widget.light.room.SimpleRoom;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScreenRoom extends SimpleRoom {

    /**
     * 存储场景中的角色Id
     */
    final Set<Integer> screenObjectIds = new ConcurrentHashSet<>();


    /**
     * 房间内广播
     */
    public void broadcastRange(int cmd, Object data) {
        this.ofRangeBroadcast().setResponseMessage(CmdInfo.of(0, cmd), data).execute();
    }

}
