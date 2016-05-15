package com.xnjr.mall.enums;

public enum EProjectStatus {
    todoAPPROVE("1", "待初审"), APPROVE_YES("2", "初审通过，进入可募集状态"), APPROVE_NO("3",
            "初审不通过，进入可重提状态"), LI_END("4", "程序自动结束"), REN_END("5", "人为强制结束");

    EProjectStatus(String code, String value) {
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
