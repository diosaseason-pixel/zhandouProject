package com.game.controller;

import com.game.model.DeviceHeaderInfo;
import com.game.model.DeviceReportRequest;
import com.game.utils.RSAUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ReportController {

    @GetMapping("/sdk/api/v1/report/deviceModel")
    public String deviceModel() {
        String config = "{\"h5Url\": \"http://192.168.1.4:8089/sdkdomestic/sdkvue/\", \"serverUrl\": \"http://192.168.1.4:8080/\", \"taskServerUrl\": \"http://192.168.1.4:8080/\"}";
        return RSAUtils.encrypt(config);
    }

    @ModelAttribute("headerInfo")
    public DeviceHeaderInfo getHeaderInfo(HttpServletRequest request) {
        DeviceHeaderInfo headerInfo = new DeviceHeaderInfo();
        headerInfo.setClientId(request.getHeader("clientId"));
        headerInfo.setYofiDeviceId(request.getHeader("yofiDeviceId"));
        headerInfo.setYofiSystem(request.getHeader("yofiSystem"));
        headerInfo.setYofiSystemVersion(request.getHeader("yofiSystemVersion"));
        headerInfo.setYofiSdkVersion(request.getHeader("yofiSdkVersion"));
        headerInfo.setYofiVersion(request.getHeader("yofiVersion"));
        headerInfo.setYofiChannelId(request.getHeader("yofiChannelId"));
        headerInfo.setYofiPackageName(request.getHeader("yofiPackageName"));
        return headerInfo;
    }

    @PostMapping("/sdk/api/v1/report/deviceModel")
    public String reportDeviceModel(@ModelAttribute DeviceReportRequest request) {
        log.info("设备上报信息: deviceId={}, model={}, brand={}, system={}", request.getDeviceId(), request.getModel(), request.getBrand(), request.getSystem());
        return "{\"code\":0,\"msg\":null,\"data\":null}";
    }

    @PostMapping("/sdk/api/v1/report/sdkStage")
    public String reportSdkStage() {
        return "{\"code\":0,\"msg\":null,\"data\":null}";
    }

}
