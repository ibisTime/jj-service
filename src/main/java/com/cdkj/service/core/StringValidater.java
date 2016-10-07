/**
 * @Title BlankValidater.java 
 * @Package com.ibis.account.validate 
 * @Description 
 * @author miyb  
 * @date 2015-5-6 上午9:11:33 
 * @version V1.0   
 */
package com.cdkj.service.core;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-5-6 上午9:11:33 
 * @history:
 */
public class StringValidater {
    /** 
     * 判断参数是否为空
     * @param userId 
     * @create: 2015-3-17 下午6:40:34 miyb
     * @history: 
     */
    public static void validateBlank(String... params) {
        for (String param : params) {
            if (StringUtils.isBlank(param)) {
                throw new BizException("xn702000", "必填型入参，请按要求填写完整");
            }
        }
    }

    /** 
     * 判断钱的对错
     * @param userId 
     * @create: 2015-3-17 下午6:40:34 miyb
     * @history: 
     */
    public static void validateAmount(String... amountStrs) {
        for (String amountS : amountStrs) {
            if (StringUtils.isNotBlank(amountS)) {
                if (amountS.length() > 16) {
                    // 给前端提示，减去3位
                    throw new BizException("xn702000", "金额长度不能超过13位");
                }
            }
            try {
                Long.valueOf(amountS);
            } catch (Exception e) {
                throw new BizException("xn702000", "金额，请按要求填写数字");
            }
        }
    }

    public static void validateNumber(String... params) {
        for (String param : params) {
            if (!StringUtils.isNumeric(param)) {
                throw new BizException("xn702000", "数字型入参，请按要求填写数字");
            }
        }
    }

    /**
     * string转化成Long
     * @param string
     * @return 
     * @create: 2015-5-7 下午3:47:13 miyb
     * @history:
     */
    public static Long toLong(String string) {
        Long amount = null;
        try {
            if (StringUtils.isNotBlank(string)) {
                amount = Long.valueOf(string);
            }
        } catch (Exception e) {
            throw new BizException("xn702000", "数字型入参，请按要求填写数字");
        }
        return amount;
    }

    /**
     * string转化成Integer
     * @param string
     * @return 
     * @create: 2015-5-7 下午3:47:13 miyb
     * @history:
     */
    public static Integer toInteger(String string) {
        Integer num = null;
        try {
            if (StringUtils.isNotBlank(string)) {
                num = Integer.valueOf(string);
            }
        } catch (Exception e) {
            throw new BizException("xn702000", "数字型入参，请按要求填写数字");
        }
        return num;
    }

    /**
     * string转化成Long
     * @param string
     * @return 
     * @create: 2015-5-7 下午3:47:13 miyb
     * @history:
     */
    public static Double toDouble(String string) {
        Double d = null;
        try {
            if (StringUtils.isNotBlank(string)) {
                d = (new Double(string)).doubleValue();
            }
        } catch (Exception e) {
            throw new BizException("xn702000", "数字型入参，请按要求填写数字");
        }
        return d;
    }

}
