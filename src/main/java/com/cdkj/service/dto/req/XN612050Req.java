package com.cdkj.service.dto.req;

/**
 * 企业入驻
 * @author: asus 
 * @since: 2017年6月6日 上午9:53:57 
 * @history:
 */
public class XN612050Req {
    // 类型（必填）
    private String type;

    // 名称（必填）
    private String name;

    // 工商营业执照（选填）
    private String gsyyzzh;

    // 公司法人（选填）
    private String corporation;

    // 身份证号（选填）
    private String idNo;

    // 手机号（必填）
    private String mobile;

    // 短信验证码（必填）
    private String smsCaptcha;

    // 密码（必填）
    private String password;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGsyyzzh() {
        return gsyyzzh;
    }

    public void setGsyyzzh(String gsyyzzh) {
        this.gsyyzzh = gsyyzzh;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCaptcha() {
        return smsCaptcha;
    }

    public void setSmsCaptcha(String smsCaptcha) {
        this.smsCaptcha = smsCaptcha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
