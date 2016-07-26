package com.xnjr.mall.enums;

/**
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:28:36 
 * @history:
 */
public enum EInvoiceStatus {
    TO_PAY("1", "待支付"), PAY_START("2", "已首款"), NO_PAY("20", "不支付"), SEND("3",
            "已发货物流中"), NO_SEND("30", "不发货取消订单"), RECEIVE("4", "已收货"), PAY_END(
            "5", "已尾款"), TO_ROLLBACK("6", "待退货审核"), ROLLBACK_YES("7", "退货审核通过"), ROLLBACK_NO(
            "70", "退货审核不通过"), PAY_BACK("8", "已退款"),

    FINISH("9", "已完成");// （定时器2）完成的途径有：所有2位数，以及已退款，和超期的“已尾款”。
    // 定时器1，已收货状态的的全款单子，自动变成已尾款。定时器1先于定时器2。

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
