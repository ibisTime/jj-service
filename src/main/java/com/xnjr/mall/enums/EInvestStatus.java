/**
 * @Title EInvestStatus.java 
 * @Package com.xnjr.account.front.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年1月16日 下午8:06:35 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年1月16日 下午8:06:35 
 * @history:
 */
public enum EInvestStatus {
    APPLYING("0", "认购申请中"), CONFIRMED("1", "已确认"), CANCELLED("2", "已取消");

    EInvestStatus(String code, String value) {
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
