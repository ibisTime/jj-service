package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 业务
 * @author: myb858 
 * @since: 2016年1月16日 下午3:22:40 
 * @history:
 */
public class Business extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -4400010143540699953L;

    // 业务编号
    private String code;

    // 业务名称
    private String name;

    // '状态'
    private String status;

    // 本金
    private Long principal;

    // 收益
    private Long profit;

    // 核算表附件
    private String hsbUrl;

    // 核算凭证附件
    private String hspzUrl;

    // 附件
    private String fjUrl;

    // 开始时间（与结束时间一同提交），它与收款确认时间进行比较！
    private Date startDatetime;

    // 结束时间
    private Date endDatetime;

    // 发起人
    private String applyUser;

    // 发起时间
    private Date applyDatetime;

    // 审核人
    private String checkUser;

    // 审核时间
    private Date checkDatetime;

    // 备注
    private String remark;

    // 项目编号
    private String subjectCode;

    // 是否可见：1=前端可见；0=前端不可见
    private String isVisual;

    // 合同编号
    private String contractCode;

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

    public Long getPrincipal() {
        return principal;
    }

    public void setPrincipal(Long principal) {
        this.principal = principal;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    public String getHsbUrl() {
        return hsbUrl;
    }

    public void setHsbUrl(String hsbUrl) {
        this.hsbUrl = hsbUrl;
    }

    public String getHspzUrl() {
        return hspzUrl;
    }

    public void setHspzUrl(String hspzUrl) {
        this.hspzUrl = hspzUrl;
    }

    public String getFjUrl() {
        return fjUrl;
    }

    public void setFjUrl(String fjUrl) {
        this.fjUrl = fjUrl;
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

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public Date getCheckDatetime() {
        return checkDatetime;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public void setCheckDatetime(Date checkDatetime) {
        this.checkDatetime = checkDatetime;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getIsVisual() {
        return isVisual;
    }

    public void setIsVisual(String isVisual) {
        this.isVisual = isVisual;
    }
}
