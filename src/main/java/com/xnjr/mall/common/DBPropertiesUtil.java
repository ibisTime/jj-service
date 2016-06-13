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

import com.xnjr.mall.ao.ISYSConfigAO;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * @author: haiqingzheng 
 * @since: 2016年6月12日 下午12:54:27 
 * @history:
 */
public class DBPropertiesUtil {

    @Autowired
    private static ISYSConfigAO sysConfigAO = SpringContextHolder
        .getBean(ISYSConfigAO.class);

    public static final class Config {

        // 短信组件biz地址
        public static String SMS_URL = sysConfigAO.getConfigValue("SMS_URL");

        // 用户模块biz地址
        public static String USER_URL = sysConfigAO.getConfigValue("USER_URL");

        // 账户模块biz地址
        public static String ACCOUNT_URL = sysConfigAO
            .getConfigValue("ACCOUNT_URL");

        // 账户数据库名称
        public static String ACCOUNT_DB = sysConfigAO
            .getConfigValue("ACCOUNT_DB");

        // 用户数据库名称
        public static String USER_DB = sysConfigAO.getConfigValue("USER_DB");

    }

    public static void main(String[] args) {
        System.out.println(DBPropertiesUtil.Config.SMS_URL);
    }
}
