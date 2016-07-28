package com.xnjr.mall.enums;

/**
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:28:36 
 * @history:
 */
public enum EInvoiceType {
    SH_SALE("1", "散买"), PFS_SALE("2", "批发"), FXS_SALE("3", "分销商订单");

    EInvoiceType(String code, String value) {
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
