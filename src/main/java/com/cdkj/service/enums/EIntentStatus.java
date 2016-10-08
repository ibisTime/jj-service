package com.cdkj.service.enums;

public enum EIntentStatus {
    APPLY("1", "申请中"), FINISH("2", "已完成");

    EIntentStatus(String code, String value) {
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
