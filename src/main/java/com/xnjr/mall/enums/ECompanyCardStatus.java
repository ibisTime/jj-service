package com.xnjr.mall.enums;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月18日 下午5:22:44 
 * @history:
 */
public enum ECompanyCardStatus {

    TOCONFIRM("0", "待确认"), CONFIRM_YES("1", "验证通过"), CONFIRM_NO("2", "验证不通过");

    ECompanyCardStatus(String code, String value) {
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
