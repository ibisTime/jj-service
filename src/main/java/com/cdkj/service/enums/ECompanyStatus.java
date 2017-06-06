package com.cdkj.service.enums;

public enum ECompanyStatus {
    APPLY("1", "待审核"), PASS_YES("2", "审核通过"), PASS_NO("3", "审核不通过");

    ECompanyStatus(String code, String value) {
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
