package com.game.screen.manager;

import com.game.screen.model.RoleObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 玩家管理器
 * 用于管理全服务器的玩家角色对象
 */
@Slf4j
@Component
public class PlayerObjectManager {

    /**
     * 存储所有玩家角色对象，key是角色ID，value是角色对象
     */
    private final Map<Long, RoleObject> playerMap = new ConcurrentHashMap<>();

    /**
     * 添加玩家角色对象
     *
     * @param roleId     角色ID
     * @param roleObject 角色对象
     */
    public void addPlayer(long roleId, RoleObject roleObject) {
        playerMap.put(roleId, roleObject);
    }

    /**
     * 获取玩家角色对象
     *
     * @param roleId 角色ID
     * @return 角色对象，如果不存在则返回null
     */
    public RoleObject getPlayer(long roleId) {
        return playerMap.get(roleId);
    }

    /**
     * 移除玩家角色对象
     *
     * @param roleId 角色ID
     * @return 被移除的角色对象，如果不存在则返回null
     */
    public RoleObject removePlayer(long roleId) {
        RoleObject removed = playerMap.remove(roleId);
        if (removed != null) {
            log.info("玩家角色已从管理器移除, roleId={}", roleId);
        }
        return removed;
    }

    /**
     * 判断玩家角色是否存在
     *
     * @param roleId 角色ID
     * @return 是否存在
     */
    public boolean containsPlayer(long roleId) {
        return playerMap.containsKey(roleId);
    }

    /**
     * 获取所有玩家角色对象
     *
     * @return 玩家角色对象Map
     */
    public Map<Long, RoleObject> getAllPlayers() {
        return playerMap;
    }

    /**
     * 计算两点之间的距离
     */
    public int calculateDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    /**
     * 获取玩家与指定位置的距离
     *
     * @param roleId  角色ID
     * @param targetX 目标X坐标
     * @param targetY 目标Y坐标
     * @return 距离，如果玩家不存在则返回-1
     */
    public int getDistanceToPosition(long roleId, int targetX, int targetY) {
        RoleObject role = getPlayer(roleId);
        if (role == null) {
            return -1;
        }
        return calculateDistance(role.getMapPosX(), role.getMapPosY(), targetX, targetY);
    }
}