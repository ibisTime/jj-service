/**
 * @Title XNpt0000Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:31:02 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:31:02 
 * @history:
 */
public class XNpt0000Req {

    // 名称（必填）
    private String realName;

    // 证件类型（必填）
    private String idKind;

    // 身份证号（必填）
    private String idNo;

    // 身份证过期时间（必填）
    private String idYxq;

    // 手机号（必填）
    private String mobile;

    // 座机（必填）
    private String telephone;

    // 备注（选填）
    private String remark;

    // 公司编号（必填）
    private String companyCode;

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
