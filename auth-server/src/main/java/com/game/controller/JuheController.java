package com.game.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 聚合Sdk接口
 */
@Slf4j
@RestController
public class JuheController {

    /**
     * 登录
     */
    @PostMapping("/juhe/api/user/getLoginToken")
    public String getLoginToken() {
        log.info("聚合Sdk getLoginToken");
        return """
                {
                  "code": 0,
                  "msg": null,
                  "data": {
                    "channelUserId": "2e455144d8334ba6b022c7e37d70a04b",
                    "channelUserName": "",
                    "token": "0313be3dd0b7bc31b7205c46454c97df",
                    "extension": "",
                    "cpExtra": null,
                    "serverId": null,
                    "holidays": [],
                    "newUser": false
                  }
                }""";
    }

    /**
     * 上报Sdk状态
     */
    @PostMapping("/juhe/api/v1/report/sdkStage")
    public String reportSdkStage() {
        return "{\"code\":0,\"msg\":null,\"data\":null}";
    }

    /**
     * 上报游戏状态
     */
    @PostMapping("/juhe/api/v1/report/gameStage")
    public String reportGameStage() {
        return "{\"code\":0,\"msg\":null,\"data\":null}";
    }

    @PostMapping("/juhe/api/gameconfig/update")
    public String updateGameConfig() {
        return "{\"code\":0,\"msg\":null,\"data\":{\"need\":0,\"url\":null}}";
    }


}
