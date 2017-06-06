package com.cdkj.service.dto.req;

/**
 * 新增公司资质
 * @author: asus 
 * @since: 2017年6月6日 上午11:35:34 
 * @history:
 */
public class XN612070Req {
    // 公司编号
    private String companyCode;

    // 资质编号
    private String qualifyCode;

    // 广告语
    private String slogan;

    // 定价区间
    private String priceRange;

    // 申请人
    private String applyUser;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getQualifyCode() {
        return qualifyCode;
    }

    public void setQualifyCode(String qualifyCode) {
        this.qualifyCode = qualifyCode;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }
}
