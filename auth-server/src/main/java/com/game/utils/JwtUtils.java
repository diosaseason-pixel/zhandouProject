package com.game.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 * 用于生成和验证JWT token
 */
@Slf4j
@Component
public class JwtUtils {

    /**
     * 密钥
     */
    @Value("${jwt.secret}")
    private String secret;

    /**
     * token有效期（毫秒）
     */
    @Value("${jwt.expiration}")
    private long expiration;
    
    // 用于签名的密钥
    private Key signingKey;
    
    /**
     * 获取签名密钥
     * @return 签名密钥
     */
    private Key getSigningKey() {
        if (signingKey == null) {
            // 使用配置的密钥（确保长度足够256位，即32字节以上）
            byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
            log.info("密钥长度: {} bits", keyBytes.length * 8);
            signingKey = Keys.hmacShaKeyFor(keyBytes);
        }
        return signingKey;
    }

    /**
     * 创建JWT
     *
     * @param subject  主题（通常为用户ID）
     * @param claims   声明数据
     * @param duration 有效期（毫秒），小于等于0则使用默认有效期
     * @return JWT token
     */
    public String createToken(String subject, Map<String, Object> claims, long duration) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        // 实际过期时间
        long realDuration = duration > 0 ? duration : expiration;
        Date expirationDate = new Date(nowMillis + realDuration);
        
        // 获取签名密钥
        Key key = getSigningKey();
        
        // 创建JWT
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS256);
        
        // 添加自定义声明
        if (claims != null) {
            claims.forEach(builder::claim);
        }
        
        return builder.compact();
    }
    
    /**
     * 创建JWT（使用默认过期时间）
     *
     * @param subject 主题（通常为用户ID）
     * @param claims  声明数据
     * @return JWT token
     */
    public String createToken(String subject, Map<String, Object> claims) {
        return createToken(subject, claims, expiration);
    }
    
    /**
     * 解析JWT
     *
     * @param token JWT token
     * @return 声明对象
     * @throws Exception 解析异常
     */
    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    /**
     * 验证JWT是否有效
     *
     * @param token JWT token
     * @return 是否有效
     */
    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            log.error("JWT验证失败: {}", e.getMessage());
            return false;
        }
    }
    
    /**
     * 从JWT中获取主题（通常为用户ID）
     *
     * @param token JWT token
     * @return 主题
     */
    public String getSubjectFromToken(String token) {
        try {
            return parseToken(token).getSubject();
        } catch (Exception e) {
            log.error("从JWT获取主题失败: {}", e.getMessage());
            return null;
        }
    }
    
    /**
     * 从JWT中获取过期时间
     *
     * @param token JWT token
     * @return 过期时间
     */
    public Date getExpirationFromToken(String token) {
        try {
            return parseToken(token).getExpiration();
        } catch (Exception e) {
            log.error("从JWT获取过期时间失败: {}", e.getMessage());
            return null;
        }
    }
    
    /**
     * 检查JWT是否过期
     *
     * @param token JWT token
     * @return 是否过期
     */
    public boolean isTokenExpired(String token) {
        Date expiration = getExpirationFromToken(token);
        return expiration != null && expiration.before(new Date());
    }
} 