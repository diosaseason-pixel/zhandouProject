package com.game.controller;

import com.game.utils.RSAUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SdkConfigController {

    @GetMapping("/sdkconfig/prod/yofi")
    public String ApiConfig() {
        String config = "{\"h5Url\": \"http://192.168.1.4:8080/sdk/domestic\", \"serverUrl\": \"http://192.168.1.4:8080/\", \"taskServerUrl\": \"http://192.168.1.4:8080/\"}";
        return RSAUtils.encrypt(config);
    }

    @GetMapping("/sdkconfig/prod/juhe")
    public String JuheConfig() {
        String config = "{\"serverUrl\": \"http://192.168.1.4:8080/\"}";
        return RSAUtils.encrypt(config);
    }
}
