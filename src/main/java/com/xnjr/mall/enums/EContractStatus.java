package com.xnjr.mall.enums;

public enum EContractStatus {
    SX("1", "生效中"), GQ("2", "过期");

    EContractStatus(String code, String value) {
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
