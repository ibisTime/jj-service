/**
 * @Title WillInvest.java 
 * @Package com.xnjr.pop.domain 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 上午10:05:04 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * 意向认购
 * @author: xieyj 
 * @since: 2015年11月13日 上午10:05:04 
 * @history:
 */
public class WillInvest extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private Date investDatetimeStart;

    private Date investDatetimeEnd;

    // ************db properties***********

    // 编号
    private String code;

    // 状态
    private String status;

    // 标的编号
    private String projectCode;

    // 投资用户编号
    private String userId;

    // 投资用户姓名
    private String realName;

    // 投资时有的金额(描述一种状态)
    private Long nowAmount;

    // 投资时有的说明(描述一种状态)
    private String nowNote;

    // 投资时间
    private Date investDatetime;

    // 确认认购/取消认购的时间
    private Date checkDatetime;

    // 项目编号
    private String subjectCode;

    // 备注
    private String remark;

    // ************db properties***********

    // ************show info***********
    // 认购项目信息
    private Subject subject;

    // 认购标的信息
    private Project project;

    // ************show info***********

    public Date getInvestDatetimeStart() {
        return investDatetimeStart;
    }

    public void setInvestDatetimeStart(Date investDatetimeStart) {
        this.investDatetimeStart = investDatetimeStart;
    }

    public Date getInvestDatetimeEnd() {
        return investDatetimeEnd;
    }

    public void setInvestDatetimeEnd(Date investDatetimeEnd) {
        this.investDatetimeEnd = investDatetimeEnd;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getNowAmount() {
        return nowAmount;
    }

    public void setNowAmount(Long nowAmount) {
        this.nowAmount = nowAmount;
    }

    public String getNowNote() {
        return nowNote;
    }

    public void setNowNote(String nowNote) {
        this.nowNote = nowNote;
    }

    public Date getInvestDatetime() {
        return investDatetime;
    }

    public void setInvestDatetime(Date investDatetime) {
        this.investDatetime = investDatetime;
    }

    public Date getCheckDatetime() {
        return checkDatetime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
