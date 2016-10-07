/**
 * @Title AccountUtil.java 
 * @Package com.ibis.account.core 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午4:54:24 
 * @version V1.0   
 */
package com.cdkj.service.core;

import java.util.Random;

import com.cdkj.service.common.DateUtil;
import com.cdkj.service.common.MD5Util;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午4:54:24 
 * @history:
 */
public class AccountUtil {
    /*
     * @Value("${account.md5.key}") private String key;
     */
    private static String key = "123";

    public static String md5(Long amount) {
        StringBuffer bf = new StringBuffer(key);
        bf.append(amount);
        return MD5Util.md5(bf.toString());
    }

    public static String generateAccountNumber() {
        int random = Math.abs(new Random().nextInt()) % 10;
        String today = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_3);
        return today + String.valueOf(random);
    }

    public static String prefixAccount(String userId, String prefix) {
        return prefix + userId.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(prefixAccount("U2016082509333332516", "C"));
    }
}
