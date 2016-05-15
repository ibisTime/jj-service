package com.xnjr.mall.dto.req;

public class XN803313Req {
    // 项目编号（必填）
    private String projectCode;

    // 认购金额（必填）
    private String investAmount;

    // 认购时间，精确到天（必填）
    private String investDate;

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

    public String getInvestDate() {
        return investDate;
    }

    public void setInvestDate(String investDate) {
        this.investDate = investDate;
    }

}
