/**
 * @Title XN803760Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午11:01:55 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年3月6日 上午11:01:55 
 * @history:
 */
public class XNpt4008Req {

    // 编号
    private String code;

    // 开户公司编号
    private String companyCode;

    // 开户支行编号
    private String subbranchCode;

    // 开户人
    private String khPerson;

    // 开户起始时间(YYYY-MM-DD)
    private String khDatetimeStart;

    // 开户终止时间(YYYY-MM-DD)
    private String khDatetimeEnd;

    // 状态
    private String status;

    // 是否受款
    private String isAccept;

    // 排序字段
    private String orderColumn;

    // 排序方向
    private String orderDir;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSubbranchCode() {
        return subbranchCode;
    }

    public void setSubbranchCode(String subbranchCode) {
        this.subbranchCode = subbranchCode;
    }

    public String getKhPerson() {
        return khPerson;
    }

    public void setKhPerson(String khPerson) {
        this.khPerson = khPerson;
    }

    public String getKhDatetimeStart() {
        return khDatetimeStart;
    }

    public void setKhDatetimeStart(String khDatetimeStart) {
        this.khDatetimeStart = khDatetimeStart;
    }

    public String getKhDatetimeEnd() {
        return khDatetimeEnd;
    }

    public void setKhDatetimeEnd(String khDatetimeEnd) {
        this.khDatetimeEnd = khDatetimeEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(String isAccept) {
        this.isAccept = isAccept;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }
}
