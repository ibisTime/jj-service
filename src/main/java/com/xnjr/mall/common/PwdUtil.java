/**
 * @Title PwdUtils.java 
 * @Package com.hsnet.pz.ao.util 
 * @Description 
 * @author miyb  
 * @date 2014-8-19 上午11:27:12 
 * @version V1.0   
 */
package com.xnjr.mall.common;

import org.apache.commons.lang.StringUtils;

/** 
 * @author: miyb 
 * @since: 2014-8-19 上午11:27:12 
 * @history:
 */
public class PwdUtil {
    public static final String LOW = "1";

    public static final String MIDDLE = "2";

    public static final String HIGH = "3";

    /**
     * 密码合法性检测
     * 密码长度6~16位字符，包括英文字符、数字、符号，不支持中文字符
     * @param password
     * @return 
     * @create: 2014-8-19 上午11:27:12 miyb 
     * @history:
     */
    public static void checkPassword(String password) {
        if (StringUtils.isNotBlank(password)) {
            char[] passwords = password.toCharArray();
            for (char pwdChar : passwords) {
                boolean flag = false;
                if ((pwdChar >= 48 && pwdChar <= 57) // 数字
                        || (pwdChar >= 65 && pwdChar <= 90)// 小写字母
                        || (pwdChar >= 97 && pwdChar <= 122)// 大写字母
                        || (pwdChar >= 32 && pwdChar <= 47)// 特殊符号
                        || (pwdChar >= 58 && pwdChar <= 64)
                        || (pwdChar >= 94 && pwdChar <= 96)
                        || (pwdChar >= 123 && pwdChar <= 126)) {
                    flag = true;
                }
                if (!flag) {
                    // throw new Exception("密码格式不对");
                }
            }
        } else {
            // throw new Exception("密码格式不对");
        }
    }

    /**
     * 密码强度计算
     * 显示密码强度：纯字符或数字或符号为弱密码、包含数字、符号、英文字符为强密码、其余为中密码
     * @param password
     * @return 
     * @create: 2014-8-19 上午11:27:12 miyb 
     * @history:
     */
    public static String calculateSecurityLevel(String password) {
        checkPassword(password);
        char[] passwords = password.toCharArray();

        int strength_L = 0;

        int strength_M = 0;

        int strength_H = 0;

        for (char pwdChar : passwords) {
            int ascll = pwdChar;
            // 数字
            if (ascll >= 48 && ascll <= 57) {
                strength_L++;
            }
            // 小写字母 大写字母
            else if ((ascll >= 65 && ascll <= 90)
                    || (ascll >= 97 && ascll <= 122)) {
                strength_M++;

                // 特殊符号
            } else if ((ascll >= 32 && ascll <= 47)
                    || (ascll >= 58 && ascll <= 64)
                    || (ascll >= 94 && ascll <= 96)
                    || (ascll >= 123 && ascll <= 126)) {
                strength_H++;
            }

        }
        // 弱
        if ((strength_L == 0 && strength_M == 0)
                || (strength_L == 0 && strength_H == 0)
                || (strength_M == 0 && strength_H == 0)) {
            return LOW;
        }
        // 强
        if (0 != strength_L && 0 != strength_M && 0 != strength_H) {
            return HIGH;
        }
        // 中
        return MIDDLE;
    }

}
