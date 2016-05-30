package com.xnjr.mall.dto.res;

public class XN805901Res {
    // 用户ID
    private String userId;

    // 最好不是手机号，就是一般的登录名。目前第一版版本先用手机号，因为用一般登录名，注册流程以及手机验证就要变
    private String loginName;

    // 头像
    private String photo;

    // 状态
    private String status;

    // 拥有的服务list
    private String serveList;

    // 拥有的报价list
    private String quoteList;

    // 用户等级
    private String level;

    // 是否手机绑定
    private String mobileFlag;

    // 是否实名认证
    private String identityFlag;

    // 是否设置交易密码
    private String tradepwdFlag;

    // 是否绑定银行卡
    private String bankcardFlag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServeList() {
        return serveList;
    }

    public void setServeList(String serveList) {
        this.serveList = serveList;
    }

    public String getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(String quoteList) {
        this.quoteList = quoteList;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMobileFlag() {
        return mobileFlag;
    }

    public void setMobileFlag(String mobileFlag) {
        this.mobileFlag = mobileFlag;
    }

    public String getIdentityFlag() {
        return identityFlag;
    }

    public void setIdentityFlag(String identityFlag) {
        this.identityFlag = identityFlag;
    }

    public String getTradepwdFlag() {
        return tradepwdFlag;
    }

    public void setTradepwdFlag(String tradepwdFlag) {
        this.tradepwdFlag = tradepwdFlag;
    }

    public String getBankcardFlag() {
        return bankcardFlag;
    }

    public void setBankcardFlag(String bankcardFlag) {
        this.bankcardFlag = bankcardFlag;
    }

}
