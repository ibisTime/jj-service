package com.xnjr.mall.dto.req;

public class XNfd2040Req {

    // 公司名称(必填)
    private String name;

    // 公司营业执照编号(必填)
    private String gsyyzzNo;

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
}
