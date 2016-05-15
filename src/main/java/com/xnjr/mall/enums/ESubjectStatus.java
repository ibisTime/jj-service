package com.xnjr.mall.enums;

public enum ESubjectStatus {
    todoStart("1", "待开始"), Started("2", "已开始，进行中"), Unstart("3", "不开始，流项目"), END(
            "4", "结束");

    ESubjectStatus(String code, String value) {
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
