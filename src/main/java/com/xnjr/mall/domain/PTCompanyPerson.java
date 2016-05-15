package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 公司人员
 * @author: xieyj 
 * @since: 2016年3月4日 下午10:02:14 
 * @history:
 */
public class PTCompanyPerson extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -3828053189701872526L;

    // 编号
    private String userId;

    // 名称
    private String realName;

    // 证件类型
    private String idKind;

    // 身份证号
    private String idNo;

    // 身份证有效期
    private String idYxq;

    // 手机号
    private String mobile;

    // 座机
    private String telephone;

    // 备注
    private String remark;

    // 公司编号
    private String companyCode;

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

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdYxq() {
        return idYxq;
    }

    public void setIdYxq(String idYxq) {
        this.idYxq = idYxq;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

}
