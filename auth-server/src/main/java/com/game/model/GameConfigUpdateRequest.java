package com.game.model;

import lombok.Data;

/**
 * 游戏配置更新请求实体类
 */
@Data
public class GameConfigUpdateRequest {
    private String system;
    private String sign;
    private String version;
    private String channelId;
    private String timestamp;
} 