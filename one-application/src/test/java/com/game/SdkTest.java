package com.game;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

@Slf4j
public class SdkTest {

    /* loaded from: classes2.dex */
    public static class RSAUtils {
        public static final String KEY_ALGORITHM = "RSA/ECB/PKCS1Padding";
        private static final String PUBLIC_KEY_K1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvpbgcdrpv5jRD4JZ33M3XVm8yOetRUGKoMx2uKoXZWazlqN9GboxnPQUFL6bALm2mZBN6nsZl2/FINcSciBMjPnyttmN28Fe0x7YQSEG6wms5XonHFMnJOplRj8ufwxSjsNeAuYWZ/paUEkM+RUEpRW19Nf4My7WBm17/NvQXOQIDAQAB";
        private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKorQLVeYw6AX+dKt5tMUx5hTwhWw88yZkThTaeRXQp9pivS27HxTo6Ehd2nvEmlCqUe2mmGcaxH1EPk7dVJnQlYFckmJLyUetbb/HaT7kZDlHTvy0Leqs/r59bUZgO+QpF01irPxpENSNaCtJ56MAQx4gtFwHbk44lT1Dea6lQwIDAQAB";

        private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMqitAtV5jDoBf50q3m0xTHmFPCFbDzzJmROFNp5FdCn2mK9LbsfFOjoSF3ae8SaUKpR7aaYZxrEfUQ+Tt1UmdCVgVySYkvJR61tv8dpPuRkOUdO/LQt6qz+vn1tRmA75CkXTWKs/GkQ1I1oK0nnowBDHiC0XAduTjiVPUN5rqVDAgMBAAECgYAjuC+VqfQ0XcoksytA/nkeVSkOxu4wBkqXtt3dLygFynjoG+HyUMXOUpfjF27m1q7ufxet3MKcCNPuEi+zu0SLnAGa7T0bUnQ0HGQ//qEwGCb6aMJdWQcG+MIK9BgVihkWfstNgXhbPOvdBSSTK4OMW+Is38g9blZZrWqDOd/JjQJBAPwBN7+8GUgOdAIMf7Y23xtdmTvvhbuNDxpexbnchA+pgMQyeHkR/tQyNJeAL7ANxjRwgOI/CEKW8ecpcrmbwkUCQQDN2R3VvV//T8riz9MFI9v+WDGqIVsAT/0Socg076hK+RAOjCfHUGOr4n1P38INggRjVq+h9SvJoX4mohEG6wXnAkEA7mpshu57cKuT33hZv1dsfuRvm7/BYy5SMp2lLXFOU88Grxgc2FZJJBKXpRm2hDaT5XrmxKXjt7Q9CnkxPB77jQJBALEr2UD5IOHndJFpHJAFADlXAVAUK3YGYqShuGbPi0MUQVy0BxzGtTLg2shfp27m5A34M2yrT0fZBnIL9anFqSsCQCWMx45AFl2fOVRfp6DT4hshprm0tUGCmjrb7pfH8b/nW1DD5R27MjhbdC1UGsM1oETwpdkAPnwVTqW3dYJ5luo=";

        // 假设服务器用私钥加密，客户端用公钥解密
        public static String decrypt(String str) throws Exception {
            // 使用Hutool的RSA类进行解密
            RSA rsa = new RSA(KEY_ALGORITHM, null, PUBLIC_KEY_K1);
            return rsa.decryptStr(str, KeyType.PublicKey);
        }

        public static String encryptByPublicKey(String str) throws Exception {
            // 使用Hutool的RSA类进行加密
            RSA rsa = new RSA(KEY_ALGORITHM, PRIVATE_KEY, null);
            return rsa.encryptBase64(str, KeyType.PrivateKey);
        }

        /**
         * 生成RSA密钥对
         */
        public static void generateKeyPair() throws Exception {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            String publicKeyBase64 = Base64.encode(publicKey.getEncoded());
            String privateKeyBase64 = Base64.encode(privateKey.getEncoded());

            System.out.println("Public Key: " + publicKeyBase64);
            System.out.println("Private Key: " + privateKeyBase64);
        }
    }

    @Test
    public void testEncrypt() throws Exception {
//        String originalStr = "测试RSA加密";
//        String encryptedStr = RSAUtils.encryptByPublicKey(originalStr);
//        System.out.println("加密后: " + encryptedStr);
//
//        // 验证加解密
//        String decryptedStr = RSAUtils.decryptByPublicKey(encryptedStr);
//        System.out.println("解密后: " + decryptedStr);

        String str = "lNfPJ2KosfF+2toJr4feUcd56o4A69XhJ3Sz+zAnVFCzyAXmMGJ5JC7DsQ7kNjwYCZfh/JBPo6GCGyOYY0h+dI/K4uIO/RVbrxxTpDip8x2AvRLm09rCGRmi3DOqSJh69XQ0nxtydb6YyX5MdtA30EpIGWU5sAt/w6VZJy9u8kwDpOwv/IXKOzV9K6MtcHJY+7LxvlJO14Xiy4dO4zNgr5+GrWLEHp3k7hjp3jBjkuwiV8v57OrQBS0vk/WOiZyrMXhtY4VeUSn29A0m9IpSsweKBiWVIkAb95zhCaF/k5FoEDAdYHUD13vVWE0ar/YwRpZCvDSxoK79Zeeapl3FgQ==";
//        String str = "I+Son6vSfzbLcLm9Qyr20mV2pD4nT6VWM8IhJ2HU0SO8MqCrxMp+zMhZXLOLc0dagCZrLWpsh5Xlux7myc/JKmodpfkOKkJrivNzlNM6iw7EfOrBiuiVaVYC3a0ZLDZ7bk22mHIJ28nL2oy7ggjLZh6RVDBVJkP1fOSnNXXLLnM=";
        String decryptedStr = RSAUtils.decrypt(str);
        System.out.println("解密后: " + decryptedStr);
    }

    @Test
    public void testGenerateKeyPair() throws Exception {
        RSAUtils.generateKeyPair();
    }
}
