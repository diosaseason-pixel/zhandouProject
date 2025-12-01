package com.game.controller;

import com.game.model.LoginRequest;
import com.game.model.LoginResponse;
import com.game.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginApiController {

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        
        log.info("收到登录请求：用户名={}", username);
        
        LoginResponse response = new LoginResponse();
        
        // 这里实现您的登录逻辑，验证用户名和密码
        // 此处仅为示例，您需要替换为实际的身份验证逻辑
        if ("admin".equals(username) && "123".equals(password)) {
            // 登录成功
            response.setCode(0);
            response.setMsg(null);
            
            // 构建用户数据
            LoginResponse.UserData userData = new LoginResponse.UserData();
            
            // 用户基本信息
            String userId = "13936024";
            String uuid = UUID.randomUUID().toString().replace("-", "");
            userData.setNickname("游客" + userId);
            userData.setUserId(Integer.parseInt(userId));
            userData.setUuid(uuid);
            
            // 登录凭证
            String accessToken = generateJwtToken(username);
//            userData.setAccessToken(accessToken);
            userData.setAccessToken("5a4b44f3e96e83949cdd281079008254");

            // 用户身份信息
            userData.setUserType(0);
            userData.setIsAuthentication(true);
            userData.setPhone("");
            userData.setIdCard("111111111111111111");
            userData.setAge(18);
            
            // 假日信息
            List<Long> holidays = new ArrayList<>();
            holidays.add(1746028800L);
            holidays.add(1746115200L);
            holidays.add(1746201600L);
            holidays.add(1746288000L);
            holidays.add(1746374400L);
            userData.setHolidays(holidays);
            
            // 其他状态信息
            userData.setIsForceAuthentication(1);
            userData.setIsForceBindPhone(0);
            userData.setIsSetPassword(1);
            userData.setIsBindHongMeng(0);
            userData.setIsRegGame(0);
            
            // 服务器信息
            userData.setWsUrl("wss://sdkws.yofijoy.com");
            userData.setWxOpenId("");
            userData.setOpenId("");
            
            response.setData(userData);
            return ResponseEntity.ok(response);
        }
        
        // 登录失败
        response.setCode(1);
        response.setMsg("用户名或密码错误");
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    
    /**
     * 生成JWT令牌
     * @param username 用户名
     * @return JWT令牌
     */
    private String generateJwtToken(String username) {
        // 创建用户信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        // 添加唯一ID作为用户标识
        String userId = "13936024";
        claims.put("userId", userId);
        // 添加角色信息
        claims.put("role", "user");
        // 添加其他用户信息
        claims.put("timestamp", System.currentTimeMillis());
        
        try {
            // 尝试使用JWT工具类生成令牌
            return jwtUtils.createToken(userId, claims);
        } catch (Exception e) {
            // 如果JWT生成失败，使用简单令牌生成方式
            log.error("JWT生成失败，使用简单令牌", e);
            return UUID.randomUUID().toString().replace("-", "") + username.hashCode();
        }
    }
} 