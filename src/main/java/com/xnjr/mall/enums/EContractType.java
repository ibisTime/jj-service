package com.xnjr.mall.enums;

public enum EContractType {
    Child("1", "认购合同"), Business("2", "业务合同");
    ;

    EContractType(String code, String value) {
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
