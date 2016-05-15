package com.xnjr.mall.enums;

public enum EProjectType {
    GENGERAL("1", "普通标"), CUSTOM("2", "定制标");

    EProjectType(String code, String value) {
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
