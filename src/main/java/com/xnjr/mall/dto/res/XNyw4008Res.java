package com.xnjr.mall.dto.res;

import java.util.Date;

import com.xnjr.mall.domain.GSTrader;

public class XNyw4008Res {
    // 项目编号
    private String code;

    // 名称
    private String name;

    // 状态
    private String status;

    // 服务类型
    private String serve;

    // 报价模式
    private String quote;

    // 报价具体值1（年化值/分成值/保底值）。百分之
    private Double quoteValue1;

    // 报价具体值2（分成值）。百分之
    private Double quoteValue2;

    // 受众等级
    private Integer level;

    // 总金额（5亿）
    private Long totalAmount;

    // 额度/期限
    private String type;

    // 指定企业编号
    private String towho;

    // 额度/募集金额
    private Long amount;

    // 已经借到金额(绝对值):初始为0
    private Long loanedAmount;

    // '概述'
    private String summary;

    // '描述'
    private String description;

    // '募集开始时间'：初审是通过时确定
    private Date mjstartDatetime;

    // 募集期限(单位小时)
    private Long period;

    // '募集结束时间'
    private Date mjendDatetime;

    // '最小投资金额（绝对值）'
    private Long minInvestAmount;

    // '递增投资金额（绝对值）'
    private Long investAmountStep;

    // '单笔最大投资金额（绝对值）'
    private Long maxInvestAmount;

    // '合同模板
    private Long contractTemplate;

    // 预计还款时间
    private Date repayDatetime;

    // 备注
    private String remark;

    // 操盘手
    private GSTrader trader;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Double getQuoteValue1() {
        return quoteValue1;
    }

    public void setQuoteValue1(Double quoteValue1) {
        this.quoteValue1 = quoteValue1;
    }

    public Double getQuoteValue2() {
        return quoteValue2;
    }

    public void setQuoteValue2(Double quoteValue2) {
        this.quoteValue2 = quoteValue2;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getLoanedAmount() {
        return loanedAmount;
    }

    public void setLoanedAmount(Long loanedAmount) {
        this.loanedAmount = loanedAmount;
    }

    public GSTrader getTrader() {
        return trader;
    }

    public void setTrader(GSTrader trader) {
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

    public Date getMjstartDatetime() {
        return mjstartDatetime;
    }

    public void setMjstartDatetime(Date mjstartDatetime) {
        this.mjstartDatetime = mjstartDatetime;
    }

    public Date getMjendDatetime() {
        return mjendDatetime;
    }

    public void setMjendDatetime(Date mjendDatetime) {
        this.mjendDatetime = mjendDatetime;
    }

    public Long getMinInvestAmount() {
        return minInvestAmount;
    }

    public void setMinInvestAmount(Long minInvestAmount) {
        this.minInvestAmount = minInvestAmount;
    }

    public Long getInvestAmountStep() {
        return investAmountStep;
    }

    public void setInvestAmountStep(Long investAmountStep) {
        this.investAmountStep = investAmountStep;
    }

    public Long getMaxInvestAmount() {
        return maxInvestAmount;
    }

    public void setMaxInvestAmount(Long maxInvestAmount) {
        this.maxInvestAmount = maxInvestAmount;
    }

    public Long getContractTemplate() {
        return contractTemplate;
    }

    public void setContractTemplate(Long contractTemplate) {
        this.contractTemplate = contractTemplate;
    }

    public Date getRepayDatetime() {
        return repayDatetime;
    }

    public void setRepayDatetime(Date repayDatetime) {
        this.repayDatetime = repayDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTowho() {
        return towho;
    }

    public void setTowho(String towho) {
        this.towho = towho;
    }
}
