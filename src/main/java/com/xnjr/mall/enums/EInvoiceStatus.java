package com.xnjr.mall.enums;

/**
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:28:36 
 * @history:
 */
public enum EInvoiceStatus {
    COMMIT("1", "已提交，待支付"), CANCEL("2", "已取消"), PAY("3", "已支付，待发货"), SEND_YES(
            "4", "已发货，待收货"), SEND_NO("5", "系统退货"), RECEIVE("6", "已收货"), RETURN(
            "7", "客户退货");

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
