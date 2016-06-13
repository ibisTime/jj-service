package com.xnjr.mall.enums;

/**
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:28:36 
 * @history:
 */
public enum EInvoiceStatus {
    TO_PAY("1", "待支付"), PAY_YES("2", "已支付"), SEND("3", "已发货"), RECEIVE("4",
            "已收货"), FINISH("5", "已完成");

    EInvoiceStatus(String code, String value) {
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
