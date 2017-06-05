package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 培训
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class Train extends ABaseDO {

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

	// 讲师总人数
	private String lectorNum;

	// 月均培训场次
	private String mtrainTimes;

	// 月均培训人数
	private String mtrainNum;

	// 第一位讲师简历
	private String resume1;

	// 第二位讲师简历
	private String resume2;

	// 第三位讲师简历
	private String resume3;

	// 培训课程
	private String course;

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

	public void setLectorNum(String lectorNum) {
		this.lectorNum = lectorNum;
	}

	public String getLectorNum() {
		return lectorNum;
	}

	public void setMtrainTimes(String mtrainTimes) {
		this.mtrainTimes = mtrainTimes;
	}

	public String getMtrainTimes() {
		return mtrainTimes;
	}

	public void setMtrainNum(String mtrainNum) {
		this.mtrainNum = mtrainNum;
	}

	public String getMtrainNum() {
		return mtrainNum;
	}

	public void setResume1(String resume1) {
		this.resume1 = resume1;
	}

	public String getResume1() {
		return resume1;
	}

	public void setResume2(String resume2) {
		this.resume2 = resume2;
	}

	public String getResume2() {
		return resume2;
	}

	public void setResume3(String resume3) {
		this.resume3 = resume3;
	}

	public String getResume3() {
		return resume3;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourse() {
		return course;
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