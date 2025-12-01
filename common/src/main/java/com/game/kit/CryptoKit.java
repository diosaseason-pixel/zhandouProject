package com.game.kit;


import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CryptoKit {


    /**
     * AES-ECB
     */
    public byte[] AesEncryptECB(byte[] data, String key) {
        AES aes = new AES(Mode.ECB, Padding.PKCS5Padding, key.getBytes());
        return aes.encrypt(data);
    }

    /**
     * AES-ECB
     */
    public byte[] AesDecryptECB(byte[] data, String key) {
        AES aes = new AES(Mode.ECB, Padding.PKCS5Padding, key.getBytes());
        return aes.decrypt(data);
    }


}
