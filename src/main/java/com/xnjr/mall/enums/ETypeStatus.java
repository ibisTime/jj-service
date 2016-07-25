package com.xnjr.mall.enums;

public enum ETypeStatus {
    ONLINE("1", "启用"), OFFLINE("0", "不启用");

    ETypeStatus(String code, String value) {
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
