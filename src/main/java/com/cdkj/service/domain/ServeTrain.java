package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

public class ServeTrain extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String serveCode;

    private int lectorNum;

    private int mtrainTimes;

    private int mtrainNum;

    private String resume1;

    private String resume2;

    private String resume3;

    private String course;

    public String getServeCode() {
        return serveCode;
    }

    public void setServeCode(String serveCode) {
        this.serveCode = serveCode;
    }

    public int getLectorNum() {
        return lectorNum;
    }

    public void setLectorNum(int lectorNum) {
        this.lectorNum = lectorNum;
    }

    public int getMtrainTimes() {
        return mtrainTimes;
    }

    public void setMtrainTimes(int mtrainTimes) {
        this.mtrainTimes = mtrainTimes;
    }

    public int getMtrainNum() {
        return mtrainNum;
    }

    public void setMtrainNum(int mtrainNum) {
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
