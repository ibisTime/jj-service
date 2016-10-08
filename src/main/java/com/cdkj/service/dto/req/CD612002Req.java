package com.cdkj.service.dto.req;

public class CD612002Req {

    // 服务名称 (必填)
    private String name;

    // 公司编号(必填)
    private String companyCode;

    // 最小报价(必填)
    private String quoteMin;

    // 最大报价(必填)
    private String quoteMax;

    // 资质编号(必填)
    private String qualityCode;

    // 讲师人数(必填)
    private String lectorNum;

    // 月均培训场次(必填)
    private String mtrainTimes;

    // 月均培训人数(必填)
    private String mtrainNum;

    // 核心讲师简历1(必填)
    private String resume1;

    // 核心讲师简历2(必填)
    private String resume2;

    // 核心讲师简历3(必填)
    private String resume3;

    // 培训课程(必填)
    private String course;

    // 详细描述(选填)
    private String description;

    // 发布人(必填)
    private String publisher;

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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getQuoteMin() {
        return quoteMin;
    }

    public void setQuoteMin(String quoteMin) {
        this.quoteMin = quoteMin;
    }

    public String getQuoteMax() {
        return quoteMax;
    }

    public void setQuoteMax(String quoteMax) {
        this.quoteMax = quoteMax;
    }

    public String getLectorNum() {
        return lectorNum;
    }

    public void setLectorNum(String lectorNum) {
        this.lectorNum = lectorNum;
    }

    public String getMtrainTimes() {
        return mtrainTimes;
    }

    public void setMtrainTimes(String mtrainTimes) {
        this.mtrainTimes = mtrainTimes;
    }

    public String getMtrainNum() {
        return mtrainNum;
    }

    public void setMtrainNum(String mtrainNum) {
        this.mtrainNum = mtrainNum;
    }

    public String getResume1() {
        return resume1;
    }

    public void setResume1(String resume1) {
        this.resume1 = resume1;
    }

    public String getResume2() {
        return resume2;
    }

    public void setResume2(String resume2) {
        this.resume2 = resume2;
    }

    public String getResume3() {
        return resume3;
    }

    public void setResume3(String resume3) {
        this.resume3 = resume3;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
