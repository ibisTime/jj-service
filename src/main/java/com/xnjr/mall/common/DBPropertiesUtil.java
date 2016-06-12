/**
 * @Title DBPropertiesUtil.java 
 * @Package com.xnjr.mall.common 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年6月12日 下午12:54:27 
 * @version V1.0   
 */
package com.xnjr.mall.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.xnjr.mall.bo.ISYSConfigBO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年6月12日 下午12:54:27 
 * @history:
 */
public class DBPropertiesUtil {

    @Autowired
    private static ISYSConfigBO sysConfigBO;

    public static final class Config {

        // 短信组件biz地址
        public static String SMS_URL = sysConfigBO.getConfigValue("SMS_URL");

        // 用户模块biz地址
        public static String USER_URL = sysConfigBO.getConfigValue("USER_URL");

        // 账户模块biz地址
        public static String ACCOUNT_URL = sysConfigBO
            .getConfigValue("ACCOUNT_URL");

    }
}
