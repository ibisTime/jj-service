package com.cdkj.service.enums;

public enum EIntentionType {
    ZW("1", "职位申请"), XQ("2", "感兴趣关系");

    EIntentionType(String code, String value) {
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
