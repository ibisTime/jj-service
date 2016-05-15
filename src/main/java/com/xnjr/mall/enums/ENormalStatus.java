/**
 * @Title EBankStatus.java 
 * @Package com.xnjr.moom.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午3:50:16 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午3:50:16 
 * @history:
 */
public enum ENormalStatus {
    NEW("0", "新建"), PASS("1", "审核通过"), UNPASS("2", "审核不通过");

    ENormalStatus(String code, String value) {
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
