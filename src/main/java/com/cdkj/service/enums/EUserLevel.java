package com.cdkj.service.enums;

/**
 * 用户等级
 * @author: xieyj 
 * @since: 2016年5月24日 上午9:11:47 
 * @history:
 */
public enum EUserLevel {
    ZERO("0", "零级"), ONE("1", "一级"), TWO("2", "二级");

    EUserLevel(String code, String value) {
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
