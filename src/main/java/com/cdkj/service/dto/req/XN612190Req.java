/**
 * @Title CD612040Req.java 
 * @Package com.cdkj.service.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年10月7日 下午5:22:58 
 * @version V1.0   
 */
package com.cdkj.service.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:22:58 
 * @history:
 */
public class XN612190Req {
    // 需求名称(必填)
    private String name;

    // 资质编号(必填)
    private String qualityCode;

    // 期望公司(选题,空 所有公司，其他公司编号)
    private String expCompany;

    // 紧急程度(必填)
    private String urgentLevel;

    // 需求说明(必填)
    private String description;

    // 发布人(必填)
    private String publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public String getExpCompany() {
        return expCompany;
    }

    public void setExpCompany(String expCompany) {
        this.expCompany = expCompany;
    }

    public String getUrgentLevel() {
        return urgentLevel;
    }

    public void setUrgentLevel(String urgentLevel) {
        this.urgentLevel = urgentLevel;
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
}
