package com.cdkj.service.dto.res;

public class XN001400Res {
    // 用户ID
    private String userId;

    // 最好不是手机号，就是一般的登录名。目前第一版版本先用手机号，因为用一般登录名，注册流程以及手机验证就要变
    private String loginName;

    // 头像
    private String photo;

    // 状态
    private String status;

    // 用户等级
    private String level;

    // 身份标识
    private String kind;

    // 真实姓名
    private String realName;

    // 推荐人
    private String userReferee;

    // 是否手机绑定
    private String mobileFlag;

    // 是否实名认证
    private String identityFlag;

    // 是否设置交易密码
    private String tradepwdFlag;

    // 是否绑定银行卡
    private String bankcardFlag;

    // 昵称
    private String nickname;

    // 手機號
    private String mobile;

    // 性别(1 男 0 女)
    private String gender;

    // 生日
    private String birthday;

    // 邮箱
    private String email;

    // 公司编号
    private String companyCode;

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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
