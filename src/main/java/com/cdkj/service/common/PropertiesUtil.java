package com.cdkj.service.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties props;
    static {
        props = new Properties();
        try {
            props.load(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("config.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("找不到config.properties文件", e);
        } catch (IOException e) {
            throw new RuntimeException("读取config.properties文件出错", e);
        }
    }

    public static String getProperty(String key) {
        if (props == null) {
            // throw new Exception("配置文件初始化失败");
        }
        return props.getProperty(key);
    }

    public static final class Config {
        public static String SMS_URL = props.getProperty("SMS_URL");

        public static String USER_URL = props.getProperty("USER_URL");

        public static String ACCOUNT_URL = props.getProperty("ACCOUNT_URL");

        public static String SYS_INIT_PWD_STRENGTH = props
            .getProperty("SYS_INIT_PWD_STRENGTH");

        public static String SYS_INIT_LOGIN_PWD = props
            .getProperty("SYS_INIT_LOGIN_PWD");

        public static String SYS_INIT_TRADE_PWD = props
            .getProperty("SYS_INIT_TRADE_PWD");

        public static String CUSTOMER_TELEPHONE = props
            .getProperty("CUSTOMER_TELEPHONE");

    }
}
