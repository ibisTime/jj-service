package com.cdkj.service.dto.req;

/**
 * 关注
 * @author: asus 
 * @since: 2017年6月4日 下午5:12:03 
 * @history:
 */
public class XN612030Req {
    // 公司编号
    private String companyCode;

    // 用户编号
    private String userId;

    // 分组编号
    private String groupCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
