package com.xnjr.mall.enums;

public enum EHLOrderType {
    TZ("1", "调账订单（不必对账）"), RG("2", "人工干预（需要对账）");
    EHLOrderType(String code, String value) {
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
