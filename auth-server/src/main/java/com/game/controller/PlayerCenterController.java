package com.game.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PlayerCenterController {

    @PostMapping("/sdk/api/v1/playerCenter/heartbeat")
    public String heartbeat() {
        return """
                {
                  "code": 0,
                  "msg": null,
                  "data": {
                    "intervalSecond": 30
                  }
                }""";
    }

    @PostMapping("/sdk/api/v1/playerCenter/chat/querySession")
    public String querySession() {
        return """
                {
                  "code": 0,
                  "msg": null,
                  "data": {
                    "readFlag": 1
                  }
                }""";
    }
}
