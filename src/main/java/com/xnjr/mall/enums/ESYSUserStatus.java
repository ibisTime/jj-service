package com.xnjr.mall.enums;

public enum ESYSUserStatus {
    NORMAL("1", "正常"), BLOCK("2", "注销");
    ESYSUserStatus(String code, String value) {
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
