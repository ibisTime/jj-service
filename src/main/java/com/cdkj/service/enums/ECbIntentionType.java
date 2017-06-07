package com.cdkj.service.enums;

public enum ECbIntentionType {
    POSITION("1", "职位申请"), SERVE("2", "服务申请"), TALK("3", "洽谈");

    ECbIntentionType(String code, String value) {
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
