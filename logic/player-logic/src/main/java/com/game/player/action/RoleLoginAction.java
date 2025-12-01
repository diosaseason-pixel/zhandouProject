package com.game.player.action;

import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.ex.FlowContextEx;
import com.game.kit.TimeKit;
import com.game.player.entity.PlayerEntity;
import com.game.player.mapper.PlayerMapper;
import com.game.player.service.PlayerService;
import com.game.role.proto.PbRoleLoginReq;
import com.game.role.proto.PbRoleLoginResp;
import com.game.screen.client.BigScreenExchange;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.flow.ActionMethodInOut;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 角色登录处理器
 */
@Slf4j
@Component
@ActionController(0)
@AllArgsConstructor
public class RoleLoginAction {

    private final PlayerService playerService;

    /**
     * 登录参数校验
     */
    private boolean validateRoleLogin(PbRoleLoginReq request) {
        if (request == null) {
            return false;
        }

        if (request.getPlayerId() == null || request.getPlayerId() <= 0) {
            return false;
        }

        // UUID可以为空，因为可能是断线重连
        if (request.getReconnect() == null) {
            request.setReconnect(0); // 设置默认值
        }

        return true;
    }


    /**
     * 角色登录
     */
    @ActionMethod(CCmd.ROLE_LOGIN)
    public PbRoleLoginResp roleLogin(PbRoleLoginReq request, FlowContextEx flowContext) {
        log.info("角色登录请求: playerId={}, userId={}, uuid={}, reconnect={}", request.getPlayerId(), request.getUserId(), request.getUuid(), request.getReconnect());

        // 构建响应对象
        PbRoleLoginResp response = new PbRoleLoginResp();

        // 参数校验
        if (!validateRoleLogin(request)) {
            log.warn("角色登录失败，参数错误");
            response.setCode(Code.CODE_PARAM_ERROR);
            return response;
        }

        // 查询角色信息
        PlayerEntity player = playerService.findPlayerById(request.getPlayerId());
        if (player == null) {
            log.warn("角色登录失败，角色不存在，playerId={}", request.getPlayerId());
            response.setCode(Code.CODE_NO_ROLE);
            return response;
        }

        // 检查用户ID是否匹配
        if (player.getUserId() != flowContext.getUserId()) {
            log.warn("角色登录失败，用户ID不匹配，playerId={}, expectedUserId={}, actualUserId={}", request.getPlayerId(), player.getUserId(), request.getUserId());
            response.setCode(Code.CODE_NO_ROLE);
            return response;
        }

        // 检查角色是否已删除
        if (player.getDeleteTime() > 0) {
            log.warn("角色登录失败，角色已删除，playerId={}", request.getPlayerId());
            response.setCode(Code.CODE_ROLE_IS_DELETED);
            return response;
        }

        // 检查账号是否被冻结
        long currentTime = TimeKit.currentSecond();
        if (player.getUnfreezeAccountTime() > currentTime) {
            log.warn("角色登录失败，账号已冻结，playerId={}, unfreezeTime={}", request.getPlayerId(), player.getUnfreezeAccountTime());
            response.setCode(Code.CODE_ACCOUNT_FREEZED);
            return response;
        }

        // 更新最后登录时间
        player.setLastTime(currentTime);
        player = playerService.savePlayer(player);

        // 设置角色ID和服务器ID
        flowContext.setRoleId(player.getId());
        flowContext.setServerId(player.getServerId());

        // 构建成功响应
        response.code = Code.CODE_OK;
        response.lineId = 1; // 设置默认频道ID，可根据实际需求修改
        response.player = PlayerMapper.ME.convertToLogin(player);

        log.info("角色登录成功: playerId={}, name={}", player.getId(), player.getName());
        return response;
    }

    /**
     * 角色登录后处理器
     */
    public static class RoleLoginAfter implements ActionMethodInOut {

        @Override
        public void fuckIn(FlowContext flowContext) {

        }

        @Override
        public void fuckOut(FlowContext flowContext) {
            // 确保是角色登录请求
            if (flowContext.getActionCommand().getCmdInfo().getSubCmd() != CCmd.ROLE_LOGIN) {
                return;
            }

            // 将玩家加入到地图场景
            if (flowContext instanceof FlowContextEx flowContextEx) {
                log.info("角色登录后推送数据：roleId={}", flowContextEx.getRoleId());

                // 是否登录成功
                if (flowContextEx.getRoleId() <= 0) {
                    return;
                }

                // 准备登录数据
                flowContextEx.executeVirtual(() -> BigScreenExchange.prepareRoleData(flowContextEx));
            }
        }
    }


}