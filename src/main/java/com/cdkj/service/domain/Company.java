package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 企业/个体户
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class Company extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 名称
    private String name;

    // 简称
    private String abbrName;

    // 工商营业执照
    private String gsyyzzh;

    // logo
    private String logo;

    // 缩略图
    private String pic;

    // 广告图
    private String advPic;

    // 广告语
    private String slogan;

    // 法人
    private String corporation;

    // 身份证
    private String idNo;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

    // 地址
    private String address;

    // 经度
    private String longitude;

    // 维度
    private String latitude;

    // 简介
    private String description;

    // 规模
    private String scale;

    // 注册资金
    private String registeredCapital;

    // 成立年限
    private String regtime;

    // 被关注数量
    private Integer gzNum;

    // 电话
    private String mobile;

    // 邮箱
    private String email;

    // QQ
    private String qq;

    // 微信号
    private String weChat;

    // UI位置
    private String location;

    // UI顺序
    private String orderNo;

    // 是否默认
    private String isDefault;

    // 报价区间
    private String priceRange;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 最后修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 所属用户
    private String userId;

    // ****************DB**************
    // 是否关注
    private String isFocus;

    // 资质类型
    private String qualifyType;

    // 关注编号
    private String focusCode;

    // 联系人
    private String realName;

    // 公司资质
    private GsQualify gsQualify;

    // 资质
    private String qualifyName;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setGsyyzzh(String gsyyzzh) {
        this.gsyyzzh = gsyyzzh;
    }

    public String getGsyyzzh() {
        return gsyyzzh;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getScale() {
        return scale;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setGzNum(Integer gzNum) {
        this.gzNum = gzNum;
    }

    public Integer getGzNum() {
        return gzNum;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return qq;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(String isFocus) {
        this.isFocus = isFocus;
    }

    public String getFocusCode() {
        return focusCode;
    }

    public void setFocusCode(String focusCode) {
        this.focusCode = focusCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getQualifyType() {
        return qualifyType;
    }

    public void setQualifyType(String qualifyType) {
        this.qualifyType = qualifyType;
    }

    public GsQualify getGsQualify() {
        return gsQualify;
    }

    public void setGsQualify(GsQualify gsQualify) {
        this.gsQualify = gsQualify;
    }

    public String getQualifyName() {
        return qualifyName;
    }

    public void setQualifyName(String qualifyName) {
        this.qualifyName = qualifyName;
    }

}
