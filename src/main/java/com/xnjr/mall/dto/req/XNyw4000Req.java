package com.xnjr.mall.dto.req;

public class XNyw4000Req {

    // '名称'
    private String name;

    // '服务类型'
    private String serve;

    // 报价模式；
    private String quote;

    // 报价具体值1（年化值/分成值/保底值）。百分之
    private String quoteValue1;

    // 报价具体值2（分成值）。百分之
    private String quoteValue2;

    // 受众等级
    private String level;

    // 总金额（5亿）
    private String totalAmount;

    // 定制/非定制
    private String type;

    // 指定企业编号
    private String towho;

    // 额度/募集金额
    private String amount;

    // 操盘手
    private String trader;

    // '概述'
    private String summary;

    // '描述'
    private String description;

    // '最小投资金额（绝对值）'
    private String minInvestAmount;

    // '递增投资金额（绝对值）'
    private String investAmountStep;

    // '单笔最大投资金额（绝对值）'
    private String maxInvestAmount;

    // '合同模板
    private String contractTemplate;

    // 发起人
    private String applyUser;

    // 备注
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServe() {
        return serve;
    }

    public void setServe(String serve) {
        this.serve = serve;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuoteValue1() {
        return quoteValue1;
    }

    public void setQuoteValue1(String quoteValue1) {
        this.quoteValue1 = quoteValue1;
    }

    public String getQuoteValue2() {
        return quoteValue2;
    }

    public void setQuoteValue2(String quoteValue2) {
        this.quoteValue2 = quoteValue2;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTowho() {
        return towho;
    }

    public void setTowho(String towho) {
        this.towho = towho;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinInvestAmount() {
        return minInvestAmount;
    }

    public void setMinInvestAmount(String minInvestAmount) {
        this.minInvestAmount = minInvestAmount;
    }

    public String getInvestAmountStep() {
        return investAmountStep;
    }

    public void setInvestAmountStep(String investAmountStep) {
        this.investAmountStep = investAmountStep;
    }

    public String getMaxInvestAmount() {
        return maxInvestAmount;
    }

    public void setMaxInvestAmount(String maxInvestAmount) {
        this.maxInvestAmount = maxInvestAmount;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getContractTemplate() {
        return contractTemplate;
    }

    public void setContractTemplate(String contractTemplate) {
        this.contractTemplate = contractTemplate;
    }
}
