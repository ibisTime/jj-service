package com.xnjr.mall.dto.res;

public class XNyw4074Res {
    private String userId;

    // 累计还款本金(投资本金)
    private Long totalRepayPrincipal;

    // 累计还款收益（投资本金产生的收益）
    private Long totalRepayProfit;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTotalRepayPrincipal() {
        return totalRepayPrincipal;
    }

    public void setTotalRepayPrincipal(Long totalRepayPrincipal) {
        this.totalRepayPrincipal = totalRepayPrincipal;
    }

    public Long getTotalRepayProfit() {
        return totalRepayProfit;
    }

    public void setTotalRepayProfit(Long totalRepayProfit) {
        this.totalRepayProfit = totalRepayProfit;
    }

}
