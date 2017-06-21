package com.cdkj.service.enums;

public enum ECbIntentionStatus {
    APPLY("1", "待处理"), PASS_YES("2", "处理成功"), PASS_NO("3", "处理失败");

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
