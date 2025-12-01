package com.game.player.action.internal;

import com.game.common.proto.PbLoginPlayer;
import com.game.ex.FlowContextEx;
import com.game.player.entity.PlayerEntity;
import com.game.player.mapper.PlayerMapper;
import com.game.player.service.PlayerService;
import com.game.role.cmd.RoleCmd;
import com.game.role.proto.PbInternalPlayer;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.protocol.wrapper.LongValue;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@ActionController(RoleCmd.cmd)
@AllArgsConstructor
public class InternalRoleAction {

    private final PlayerService playerService;

    /**
     * 获取登录角色列表
     */
    @ActionMethod(RoleCmd.getLoginPlayerList)
    public List<PbLoginPlayer> getLoginPlayerList(FlowContextEx flowContext) {
        // 从上下文中获取用户ID和服务器ID
        long userId = flowContext.getUserId();
        int serverId = flowContext.getServerId();

        log.info("获取登录角色列表, userId={}, serverId={}", userId, serverId);

        // 查询玩家角色列表
        List<PlayerEntity> players = playerService.findPlayersByUserId(userId, serverId);

        if (players == null || players.isEmpty()) {
            return new ArrayList<>();
        }

        // 将Player实体转换为PbLoginPlayer对象
        return PlayerMapper.ME.convertToLogin(players);
    }

    /**
     * 获取角色信息
     */
    @ActionMethod(RoleCmd.findRoleInfo)
    public PbInternalPlayer findRoleInfo(LongValue role) {
        PlayerEntity player = playerService.findPlayerById(role.value);
        return PlayerMapper.ME.convert(player);
    }
}
