package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;
import com.cdkj.service.dto.res.XN806010Res;

public class Serve extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    private String companyCode;

    private Long quoteMin;

    private Long quoteMax;

    private String qualityCode;

    private String description;

    private String isHot;

    private int orderNo;

    private String status;

    private String publisher;

    private Date publishDatetime;

    private String dealer;

    private Date dealDatetime;

    private String dealNote;

    // ****************db properties ******************
    private Date publishDatetimeStart;

    private Date publishDatetimeEnd;

    // 服务类型
    private String type;

    // 公司-省
    private String province;

    // 公司-市
    private String city;

    // 公司-区
    private String area;

    private XN806010Res company;

    private ServeArt serveArt;

    private ServeCp serveCp;

    private ServeCyy serveCyy;

    private ServeKfwb serveKfwb;

    private ServePhoto servePhoto;

    private ServeShop serveShop;

    private ServeTrain serveTrain;

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

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
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

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
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

    public XN806010Res getCompany() {
        return company;
    }

    public void setCompany(XN806010Res company) {
        this.company = company;
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

    public ServePhoto getServePhoto() {
        return servePhoto;
    }

    public void setServePhoto(ServePhoto servePhoto) {
        this.servePhoto = servePhoto;
    }

    public ServeShop getServeShop() {
        return serveShop;
    }

    public void setServeShop(ServeShop serveShop) {
        this.serveShop = serveShop;
    }

    public ServeTrain getServeTrain() {
        return serveTrain;
    }

    public void setServeTrain(ServeTrain serveTrain) {
        this.serveTrain = serveTrain;
    }
}
