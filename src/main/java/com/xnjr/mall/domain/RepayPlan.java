/**
 * @Title RepayPlan.java 
 * @Package com.xnjr.pop.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2015年11月13日 下午12:45:10 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月13日 下午12:45:10 
 * @history:
 */
public class RepayPlan extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 查询条件：还款时间的比较终止时点
    private Date repayDatetimeStart;

    // 查询条件：还款时间的比较终止时点
    private Date repayDatetimeEnd;

    // ---------db properties start--------------------------

    // 编号
    private String code;

    // 类型
    private String type;

    // 状态
    private String status;

    // 用户编号
    private String userId;

    // 真实姓名
    private String realName;

    // 理应还款还款时间
    private Date repayDatetime;

    // 理应还款本金(投资本金)
    private Long repayPrincipal;

    // 理应还款收益（投资本金产生的收益）
    private Long repayProfit;

    // 理应手续费（预留）
    private Long fee;

    // 实际还款到账时间(确定不还时间)
    private Date realRepayDatetime;

    // 实际还款本金
    private Long realRepayPrincipal;

    // 实际还款收益
    private Long realRepayProfit;

    // 实际手续费（预留）
    private Long realFee;

    // 备注
    private String remark;

    // 投资编号
    private String investCode;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getRepayDatetime() {
        return repayDatetime;
    }

    public void setRepayDatetime(Date repayDatetime) {
        this.repayDatetime = repayDatetime;
    }

    public Long getRepayPrincipal() {
        return repayPrincipal;
    }

    public void setRepayPrincipal(Long repayPrincipal) {
        this.repayPrincipal = repayPrincipal;
    }

    public Long getRepayProfit() {
        return repayProfit;
    }

    public void setRepayProfit(Long repayProfit) {
        this.repayProfit = repayProfit;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Date getRealRepayDatetime() {
        return realRepayDatetime;
    }

    public void setRealRepayDatetime(Date realRepayDatetime) {
        this.realRepayDatetime = realRepayDatetime;
    }

    public Long getRealRepayPrincipal() {
        return realRepayPrincipal;
    }

    public void setRealRepayPrincipal(Long realRepayPrincipal) {
        this.realRepayPrincipal = realRepayPrincipal;
    }

    public Long getRealRepayProfit() {
        return realRepayProfit;
    }

    public void setRealRepayProfit(Long realRepayProfit) {
        this.realRepayProfit = realRepayProfit;
    }

    public Long getRealFee() {
        return realFee;
    }

    public void setRealFee(Long realFee) {
        this.realFee = realFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInvestCode() {
        return investCode;
    }

    public void setInvestCode(String investCode) {
        this.investCode = investCode;
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

}
