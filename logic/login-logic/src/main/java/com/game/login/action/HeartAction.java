package com.game.login.action;


import com.game.cmd.CCmd;
import com.game.ex.FlowContextEx;
import com.game.common.proto.PbHeart;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ActionController(0)
public class HeartAction {

    /**
     * 心跳
     */
    @ActionMethod(CCmd.HEARTBEAT)
    public PbHeart heart(FlowContextEx context) {
        PbHeart response = new PbHeart();
        response.time = System.currentTimeMillis();
        return response;
    }

}
