package com.xnjr.mall.enums;

/**
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:28:36 
 * @history:
 */
public enum EInvoiceStatus {
    TO_PAY("1", "待支付"), PAY_CONFIRM("2", "付款待确认"), PAY_YES("3", "已付款"), SEND_YES(
            "4", "已发货"), FINISHED("5", "已完成"), SELF_CLOSED("6", "主动取消 "), FORBID_CLOSED(
            "7", "强制取消"), SYS_CLOSED("8", "系统自动关闭");

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
