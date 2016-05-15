package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 标的
 * @author: myb858 
 * @since: 2016年1月16日 下午3:21:08 
 * @history:
 */
public class Project extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5171528083064609504L;

    /******搜索条件start********/
    // 募集开始时间开始于
    private Date mjstartDatetimeStart;

    // 募集开始时间结束于
    private Date mjstartDatetimeEnd;

    // 募集结束时间开始于
    private Date mjendDatetimeStart;

    // 募集结束时间结束于
    private Date mjendDatetimeEnd;

    // 初审时间
    private Date checkDatetimeStart;

    private Date checkDatetimeEnd;

    /******搜索条件end**********/

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

    // 非定制/定制
    private String type;

    // 指定企业编号
    private String towho;

    // 额度/募集金额
    private Long amount;

    // 操盘手userId
    private String trader;

    // 操盘手名字
    private String traderName;

    // '概述'
    private String summary;

    // '描述'
    private String description;

    // '最小投资金额（绝对值）'
    private Long minInvestAmount;

    // '递增投资金额（绝对值）'
    private Long investAmountStep;

    // '单笔最大投资金额（绝对值）'
    private Long maxInvestAmount;

    // '合同模板
    private Long contractTemplate;

    // 发起人
    private String applyUser;

    // 发起时间
    private Date applyDatetime;

    // '募集开始时间'：初审是通过时确定
    private Date mjstartDatetime;

    // 募集期限(单位小时)
    private Long period;

    // '募集结束时间'
    private Date mjendDatetime;

    // 预计还款时间
    private Date repayDatetime;

    // 已经借到金额(绝对值):初审是通过时确定初始为0
    private Long loanedAmount;

    // 初审人
    private String checkUser;

    // 初核结果说明
    private String checkNote;

    // 初审时间
    private Date checkDatetime;

    // 实际标的结束时间
    private Date endDatetime;

    // 备注
    private String remark;

    public Date getMjstartDatetimeStart() {
        return mjstartDatetimeStart;
    }

    public void setMjstartDatetimeStart(Date mjstartDatetimeStart) {
        this.mjstartDatetimeStart = mjstartDatetimeStart;
    }

    public Date getMjstartDatetimeEnd() {
        return mjstartDatetimeEnd;
    }

    public void setMjstartDatetimeEnd(Date mjstartDatetimeEnd) {
        this.mjstartDatetimeEnd = mjstartDatetimeEnd;
    }

    public Date getMjendDatetimeStart() {
        return mjendDatetimeStart;
    }

    public void setMjendDatetimeStart(Date mjendDatetimeStart) {
        this.mjendDatetimeStart = mjendDatetimeStart;
    }

    public Date getMjendDatetimeEnd() {
        return mjendDatetimeEnd;
    }

    public void setMjendDatetimeEnd(Date mjendDatetimeEnd) {
        this.mjendDatetimeEnd = mjendDatetimeEnd;
    }

    public Date getCheckDatetimeStart() {
        return checkDatetimeStart;
    }

    public void setCheckDatetimeStart(Date checkDatetimeStart) {
        this.checkDatetimeStart = checkDatetimeStart;
    }

    public Date getCheckDatetimeEnd() {
        return checkDatetimeEnd;
    }

    public void setCheckDatetimeEnd(Date checkDatetimeEnd) {
        this.checkDatetimeEnd = checkDatetimeEnd;
    }

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

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
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

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getMjstartDatetime() {
        return mjstartDatetime;
    }

    public void setMjstartDatetime(Date mjstartDatetime) {
        this.mjstartDatetime = mjstartDatetime;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Date getMjendDatetime() {
        return mjendDatetime;
    }

    public void setMjendDatetime(Date mjendDatetime) {
        this.mjendDatetime = mjendDatetime;
    }

    public Date getRepayDatetime() {
        return repayDatetime;
    }

    public void setRepayDatetime(Date repayDatetime) {
        this.repayDatetime = repayDatetime;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public Date getCheckDatetime() {
        return checkDatetime;
    }

    public void setCheckDatetime(Date checkDatetime) {
        this.checkDatetime = checkDatetime;
    }

    public String getCheckNote() {
        return checkNote;
    }

    public void setCheckNote(String checkNote) {
        this.checkNote = checkNote;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getTowho() {
        return towho;
    }

    public void setTowho(String towho) {
        this.towho = towho;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
