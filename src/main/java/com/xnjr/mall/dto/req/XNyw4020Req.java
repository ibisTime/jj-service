package com.xnjr.mall.dto.req;

public class XNyw4020Req {

    // 投资用户编号(必填)
    private String userId;

    // 标的编号(必填)
    private String projectCode;

    // 投资金额
    private String investAmount;

    // 交易密码(必填)
    private String tradePwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }
}
