package com.xnjr.mall.enums;

/**
 * 订单前缀编号
 * @author: xieyj 
 * @since: 2016年4月28日 上午6:59:25 
 * @history:
 */
public enum EPrefixOrderNo {
    company("FC", "公司"), individual("FI", "个体户"), user("FU", "资金方用户");

    EPrefixOrderNo(String code, String value) {
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
