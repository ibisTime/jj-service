package com.xnjr.mall.dto.req;

public class XNyw4024Req {
    // 认购编号(必填)
    private String investCode;

    // 认购金额(必填)
    private String investAmount;

    // 操盘手密码(必填)
    private String tradePwd;

    // 备注(必填)
    private String remark;

    public String getInvestCode() {
        return investCode;
    }

    public void setInvestCode(String investCode) {
        this.investCode = investCode;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
