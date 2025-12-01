package com.game.login.action;

import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.common.proto.PbBaseResp;
import com.game.common.proto.PbSysSettingReq;
import com.game.ex.FlowContextEx;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ActionController(0)
public class SettingAction {

    @ActionMethod(CCmd.SYS_SETING)
    public PbBaseResp setting(PbSysSettingReq request, FlowContextEx flowContext) {
        var response = new PbBaseResp();
        response.code = Code.CODE_OK;
        return response;
    }

}
