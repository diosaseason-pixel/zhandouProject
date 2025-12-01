package com.game.screen.manager;

import com.game.ex.FlowContextEx;
import com.game.screen.room.ScreenPlayer;
import com.game.screen.room.ScreenRoom;
import com.iohao.game.widget.light.room.Room;
import com.iohao.game.widget.light.room.RoomService;
import com.iohao.game.widget.light.room.flow.GameFixedService;
import com.iohao.game.widget.light.room.flow.GameFlowContext;
import com.iohao.game.widget.light.room.flow.RoomCreateContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 场景管理器
 */
@Getter
@Setter
@Service
public class ScreenManager implements RoomService, GameFixedService {
    // 房间 map
    final Map<Long, Room> roomMap = new ConcurrentHashMap<>();
    // 玩家对应的房间 map
    final Map<Long, Long> userRoomMap = new ConcurrentHashMap<>();

    @Override
    public ScreenRoom createRoom(RoomCreateContext createContext) {
        return new ScreenRoom();
    }

    @Override
    public ScreenPlayer createPlayer(GameFlowContext gameFlowContext) {
        FlowContextEx flowContext = (FlowContextEx) gameFlowContext.getFlowContext();
        long roleId = flowContext.getRoleId();
        long userId = flowContext.getUserId();

        ScreenPlayer player = new ScreenPlayer();
        player.setUserId(userId);
        player.setRoleId(roleId);
        return player;
    }

    @Override
    public void enterRoom(GameFlowContext gameFlowContext) {
        FlowContextEx flowContext = (FlowContextEx) gameFlowContext.getFlowContext();
        long userId = flowContext.getUserId();
        Room room = gameFlowContext.getRoom();

        room.ifPlayerNotExist(userId, () -> {
            // 创建玩家
            ScreenPlayer player = this.createPlayer(gameFlowContext);
            // 将玩家加入房间
            this.addPlayer(room, player);
        });
    }


    public ScreenRoom getOrCreateScreen(int mapCode) {
        ScreenRoom room = this.getRoom(mapCode);

        // 如果房间（地图）不存在，就创建
        return Optional.ofNullable(room).orElseGet(() -> {
            var theRoom = this.createRoom(null);
            theRoom.setRoomId(mapCode);
            // 将房间保存到房间管理器中
            this.addRoom(theRoom);
            return theRoom;
        });
    }

}
