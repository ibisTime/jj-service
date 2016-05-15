package com.xnjr.mall.enums;

public enum EGjsBizType {
    ZYW("1", "做业务");

    EGjsBizType(String code, String value) {
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
