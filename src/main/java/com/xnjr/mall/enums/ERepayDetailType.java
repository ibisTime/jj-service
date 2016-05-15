/**
 * @Title ERepayDetailType.java 
 * @Package com.xnjr.moom.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月29日 下午2:27:57 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月29日 下午2:27:57 
 * @history:
 */
public enum ERepayDetailType {
    BJ("1", "本金"), LX("2", "收益");

    ERepayDetailType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
