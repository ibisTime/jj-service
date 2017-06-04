package com.cdkj.service.dto.req;

/**
 * 列表查询关注
 * @author: asus 
 * @since: 2017年6月4日 下午5:16:18 
 * @history:
 */
public class XN612036Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 公司编号
    private String companyCode;

    // 用户编号
    private String userId;

    // 组号
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
