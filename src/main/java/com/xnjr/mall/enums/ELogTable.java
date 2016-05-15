package com.xnjr.mall.enums;

public enum ELogTable {
    BKSubbranch("BKSubbranch", "银行方支行表");

    ELogTable(String code, String value) {
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
