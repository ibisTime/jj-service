package com.xnjr.mall.enums;

/**
 * 各方
 * @author: xieyj 
 * @since: 2016年4月20日 下午4:00:46 
 * @history:
 */
public enum EKind {
    SYSTEM("1", "系统方"), BANK("2", "银行方"), GS("3", "中国高盛"), PLAT("4", "平台方"), FUND(
            "5", "资金方"), TRADE("6", "贸易方");

    EKind(String code, String value) {
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
