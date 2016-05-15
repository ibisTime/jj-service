/**
 * @Title OrderNoGenerater.java 
 * @Package com.ibis.account.core 
 * @Description 
 * @author miyb  
 * @date 2015-5-5 下午1:13:04 
 * @version V1.0   
 */
package com.xnjr.mall.core;

import java.util.Random;

import com.xnjr.mall.common.DateUtil;

/** 
 * @author: miyb 
 * @since: 2015-5-5 下午1:13:04 
 * @history:
 */
public class OrderNoGenerater {

    /**
     * 产生毫秒级别主键序列
     * @param prefix
     * @return 
     * @create: 2015年9月28日 下午5:18:38 xieyj
     * @history:
     */
    public static String generateM(String prefix) {
        int random = Math.abs(new Random().nextInt()) % 10;
        String today = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_5);
        return prefix + today + String.valueOf(random);
    }

    public static String generateME(String prefix) {
        int random = Math.abs(new Random().nextInt()) % 10000;
        String today = DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_5);
        return prefix + today + String.valueOf(random);
    }
}
