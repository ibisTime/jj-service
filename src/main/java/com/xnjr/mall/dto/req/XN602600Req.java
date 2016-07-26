/**
 * @Title XN602600Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 上午11:39:26 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 积分商入驻Req
 * @author: xieyj 
 * @since: 2016年7月26日 上午11:39:26 
 * @history:
 */
public class XN602600Req {

    // 登录名（必填）
    private String loginName;

    // 手机号（必填）
    private String mobile;

    // 证件类型（必填）
    private String idKind;

    // 证件号码（必填）
    private String idNo;

    // 真实姓名（必填）
    private String realName;

    // 推荐人（必填）
    private String userReferee;

    // 附件(选填)
    private String pdf;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
}
