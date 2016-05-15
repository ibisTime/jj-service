/**
 * @Title GjsAccountJour.java 
 * @Package com.xnjr.pop.domain 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 下午12:51:36 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * 个金所账户流水
 * @author: xieyj 
 * @since: 2015年11月13日 下午12:51:36 
 * @history:
 */
public class GjsAccountJour extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private Date createDatetimeStart;

    private Date createDatetimeEnd;

    private Date checkDatetimeStart;

    private Date checkDatetimeEnd;

    // *******db properties******
    // 账户流水编号
    private Long ajNo;

    // 状态
    private String status;

    // 业务类型
    private String bizType;

    // 参考订单号
    private String refNo;

    // 发生金额
    private Long transAmount;

    // 发生前金额
    private Long preAmount;

    // 发生后金额
    private Long postAmount;

    // 备注
    private String remark;

    // 创建时间
    private Date createDatetime;

    // 对账日期(yyyyDDMM)
    private String workDate;

    // 审核人
    private String checkUser;

    // 审核时间
    private Date checkDatetime;

    // 账户编号
    private String accountNumber;

    // *******db properties******

    public Date getCreateDatetimeStart() {
        return createDatetimeStart;
    }

    public void setCreateDatetimeStart(Date createDatetimeStart) {
        this.createDatetimeStart = createDatetimeStart;
    }

    public Date getCreateDatetimeEnd() {
        return createDatetimeEnd;
    }

    public void setCreateDatetimeEnd(Date createDatetimeEnd) {
        this.createDatetimeEnd = createDatetimeEnd;
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

    public Long getAjNo() {
        return ajNo;
    }

    public void setAjNo(Long ajNo) {
        this.ajNo = ajNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public Long getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Long transAmount) {
        this.transAmount = transAmount;
    }

    public Long getPreAmount() {
        return preAmount;
    }

    public void setPreAmount(Long preAmount) {
        this.preAmount = preAmount;
    }

    public Long getPostAmount() {
        return postAmount;
    }

    public void setPostAmount(Long postAmount) {
        this.postAmount = postAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
