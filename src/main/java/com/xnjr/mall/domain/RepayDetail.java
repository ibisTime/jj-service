package com.xnjr.mall.domain;

import java.util.Date;
import java.util.List;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月13日 下午12:45:10 
 * @history:
 */
public class RepayDetail extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 查询条件：还款时间的比较终止时点
    private Date repayDatetimeStart;

    // 查询条件：还款时间的比较终止时点
    private Date repayDatetimeEnd;

    // 查询条件
    private List<String> towhoList;

    // ---------db properties start--------------------------

    // 编号
    private String code;

    // 类型
    private String type;

    // 状态
    private String status;

    // 用户编号
    private String towho;

    // 真实姓名
    private String towhoName;

    // 理应还款时间
    private Date repayDatetime;

    // 理应还款金额
    private Long amount;

    // 实际还款到账时间(确定不还时间)
    private Date realRepayDatetime;

    // 实际还款收益
    private Long realAmount;

    // 备注
    private String remark;

    // 业务编号
    private String businessCode;

    // 项目编号
    private String subjectCode;

    // 对应业务的收益
    private Long businessProfit;

    public Date getRepayDatetimeStart() {
        return repayDatetimeStart;
    }

    public void setRepayDatetimeStart(Date repayDatetimeStart) {
        this.repayDatetimeStart = repayDatetimeStart;
    }

    public Date getRepayDatetimeEnd() {
        return repayDatetimeEnd;
    }

    public void setRepayDatetimeEnd(Date repayDatetimeEnd) {
        this.repayDatetimeEnd = repayDatetimeEnd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTowho() {
        return towho;
    }

    public void setTowho(String towho) {
        this.towho = towho;
    }

    public String getTowhoName() {
        return towhoName;
    }

    public void setTowhoName(String towhoName) {
        this.towhoName = towhoName;
    }

    public Date getRepayDatetime() {
        return repayDatetime;
    }

    public void setRepayDatetime(Date repayDatetime) {
        this.repayDatetime = repayDatetime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getRealRepayDatetime() {
        return realRepayDatetime;
    }

    public void setRealRepayDatetime(Date realRepayDatetime) {
        this.realRepayDatetime = realRepayDatetime;
    }

    public Long getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Long realAmount) {
        this.realAmount = realAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Long getBusinessProfit() {
        return businessProfit;
    }

    public void setBusinessProfit(Long businessProfit) {
        this.businessProfit = businessProfit;
    }

    public List<String> getTowhoList() {
        return towhoList;
    }

    public void setTowhoList(List<String> towhoList) {
        this.towhoList = towhoList;
    }
}
