package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 关注
* @author: shan
* @since: 2017年06月04日
* @history:
*/
public class Focus extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 关注公司
    private String companyCode;

    // 用户编号
    private String userId;

    // 组号
    private String groupCode;

    // ****************DB**********************
    // 公司名称
    private String companyName;

    // 公司
    private Company company;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
