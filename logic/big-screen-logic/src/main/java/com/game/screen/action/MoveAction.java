package com.game.screen.action;


import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.ex.FlowContextEx;
import com.game.screen.manager.PlayerObjectManager;
import com.game.screen.model.RoleObject;
import com.game.screen.proto.*;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 移动
 */
@Slf4j
@Component
@ActionController(0)
public class MoveAction {

    @Resource
    private PlayerObjectManager playerManager;

    @ActionMethod(CCmd.WHOLE_MOVE)
    public PbBigScreenMoveResp move(PbBigScreenObjMove request, FlowContextEx flowContext) {
        log.info("move {}", request);
        Spot pos = request.moveList.getLast();
        int newM = pos.newM;
        int newN = pos.newN;

        // 获取玩家对象
        long roleId = flowContext.getRoleId();
        RoleObject roleObject = playerManager.getPlayer(roleId);

        if (roleObject != null) {
            // 更新玩家位置
            roleObject.setMapPosX(newM);
            roleObject.setMapPosY(newN);
            log.info("更新玩家位置, roleId={}, m={}, n={}", roleId, newM, newN);
        }

        return new PbBigScreenMoveResp(request.m, request.n, Code.CODE_OK);
    }

    @ActionMethod(CCmd.WHOLE_IDLE)
    public PbBigScreenIdleResp idle(PbBigScreenObjIdle request, FlowContextEx flowContext) {
        log.info("idle {}", request);

        // 获取玩家对象
        long roleId = flowContext.getRoleId();
        RoleObject roleObject = playerManager.getPlayer(roleId);

        if (roleObject != null) {
            // 更新玩家位置
            roleObject.setMapPosX(request.m);
            roleObject.setMapPosY(request.n);
            log.info("更新玩家idle位置, roleId={}, m={}, n={}", roleId, request.m, request.n);
        }

        return new PbBigScreenIdleResp(request.m, request.n, Code.CODE_OK);
    }

}
