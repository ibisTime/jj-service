package com.xnjr.mall.dto.req;

public class XNyw4021Req {

    // 金额(必填)
    private String amount;

    // 到款时间(必填)--YYYY-MM-DD hh:mm:ss
    private String moneyDatetime;

    // 认购编号(必填)
    private String investCode;

    // 来方(必填)
    private String fromCompany;

    // 来方银行卡(必填)
    private String fromCompanyCard;

    // 受方(必填)
    private String toCompany;

    // 受方银行卡(必填)
    private String toCompanyCard;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMoneyDatetime() {
        return moneyDatetime;
    }

    public void setMoneyDatetime(String moneyDatetime) {
        this.moneyDatetime = moneyDatetime;
    }

    public String getInvestCode() {
        return investCode;
    }

    public void setInvestCode(String investCode) {
        this.investCode = investCode;
    }

    public String getFromCompany() {
        return fromCompany;
    }

    public void setFromCompany(String fromCompany) {
        this.fromCompany = fromCompany;
    }

    public String getFromCompanyCard() {
        return fromCompanyCard;
    }

    public void setFromCompanyCard(String fromCompanyCard) {
        this.fromCompanyCard = fromCompanyCard;
    }

    public String getToCompany() {
        return toCompany;
    }

    public void setToCompany(String toCompany) {
        this.toCompany = toCompany;
    }

    public String getToCompanyCard() {
        return toCompanyCard;
    }

    public void setToCompanyCard(String toCompanyCard) {
        this.toCompanyCard = toCompanyCard;
    }
}
