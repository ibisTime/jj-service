package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 用户和公司关系表
 * @author: myb858 
 * @since: 2016年1月13日 下午10:18:36 
 * @history:
 */
public class FDUserCompany extends ABaseDO {
    private static final long serialVersionUID = 1975331351390818527L;

    // *************db properties **********************
    // id
    private Long id;

    // 用户ID
    private String userId;

    // 公司编号
    private String companyCode;

    // 申请公函
    private String sqghPicture;

    // 状态
    private String status;

    // 备注
    private String remark;

    // 审核人
    private String kycUser;

    // 审核时间
    private Date kycDatetime;

    // 审核意见
    private String kycNote;

    // *************db properties **********************

    // 真实姓名
    private String realName;

    // 公司名称
    private String companyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSqghPicture() {
        return sqghPicture;
    }

    public void setSqghPicture(String sqghPicture) {
        this.sqghPicture = sqghPicture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKycUser() {
        return kycUser;
    }

    public void setKycUser(String kycUser) {
        this.kycUser = kycUser;
    }

    public Date getKycDatetime() {
        return kycDatetime;
    }

    public void setKycDatetime(Date kycDatetime) {
        this.kycDatetime = kycDatetime;
    }

    public String getKycNote() {
        return kycNote;
    }

    public void setKycNote(String kycNote) {
        this.kycNote = kycNote;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
