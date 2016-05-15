package com.xnjr.mall.enums;

public enum ELogSystem {
    MOOM("1", "生意家");

    ELogSystem(String code, String value) {
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
