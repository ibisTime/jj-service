package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;
import com.cdkj.service.dto.res.XN806010Res;

/**
 * 服务
 * @author: asus 
 * @since: 2017年6月7日 下午1:00:46 
 * @history:
 */
public class Serve extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 缩略图
    private String pic;

    // 广告图
    private String advPic;

    // 公司编号
    private String companyCode;

    // 公司名称
    private String companyName;

    // 报价最小值
    private Long quoteMin;

    // 报价最大值
    private Long quoteMax;

    // 资质编号
    private String qualityCode;

    // 描述
    private String description;

    // UI位置
    private String location;

    // UI顺序
    private Integer orderNo;

    // 状态
    private String status;

    // 发布人
    private String publisher;

    // 发布时间
    private Date publishDatetime;

    // 处理人
    private String dealer;

    // 处理时间
    private Date dealDatetime;

    // 处理备注
    private String dealNote;

    // 资质编号
    private String qualifyCode;

    //
    // ****************db properties ******************
    private Date publishDatetimeStart;

    private Date publishDatetimeEnd;

    private String qualityName;

    // 服务类型
    private String type;

    // 公司-省
    private String province;

    // 公司-市
    private String city;

    // 公司-区
    private String area;

    private XN806010Res res;

    private ServeArt serveArt;

    private ServeCp serveCp;

    private ServeCyy serveCyy;

    private ServeKfwb serveKfwb;

    private Company company;

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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getDealNote() {
        return dealNote;
    }

    public void setDealNote(String dealNote) {
        this.dealNote = dealNote;
    }

    public Long getQuoteMin() {
        return quoteMin;
    }

    public void setQuoteMin(Long quoteMin) {
        this.quoteMin = quoteMin;
    }

    public Long getQuoteMax() {
        return quoteMax;
    }

    public void setQuoteMax(Long quoteMax) {
        this.quoteMax = quoteMax;
    }

    public Date getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public Date getDealDatetime() {
        return dealDatetime;
    }

    public void setDealDatetime(Date dealDatetime) {
        this.dealDatetime = dealDatetime;
    }

    public Date getPublishDatetimeStart() {
        return publishDatetimeStart;
    }

    public void setPublishDatetimeStart(Date publishDatetimeStart) {
        this.publishDatetimeStart = publishDatetimeStart;
    }

    public Date getPublishDatetimeEnd() {
        return publishDatetimeEnd;
    }

    public void setPublishDatetimeEnd(Date publishDatetimeEnd) {
        this.publishDatetimeEnd = publishDatetimeEnd;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ServeArt getServeArt() {
        return serveArt;
    }

    public void setServeArt(ServeArt serveArt) {
        this.serveArt = serveArt;
    }

    public ServeCp getServeCp() {
        return serveCp;
    }

    public void setServeCp(ServeCp serveCp) {
        this.serveCp = serveCp;
    }

    public ServeCyy getServeCyy() {
        return serveCyy;
    }

    public void setServeCyy(ServeCyy serveCyy) {
        this.serveCyy = serveCyy;
    }

    public ServeKfwb getServeKfwb() {
        return serveKfwb;
    }

    public void setServeKfwb(ServeKfwb serveKfwb) {
        this.serveKfwb = serveKfwb;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public XN806010Res getRes() {
        return res;
    }

    public void setRes(XN806010Res res) {
        this.res = res;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getQualifyCode() {
        return qualifyCode;
    }

    public void setQualifyCode(String qualifyCode) {
        this.qualifyCode = qualifyCode;
    }
}
