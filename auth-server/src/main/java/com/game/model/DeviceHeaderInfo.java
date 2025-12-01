package com.game.model;

import lombok.Data;

/**
 * 设备请求头信息实体类
 */
@Data
public class DeviceHeaderInfo {
    private String clientId;
    private String yofiDeviceId;
    private String yofiSystem;
    private String yofiSystemVersion;
    private String yofiSdkVersion;
    private String yofiVersion;
    private String yofiChannelId;
    private String yofiPackageName;
} 