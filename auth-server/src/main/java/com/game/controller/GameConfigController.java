package com.game.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GameConfigController {

    @PostMapping("/sdk/api/v1/gameConfig/update")
    public String updateSdkGameConfig() {
        return "{\"code\":0,\"msg\":null,\"data\":{\"need\":0,\"url\":null}}";
    }

    @PostMapping("/sdk/api/v1/gameConfig/init")
    public String initSdkGameConfig() {
        return """
                {
                  "code": 0,
                  "msg": null,
                  "data": {
                    "wsUrl": "wss://sdkws.yofijoy.com",
                    "wsHeartbeatIntervalSecond": 1,
                    "chatIntervalSecond": 180,
                    "serverDomain": "https://sdk.gateway.yofijoy.com/",
                    "isOpenBackH5": 0
                  }
                }""";
    }

}
