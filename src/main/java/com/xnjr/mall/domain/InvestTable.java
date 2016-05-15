package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 认购打款记录
 * @author: myb858 
 * @since: 2016年1月17日 下午4:51:42 
 * @history:
 */
public class InvestTable extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7467450248780365887L;

    // 流水编号
    private String code;

    // 金额
    private Long amount;

    // 利息开始时间
    private Date lxstartDatetime;

    // 创建时间
    private Date createDatetime;

    // 认购编号
    private String investCode;

    // 来方
    private String fromCompany;

    // 来方银行卡
    private String fromCompanyCard;

    // 受方
    private String toCompany;

    // 受方银行卡
    private String toCompanyCard;

    // ********* db properties ***********
    private String subjectCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getLxstartDatetime() {
        return lxstartDatetime;
    }

    public void setLxstartDatetime(Date lxstartDatetime) {
        this.lxstartDatetime = lxstartDatetime;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
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

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
