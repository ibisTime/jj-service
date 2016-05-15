/**
 * @Title XNfd2035Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 上午2:32:51 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 上午2:32:51 
 * @history:
 */
public class XNfd2035Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 公司编号(选填)
    private String code;

    // 公司名称(选填)
    private String name;

    // 工商营业执照号(选填)
    private String gsyyzzNo;

    // 证件类型(选填)
    private String idKind;

    // 证件号(选填)
    private String idNo;

    // 真实姓名(选填)
    private String realName;

    // 状态(选填)
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
