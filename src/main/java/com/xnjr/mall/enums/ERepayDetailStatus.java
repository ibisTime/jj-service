package com.xnjr.mall.enums;

public enum ERepayDetailStatus {
    todoRepay("1", "待还"), offlineRepayed("2", "线下已还"), onlineRepayed("3",
            "线下未还");

    ERepayDetailStatus(String code, String value) {
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
