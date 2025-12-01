package com.game.login.action;


import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.common.annotation.IoThread;
import com.game.common.proto.PbLoginPlayer;
import com.game.ex.AttachmentEx;
import com.game.ex.FlowContextEx;
import com.game.login.proto.PbLoginReq;
import com.game.login.proto.PbRoleListResp;
import com.game.role.client.RoleExchange;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.CmdKit;
import com.iohao.game.bolt.broker.client.kit.ExternalCommunicationKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@ActionController(0)
public class LoginAction {

    /**
     * 登录
     */
    @IoThread
    @ActionMethod(CCmd.USER_LOGIN)
    public PbRoleListResp login(PbLoginReq request, FlowContextEx flowContext) {
        // 参数校验
        if (!validateLogin(request)) {
            throw new RuntimeException("登录参数错误");
        }

        ExternalCommunicationKit.forcedOffline(10000);
        // 1.2 登录完成后，将用户信息存入Attachment
        AttachmentEx attachment = flowContext.getAttachment();
        attachment.setUserUUID(request.uuid);
        attachment.setServerId(request.serviceId);

        // 登录
        flowContext.bindUser(request.uuid);
        flowContext.setServerId(request.serviceId);

        PbRoleListResp response = new PbRoleListResp();
        response.code = Code.CODE_OK;

        // 查询角色列表
        response.loginPlayerArray = RoleExchange.getLoginPlayerList(flowContext);

        return response;
    }

    /**
     * 登录参数校验
     */
    private boolean validateLogin(PbLoginReq request) {
        if (Objects.isNull(request)) {
            return false;
        }

        if (request.getServiceId() <= 0) {
            return false;
        }

        return true;
    }

}
