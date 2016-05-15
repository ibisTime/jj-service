package com.xnjr.mall.dto.req;

public class XNyw4080Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 3365130199235041435L;

    // 编号
    private String code;

    // 公司编号
    private String companyCode;

    // 项目编号
    private String subjectCode;

    // 类型
    private String type;

    // 0=坏账（不正常）； 1=流标（正常）；2=正常还款（正常）；3=逾期还款（正常）；9=无状态（正常）；
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
