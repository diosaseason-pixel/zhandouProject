package com.game.utils;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RSAUtils {
    public final String KEY_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKorQLVeYw6AX+dKt5tMUx5hTwhWw88yZkThTaeRXQp9pivS27HxTo6Ehd2nvEmlCqUe2mmGcaxH1EPk7dVJnQlYFckmJLyUetbb/HaT7kZDlHTvy0Leqs/r59bUZgO+QpF01irPxpENSNaCtJ56MAQx4gtFwHbk44lT1Dea6lQwIDAQAB";

    private final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMqitAtV5jDoBf50q3m0xTHmFPCFbDzzJmROFNp5FdCn2mK9LbsfFOjoSF3ae8SaUKpR7aaYZxrEfUQ+Tt1UmdCVgVySYkvJR61tv8dpPuRkOUdO/LQt6qz+vn1tRmA75CkXTWKs/GkQ1I1oK0nnowBDHiC0XAduTjiVPUN5rqVDAgMBAAECgYAjuC+VqfQ0XcoksytA/nkeVSkOxu4wBkqXtt3dLygFynjoG+HyUMXOUpfjF27m1q7ufxet3MKcCNPuEi+zu0SLnAGa7T0bUnQ0HGQ//qEwGCb6aMJdWQcG+MIK9BgVihkWfstNgXhbPOvdBSSTK4OMW+Is38g9blZZrWqDOd/JjQJBAPwBN7+8GUgOdAIMf7Y23xtdmTvvhbuNDxpexbnchA+pgMQyeHkR/tQyNJeAL7ANxjRwgOI/CEKW8ecpcrmbwkUCQQDN2R3VvV//T8riz9MFI9v+WDGqIVsAT/0Socg076hK+RAOjCfHUGOr4n1P38INggRjVq+h9SvJoX4mohEG6wXnAkEA7mpshu57cKuT33hZv1dsfuRvm7/BYy5SMp2lLXFOU88Grxgc2FZJJBKXpRm2hDaT5XrmxKXjt7Q9CnkxPB77jQJBALEr2UD5IOHndJFpHJAFADlXAVAUK3YGYqShuGbPi0MUQVy0BxzGtTLg2shfp27m5A34M2yrT0fZBnIL9anFqSsCQCWMx45AFl2fOVRfp6DT4hshprm0tUGCmjrb7pfH8b/nW1DD5R27MjhbdC1UGsM1oETwpdkAPnwVTqW3dYJ5luo=";

    // 假设服务器用私钥加密，客户端用公钥解密
    public String decrypt(String str) {
        // 使用Hutool的RSA类进行解密
        RSA rsa = new RSA(KEY_ALGORITHM, null, PUBLIC_KEY);
        return rsa.decryptStr(str, KeyType.PublicKey);
    }

    public String encrypt(String str) {
        // 使用Hutool的RSA类进行加密
        RSA rsa = new RSA(KEY_ALGORITHM, PRIVATE_KEY, null);
        return rsa.encryptBase64(str, KeyType.PrivateKey);
    }
}
