package com.xnjr.mall.enums;

public enum EBusinessVisual {
    YES("1", "可见"), NO("0", "不可见");

    EBusinessVisual(String code, String value) {
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
