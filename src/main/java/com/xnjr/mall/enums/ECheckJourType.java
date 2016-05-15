package com.xnjr.mall.enums;

public enum ECheckJourType {
    bk("bk", "银行方"), gs("gs", "中国高盛"), pt("pt", "平台方"), fd("fd", "资金方"), td(
            "td", "贸易方");

    ECheckJourType(String code, String value) {
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
