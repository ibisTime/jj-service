package com.cdkj.service.enums;

public enum ECbIntentionStatus {
    APPLY("1", "未查看"), PASS_YES("2", "已查看/处理通过"), PASS_NO("3", "不通过");

    ECbIntentionStatus(String code, String value) {
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
