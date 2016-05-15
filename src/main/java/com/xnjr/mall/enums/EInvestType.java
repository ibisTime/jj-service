package com.xnjr.mall.enums;

public enum EInvestType {
    REAL("1", "实质认购"), FAKE("2", "状态描述");

    EInvestType(String code, String value) {
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
