package com.game.model;

import lombok.Data;
import java.util.List;

/**
 * 登录接口响应实体类
 */
@Data
public class LoginResponse {
    private Integer code;
    private String msg;
    private UserData data;
    
    /**
     * 用户数据实体类
     */
    @Data
    public static class UserData {
        private String nickname;
        private Integer userId;
        private String uuid;
        private String accessToken;
        private Integer userType;
        private Boolean isAuthentication;
        private String phone;
        private String idCard;
        private Integer age;
        private List<Long> holidays;
        private Integer isForceAuthentication;
        private Integer isForceBindPhone;
        private Integer isSetPassword;
        private Integer isBindHongMeng;
        private Integer isRegGame;
        private String wsUrl;
        private String wxOpenId;
        private String openId;
    }
} 