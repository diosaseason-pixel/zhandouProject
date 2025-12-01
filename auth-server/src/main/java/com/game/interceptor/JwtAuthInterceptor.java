package com.game.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT认证拦截器
 * 用于验证API请求中的JWT令牌
 */
@Slf4j
@Component
public class JwtAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;
    
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取Authorization头
        String authHeader = request.getHeader("Authorization");
        
        // 验证token
        if (!StringUtils.hasText(authHeader)) {
            handleUnauthorized(response, "未提供授权令牌");
            return false;
        }
        
        // 提取JWT token
        String token = null;
        if (authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        } else {
            token = authHeader; // 也接受不带Bearer前缀的token
        }
        
        // 验证JWT token
        if (!jwtUtils.validateToken(token)) {
            handleUnauthorized(response, "无效的授权令牌");
            return false;
        }
        
        // 检查是否过期
        if (jwtUtils.isTokenExpired(token)) {
            handleUnauthorized(response, "授权令牌已过期");
            return false;
        }
        
        // 从JWT中获取用户信息
        String userId = jwtUtils.getSubjectFromToken(token);
        if (userId == null) {
            handleUnauthorized(response, "授权令牌缺少用户标识");
            return false;
        }
        
        // 将用户信息存入请求属性，便于后续使用
        request.setAttribute("userId", userId);
        
        return true;
    }
    
    private void handleUnauthorized(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        
        Map<String, Object> result = new HashMap<>();
        result.put("code", 401);
        result.put("message", message);
        
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
} 