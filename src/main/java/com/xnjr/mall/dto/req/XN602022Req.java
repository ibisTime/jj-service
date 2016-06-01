package com.xnjr.mall.dto.req;

/**
 * 支付订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN602022Req {

    // 编号（必填）
    private String code;

    // 交易密码（必填）
    private String tradePwd;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }
}
