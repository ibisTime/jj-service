/**
 * @Title PTCompany.java 
 * @Package com.xnjr.moom.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午7:43:29 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午7:43:29 
 * @history:
 */
public class PTCompany extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 8997693564930346373L;

    // 公司编号
    private String code;

    // 公司名称
    private String zwName;

    // 英文名称
    private String ywName;

    // 注册地址
    private String zcAddress;

    // 经营地址
    private String jyAddress;

    // 币种
    private String currency;

    // 注册资本
    private String capital;

    // 法人
    private String frPerson;

    // 股东
    private String gdPerson;

    // 财务负责人
    private String cwPerson;

    // 大额变动提醒人
    private String debdtxPerson;

    // 网银录入人
    private String wyRecorder;

    // 网银审核人
    private String wyChecker;

    // 公司座机
    private String telephone;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZwName() {
        return zwName;
    }

    public void setZwName(String zwName) {
        this.zwName = zwName;
    }

    public String getYwName() {
        return ywName;
    }

    public void setYwName(String ywName) {
        this.ywName = ywName;
    }

    public String getZcAddress() {
        return zcAddress;
    }

    public void setZcAddress(String zcAddress) {
        this.zcAddress = zcAddress;
    }

    public String getJyAddress() {
        return jyAddress;
    }

    public void setJyAddress(String jyAddress) {
        this.jyAddress = jyAddress;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFrPerson() {
        return frPerson;
    }

    public void setFrPerson(String frPerson) {
        this.frPerson = frPerson;
    }

    public String getGdPerson() {
        return gdPerson;
    }

    public void setGdPerson(String gdPerson) {
        this.gdPerson = gdPerson;
    }

    public String getCwPerson() {
        return cwPerson;
    }

    public void setCwPerson(String cwPerson) {
        this.cwPerson = cwPerson;
    }

    public String getDebdtxPerson() {
        return debdtxPerson;
    }

    public void setDebdtxPerson(String debdtxPerson) {
        this.debdtxPerson = debdtxPerson;
    }

    public String getWyRecorder() {
        return wyRecorder;
    }

    public void setWyRecorder(String wyRecorder) {
        this.wyRecorder = wyRecorder;
    }

    public String getWyChecker() {
        return wyChecker;
    }

    public void setWyChecker(String wyChecker) {
        this.wyChecker = wyChecker;
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

    @Override
    public String toString() {
        return "PlatCompany [code=" + code + ", zwName=" + zwName + ", ywName="
                + ywName + ", zcAddress=" + zcAddress + ", jyAddress="
                + jyAddress + ",currency=" + currency + ", capital=" + capital
                + ", frPerson=" + frPerson + ", gdPerson=" + gdPerson
                + ", cwPerson=" + cwPerson + ", debdtxPerson=" + debdtxPerson
                + ", wyRecorder=" + wyRecorder + ", wyChecker=" + wyChecker
                + ", telephone=" + telephone + ", remark=" + remark + "]";
    }

}
