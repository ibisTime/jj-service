package com.xnjr.mall.dto.req;

public class XNfd2034Req {

    // 用户编号(必填)
    private String userId;

    // 公司编号(必填)
    private String companyCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
