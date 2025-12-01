package com.game.config;

import com.game.interceptor.JwtAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private JwtAuthInterceptor jwtAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtAuthInterceptor)
//                .addPathPatterns("/api/**")  // 拦截所有API请求
//                .excludePathPatterns(
//                        "/api/login",         // 排除登录API
//                        "/sdk/domestic",      // 排除登录页面
//                        "/css/**",            // 排除静态资源
//                        "/js/**",
//                        "/images/**",
//                        "/sdkconfig/**"       // 排除SDK配置
//                );
    }
} 