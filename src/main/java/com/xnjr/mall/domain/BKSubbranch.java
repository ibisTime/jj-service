package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 支行
 * @author: xieyj 
 * @since: 2016年4月15日 上午10:48:38 
 * @history:
 */
public class BKSubbranch extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -6568526690810128154L;

    // 编号
    private String code;

    // 支行名称
    private String name;

    // 状态
    private String status;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 所在地区
    private String region;

    // 所在地址
    private String address;

    // 中国现代化支付系统（CNAPS）号
    private String cnapsCode;

    // 银行国际代码
    private String swiftCode;

    // 客户经理
    private String khjlPerson;

    // 联系方式
    private String khjlContact;

    // 更改人
    private String updater;

    // 更改时间
    private Date updateDatetime;

    // 备注
    private String remark;

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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnapsCode() {
        return cnapsCode;
    }

    public void setCnapsCode(String cnapsCode) {
        this.cnapsCode = cnapsCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getKhjlPerson() {
        return khjlPerson;
    }

    public void setKhjlPerson(String khjlPerson) {
        this.khjlPerson = khjlPerson;
    }

    public String getKhjlContact() {
        return khjlContact;
    }

    public void setKhjlContact(String khjlContact) {
        this.khjlContact = khjlContact;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
