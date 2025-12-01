package com.game.player.action;

import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.common.proto.PbLoginPlayer;
import com.game.ex.FlowContextEx;
import com.game.player.entity.PlayerEntity;
import com.game.player.mapper.PlayerMapper;
import com.game.player.region.CreateRoleRegion;
import com.game.player.service.PlayerService;
import com.game.role.proto.PbCreateRoleReq;
import com.game.role.proto.PbCreateRoleResp;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 创建角色
 */
@Slf4j
@Component
@ActionController(0)
@AllArgsConstructor
public class CreateRoleAction {

    private final PlayerService playerService;
    private final CreateRoleRegion createRoleRegion;

    /**
     * 单个服务器允许创建的最大角色数量
     */
    private static final int MAX_ROLES_PER_SERVER = 4;

    /**
     * 创建角色
     */
    @ActionMethod(CCmd.CREATE_ROLE)
    public PbCreateRoleResp createRole(PbCreateRoleReq request, FlowContextEx flowContext) {
        // 从上下文中获取用户ID和服务器ID
        long userId = flowContext.getUserId();
        int serverId = flowContext.getServerId();

        log.info("创建角色请求, userId={}, serverId={}, name={}", userId, serverId, request.getName());

        // 基本参数校验
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            log.warn("创建角色失败, 角色名不能为空");
            return createFailResult(Code.CODE_PARAM_ERROR);
        }

        if (request.getSex() == null || (request.getSex() != 1 && request.getSex() != 2)) {
            log.warn("创建角色失败, 性别参数错误");
            return createFailResult(Code.CODE_PARAM_ERROR);
        }

        // 判断角色名是否已存在
        if (playerService.isNameExists(request.getName())) {
            log.warn("创建角色失败，角色名已存在, name={}", request.getName());
            return createFailResult(Code.CODE_NAME_EXISTS);
        }

        // 检查角色数量限制
        List<PlayerEntity> existingPlayers = playerService.findPlayersByUserId(userId, serverId);
        if (existingPlayers != null && existingPlayers.size() >= MAX_ROLES_PER_SERVER) {
            log.warn("创建角色失败, 角色数量已达上限({}), userId={}, serverId={}", MAX_ROLES_PER_SERVER, userId, serverId);
            return createFailResult(Code.CODE_MAX_ROLE_COUNT);
        }

        // 使用CreateRoleRegion创建角色
        PlayerEntity player = createRoleRegion.createPlayer(userId, serverId, request);

        if (player == null) {
            log.warn("创建角色失败, 创建角色时发生错误");
            return createFailResult(Code.CODE_ERROR);
        }

        // 创建成功
        PbCreateRoleResp result = new PbCreateRoleResp();
        result.setCode(Code.CODE_OK);

        // 将Player转换为PbLoginPlayer
        PbLoginPlayer pbPlayer = PlayerMapper.ME.convertToLogin(player);
        result.setPlayer(pbPlayer);

        log.info("创建角色成功, userId={}, serverId={}, roleId={}, name={}", userId, serverId, player.getId(), player.getName());

        return result;
    }

    /**
     * 创建失败结果
     */
    private PbCreateRoleResp createFailResult(int code) {
        PbCreateRoleResp result = new PbCreateRoleResp();
        result.setCode(code);
        return result;
    }
}
