package com.xnjr.mall.enums;

/** 
 * @author: wuql
 * @since: 2016年1月13日 下午4:47:10 
 * @history:
 */
public enum ETraderStatus {
    ENABLE("1", "在职"), DISABLE("0", "离职");

    ETraderStatus(String code, String value) {
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
