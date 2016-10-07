package com.cdkj.service.enums;

public enum EUser {
    Top_Model("U201600000000000001", "顶级货品商"), Top_Integral(
            "U201600000000000001", "顶级积分商");

    EUser(String code, String value) {
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
