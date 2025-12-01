package com.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 鉴权登录服务器
 */
@Slf4j
@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {

        // 强制设置编码（必须在 Spring Boot 启动之前设置）
        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("sun.jnu.encoding", "UTF-8");
        System.setProperty("user.language", "zh");
        System.setProperty("user.country", "CN");

        // 设置标准输出流的编码
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
            System.setErr(new java.io.PrintStream(System.err, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 启动SpringBoot
        SpringApplication.run(AuthServerApplication.class, args);
    }
}