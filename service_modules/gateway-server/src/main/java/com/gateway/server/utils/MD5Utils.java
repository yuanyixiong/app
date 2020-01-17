package com.gateway.server.utils;

import java.security.MessageDigest;

/**
 * @author 袁毅雄
 * @description md5 工具类
 * @date 2019/6/11
 */
public class MD5Utils {

    /**
     * Md5 加密
     *
     * @param data
     * @return
     */
    public static String md5Encrypt(String data) {
        String resultString = null;
        try {
            resultString = new String(data);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byte2hexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    /**
     * md5 简单加密算法  超简版本
     *
     * @param bytes 待加密的byte数组
     * @return
     */
    private static String byte2hexString(byte[] bytes) {
        StringBuffer bf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                bf.append("0");
            }
            bf.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return bf.toString();
    }
}
