package com.xnjr.mall.enums;

/**
 * 各方
 * @author: xieyj 
 * @since: 2016年4月20日 下午4:00:46 
 * @history:
 */
public enum EKind {
    SYSTEM("1", "系统方");

    EKind(String code, String value) {
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
