package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 摄影
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class Photo extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 服务名称
	private String name;

	//  缩略图
	private String pic;

	// 广告图
	private String advPic;

	// 公司编号
	private String companyCode;

	// 棚影数量
	private String pyNum;

	// 摄影师数量
	private String sysNum;

	// 是否定制需求
	private String isDz;

	// 擅长拍摄类目
	private String scpslm;

	// 上传代表作品
	private String works;

	// 报价最小值
	private String quoteMin;

	// 报价最大值
	private String quoteMax;

	// 资质编号
	private String qualityCode;

	// 详细描述
	private String description;

	// UI位置
	private String location;

	// UI顺序
	private String orderNo;

	// 状态
	private String status;

	// 发布人
	private String publisher;

	// 发布时间
	private String publishDatetime;

	// 处理人
	private String dealer;

	// 处理时间
	private String dealDatetime;

	// 处理意见
	private String dealNote;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setPyNum(String pyNum) {
		this.pyNum = pyNum;
	}

	public String getPyNum() {
		return pyNum;
	}

	public void setSysNum(String sysNum) {
		this.sysNum = sysNum;
	}

	public String getSysNum() {
		return sysNum;
	}

	public void setIsDz(String isDz) {
		this.isDz = isDz;
	}

	public String getIsDz() {
		return isDz;
	}

	public void setScpslm(String scpslm) {
		this.scpslm = scpslm;
	}

	public String getScpslm() {
		return scpslm;
	}

	public void setWorks(String works) {
		this.works = works;
	}

	public String getWorks() {
		return works;
	}

	public void setQuoteMin(String quoteMin) {
		this.quoteMin = quoteMin;
	}

	public String getQuoteMin() {
		return quoteMin;
	}

	public void setQuoteMax(String quoteMax) {
		this.quoteMax = quoteMax;
	}

	public String getQuoteMax() {
		return quoteMax;
	}

	public void setQualityCode(String qualityCode) {
		this.qualityCode = qualityCode;
	}

	public String getQualityCode() {
		return qualityCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
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

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublishDatetime(String publishDatetime) {
		this.publishDatetime = publishDatetime;
	}

	public String getPublishDatetime() {
		return publishDatetime;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealDatetime(String dealDatetime) {
		this.dealDatetime = dealDatetime;
	}

	public String getDealDatetime() {
		return dealDatetime;
	}

	public void setDealNote(String dealNote) {
		this.dealNote = dealNote;
	}

	public String getDealNote() {
		return dealNote;
	}

}