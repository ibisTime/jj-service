package com.xnjr.mall.dto.req;

/**
 * 订单分页查询
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN602025Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 订单编号（选填）
    private String code;

    // 用户编号（选填）
    private String applyUser;

    // 用户名（选填）
    private String loginName;

    // 状态（选填）
    private String status;

    // 是否二次付款（选填）
    private String isSecondPay;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIsSecondPay() {
        return isSecondPay;
    }

    public void setIsSecondPay(String isSecondPay) {
        this.isSecondPay = isSecondPay;
    }
}
