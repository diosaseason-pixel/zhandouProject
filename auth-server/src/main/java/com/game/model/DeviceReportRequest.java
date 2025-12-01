package com.game.model;

import lombok.Data;

/**
 * 设备上报请求实体类
 */
@Data
public class DeviceReportRequest {
    // 表单参数
    private String system;
    private String sign;
    private String model;
    private String brand;
    private String systemVersion;
    private String deviceId;
    private String timestamp;
} 