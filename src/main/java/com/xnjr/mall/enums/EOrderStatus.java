/**
 * @Title EOrderState.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午3:22:19 
 * @version V1.0   
 */
package com.xnjr.mall.enums;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午3:22:19 
 * @history:
 */
public enum EOrderStatus {
    todoAPPROVE("1", "待审批"), APPROVE_NO("2", "审批不通过"), APPROVE_YES("3", "已审批-待支付"), UNPAY(
            "4", "不用审批-待支付"), PAY_NO("5", "支付失败"), PAY_YES("6", "支付成功");

    EOrderStatus(String code, String value) {
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
