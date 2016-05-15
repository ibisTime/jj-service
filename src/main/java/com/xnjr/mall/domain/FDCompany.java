package com.xnjr.mall.domain;

import java.util.Date;
import java.util.List;

import com.xnjr.mall.dao.base.ABaseDO;

public class FDCompany extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 6587428813123728490L;

    // 申请起始时间
    private Date applyDatetimeStart;

    // 申请终止时间
    private Date applyDatetimeEnd;

    // 通过起始时间
    private Date kycDatetimeStart;

    // 通过终止时间
    private Date kycDatetimeEnd;

    /* ************* db company start *************** */

    private String code;

    // 公司名字
    private String name;

    // 工商营业执照号
    private String gsyyzzNo;

    // 法人证件类型
    private String idKind;

    // 法人证件号码
    private String idNo;

    // 法人真实姓名
    private String realName;

    // 币种
    private String currency;

    // 注册资金
    private Long capital;

    // 省
    private String province;

    // 市
    private String city;

    // 公司地址
    private String address;

    // 工商营业执照
    private String gsyyzzPicture;

    // 组织机构代码证
    private String zzjgdmzPicture;

    // 税务登记证
    private String swdjzPicture;

    // 电子章
    private String dzzPicture;

    // 法人身份证照片
    private String frPicture;

    // 其他照片
    private String otherPicture;

    // 状态
    private String status;

    private String kycUser;

    // KYC（通过）时间
    private Date kycDatetime;

    // 审核意见
    private String kycNote;

    // 服务列表
    private String serveList;

    // 报价模式
    private String quoteList;

    // 等级
    private Integer level;

    // 备注
    private String remark;

    /* ************* db company end *************** */
    private String sqghPicture;

    private List<FDCompanyCard> fdCompanyCardList;

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public Date getKycDatetimeStart() {
        return kycDatetimeStart;
    }

    public void setKycDatetimeStart(Date kycDatetimeStart) {
        this.kycDatetimeStart = kycDatetimeStart;
    }

    public Date getKycDatetimeEnd() {
        return kycDatetimeEnd;
    }

    public void setKycDatetimeEnd(Date kycDatetimeEnd) {
        this.kycDatetimeEnd = kycDatetimeEnd;
    }

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

    public String getGsyyzzNo() {
        return gsyyzzNo;
    }

    public void setGsyyzzNo(String gsyyzzNo) {
        this.gsyyzzNo = gsyyzzNo;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getCapital() {
        return capital;
    }

    public void setCapital(Long capital) {
        this.capital = capital;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGsyyzzPicture() {
        return gsyyzzPicture;
    }

    public void setGsyyzzPicture(String gsyyzzPicture) {
        this.gsyyzzPicture = gsyyzzPicture;
    }

    public String getZzjgdmzPicture() {
        return zzjgdmzPicture;
    }

    public void setZzjgdmzPicture(String zzjgdmzPicture) {
        this.zzjgdmzPicture = zzjgdmzPicture;
    }

    public String getSwdjzPicture() {
        return swdjzPicture;
    }

    public void setSwdjzPicture(String swdjzPicture) {
        this.swdjzPicture = swdjzPicture;
    }

    public String getDzzPicture() {
        return dzzPicture;
    }

    public void setDzzPicture(String dzzPicture) {
        this.dzzPicture = dzzPicture;
    }

    public String getFrPicture() {
        return frPicture;
    }

    public void setFrPicture(String frPicture) {
        this.frPicture = frPicture;
    }

    public String getOtherPicture() {
        return otherPicture;
    }

    public void setOtherPicture(String otherPicture) {
        this.otherPicture = otherPicture;
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

    public String getServeList() {
        return serveList;
    }

    public void setServeList(String serveList) {
        this.serveList = serveList;
    }

    public String getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(String quoteList) {
        this.quoteList = quoteList;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSqghPicture() {
        return sqghPicture;
    }

    public void setSqghPicture(String sqghPicture) {
        this.sqghPicture = sqghPicture;
    }

    public List<FDCompanyCard> getFdCompanyCardList() {
        return fdCompanyCardList;
    }

    public void setFdCompanyCardList(List<FDCompanyCard> fdCompanyCardList) {
        this.fdCompanyCardList = fdCompanyCardList;
    }
}
