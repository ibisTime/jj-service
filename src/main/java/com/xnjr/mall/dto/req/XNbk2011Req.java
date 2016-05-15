/**
 * @Title XN803551Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午4:20:38 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:20:38 
 * @history:
 */
public class XNbk2011Req {
    // 银行编号
    private String code;

    // 所属银行
    private String name;

    // 银行编号
    private String bankCode;

    // 所在区域
    private String region;

    // 银行地址
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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
