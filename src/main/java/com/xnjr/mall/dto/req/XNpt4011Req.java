/**
 * @Title XN803762Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午11:01:55 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 账户管理列表查询
 * @author: xieyj 
 * @since: 2016年3月6日 上午11:01:55 
 * @history:
 */
public class XNpt4011Req {
    // 编号
    private String code;

    // 开户公司编号
    private String companyCode;

    // 开户银行
    private String bankName;

    // 开户支行编号
    private String subbranchCode;

    // 账户性质
    private String kind;

    // 币种
    private String currency;

    // 账号
    private String cardNo;

    // 是否受款
    private String isAccept;

    private String orderColumn;// 分页字段

    private String orderDir;// 分页方向

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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSubbranchCode() {
        return subbranchCode;
    }

    public void setSubbranchCode(String subbranchCode) {
        this.subbranchCode = subbranchCode;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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
