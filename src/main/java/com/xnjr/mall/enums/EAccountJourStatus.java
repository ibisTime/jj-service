package com.xnjr.mall.enums;

public enum EAccountJourStatus {
    // noCheck("0", "免对账"),不存在。即使红冲蓝补通过后都是待对账
    todoCheck("1", "待对账"), Checked("2", "已对账待调帐"), Done("9", "已对账且账已平");

    EAccountJourStatus(String code, String value) {
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
