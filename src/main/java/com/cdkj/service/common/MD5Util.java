/**
 * @Title MD5Util.java 
 * @Package com.ibis.account.common 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午4:54:49 
 * @version V1.0   
 */
package com.cdkj.service.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午4:54:49 
 * @history:
 */
public class MD5Util {
    public static String md5(String pswd) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            StringBuffer strbuf = new StringBuffer();

            md5.update(pswd.getBytes(), 0, pswd.length());
            byte[] digest = md5.digest();

            for (int i = 0; i < digest.length; i++) {
                strbuf.append(byte2Hex(digest[i]));
            }

            return strbuf.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String byte2Hex(byte b) {
        int value = (b & 0x7F) + (b < 0 ? 0x80 : 0);
        return (value < 0x10 ? "0" : "")
                + Integer.toHexString(value).toLowerCase();
    }

}
