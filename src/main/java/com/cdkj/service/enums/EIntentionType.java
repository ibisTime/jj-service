package com.cdkj.service.enums;

public enum EIntentionType {
    ZW("1", "职位申请"), FW("2", "对服务感兴趣"), XQ("3", "对需求感兴趣"), JL("4", "对简历感兴趣");

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
