package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 项目
 * @author: myb858 
 * @since: 2016年1月16日 下午3:20:56 
 * @history:
 */
public class Subject extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 140434047855199460L;

    // 项目编号
    private String code;

    // 项目名称
    private String name;

    // 项目状态
    private String status;

    // 项目总金额（5亿）
    private Long totalAmount;

    // 本金(累加)
    private Long totalPrincipal;

    // 收益(累加)
    private Long totalProfit;

    // 服务类型
    private String serve;

    // 报价模式
    private String quote;

    // 报价具体值1（年化值/分成值/年化保底值）。百分之
    private Double quoteValue1;

    // 报价具体值2（分成值）。百分之
    private Double quoteValue2;

    // 受众等级
    private Integer level;

    // 操盘手userId
    private String trader;

    // 操盘手名字
    private String traderName;

    // 开始时间（手工开始）
    private Date startDatetime;

    // 结束时间（手工结束）/流标时间
    private Date endDatetime;

    // 备注
    private String remark;

    // 标的编号
    private String projectCode;

    // **********db properties **********

    // 用户编号
    private String userId;

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

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalPrincipal() {
        return totalPrincipal;
    }

    public void setTotalPrincipal(Long totalPrincipal) {
        this.totalPrincipal = totalPrincipal;
    }

    public Long getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Long totalProfit) {
        this.totalProfit = totalProfit;
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

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
