package com.cdkj.service.dto.req;

/**
 * 修改公司资质
 * @author: asus 
 * @since: 2017年6月6日 上午11:38:37 
 * @history:
 */
public class XN612072Req {
    // 编号
    private String code;

    // 资质编号
    private String qualifyCode;

    // 广告语
    private String slogan;

    // 申请人
    private String applyUser;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }
}
