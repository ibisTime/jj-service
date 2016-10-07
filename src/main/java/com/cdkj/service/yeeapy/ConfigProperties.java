package com.cdkj.service.yeeapy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
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

    public static final class Config {
        public static String SMS_URL = props.getProperty("SMS_URL");// 短信服务地址

        public static String IDENTIFY_URL = props.getProperty("IDENTIFY_URL");// 实名认证地址

        // yeepay start----------
        public static String P1_MERID = props.getProperty("p1_MerId");// 商户号

        public static String KEYVALUE = props.getProperty("keyValue");// 密码

        public static String ONLINEPAYMENTREQURL = props
            .getProperty("onlinePaymentReqURL");

        public static String YEEPAYCOMMONREQURL = props
            .getProperty("yeepayCommonReqURL");

        public static String QUERYREFUNDREQURL = props
            .getProperty("queryRefundReqURL");

        public static String RETURN_URL = props.getProperty("return_URL");// 回调

        public static String P5_PID = props.getProperty("p5_Pid");// 商品名称

        // yeepay end----------

        // yeepay onekey start----------

        public static String CALLBACK_URL = props.getProperty("callbackurl");

        // yeepay onekey end----------

        public static String PHOTO_URL = props.getProperty("PHOTO_URL");// 头像图片

        public static String SMS_REGISTER_TIME = props
            .getProperty("SMS_REGISTER_TIME");

        public static String SMS_FINDLOGINPWD_TIME = props
            .getProperty("SMS_FINDLOGINPWD_TIME");

        public static String SMS_RESETLOGINPWD_TIME = props
            .getProperty("SMS_RESETLOGINPWD_TIME");

        public static String SMS_SETTRADEPWD_TIME = props
            .getProperty("SMS_SETTRADEPWD_TIME");

        public static String SMS_FINDTRADEPWD_TIME = props
            .getProperty("SMS_FINDTRADEPWD_TIME");

        public static String SMS_RESETTRADEPWD_TIME = props
            .getProperty("SMS_RESETTRADEPWD_TIME");

        public static String SMS_CHANGEMOBILE_TIME = props
            .getProperty("SMS_CHANGEMOBILE_TIME");

        public static String SMS_REGISTER_COUNT = props
            .getProperty("SMS_REGISTER_COUNT");

        public static String SMS_FINDLOGINPWD_COUNT_ = props
            .getProperty("SMS_FINDLOGINPWD_COUNT");

        public static String SMS_RESETLOGINPWD_COUNT = props
            .getProperty("SMS_RESETLOGINPWD_COUNT");

        public static String SMS_SETTRADEPWD_COUNT = props
            .getProperty("SMS_SETTRADEPWD_COUNT");

        public static String SMS_FINDTRADEPWD_COUNT = props
            .getProperty("SMS_FINDTRADEPWD_COUNT");

        public static String SMS_RESETTRADEPWD_COUNT = props
            .getProperty("SMS_RESETTRADEPWD_COUNT");

        public static String SMS_CHANGEMOBILE_COUNT = props
            .getProperty("SMS_CHANGEMOBILE_COUNT");
    }
}
