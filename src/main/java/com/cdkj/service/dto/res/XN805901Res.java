package com.cdkj.service.dto.res;

import java.util.Date;

import com.cdkj.service.domain.UserExt;

public class XN805901Res {

    // userId
    private String userId;

    // 登陆名
    private String loginName;

    // 昵称
    private String nickname;

    // 登陆密码
    private String loginPwd;

    // 登陆密码强度
    private String loginPwdStrength;

    // 身份标识
    private String kind;

    // 用户等级
    private String level;

    // 推荐人
    private String userReferee;

    // 手机号
    private String mobile;

    // 证件类型
    private String idKind;

    // 证件号码
    private String idNo;

    // 真实姓名
    private String realName;

    // 交易密码
    private String tradePwd;

    // 交易密码强度
    private String tradePwdStrength;

    // 角色编号
    private String roleCode;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 附件
    private String pdf;

    // 现有金额
    private Long amount;

    // 累计金额
    private Long ljAmount;

    // 所属公司
    private String companyCode;

    // 公司名称
    private String companyName;

    /***** 模糊查询使用字段 ******/
    private String loginNameForLikeQuery;

    private String nicknameForLikeQuery;

    private String mobileForLikeQuery;

    private String realNameForLikeQuery;

    private String userRefereeName;

    private UserExt userExt;

    // ossUserId
    private String ossUserId;

    // 关注数
    private Long totalFollowNum;

    // 粉丝数
    private Long totalFansNum;

    // 头像
    private String photo;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwdStrength() {
        return loginPwdStrength;
    }

    public void setLoginPwdStrength(String loginPwdStrength) {
        this.loginPwdStrength = loginPwdStrength;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
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

    public String getTradePwd() {
        return tradePwd;
    }

    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }

    public String getTradePwdStrength() {
        return tradePwdStrength;
    }

    public void setTradePwdStrength(String tradePwdStrength) {
        this.tradePwdStrength = tradePwdStrength;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getLjAmount() {
        return ljAmount;
    }

    public void setLjAmount(Long ljAmount) {
        this.ljAmount = ljAmount;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLoginNameForLikeQuery() {
        return loginNameForLikeQuery;
    }

    public void setLoginNameForLikeQuery(String loginNameForLikeQuery) {
        this.loginNameForLikeQuery = loginNameForLikeQuery;
    }

    public String getNicknameForLikeQuery() {
        return nicknameForLikeQuery;
    }

    public void setNicknameForLikeQuery(String nicknameForLikeQuery) {
        this.nicknameForLikeQuery = nicknameForLikeQuery;
    }

    public String getMobileForLikeQuery() {
        return mobileForLikeQuery;
    }

    public void setMobileForLikeQuery(String mobileForLikeQuery) {
        this.mobileForLikeQuery = mobileForLikeQuery;
    }

    public String getRealNameForLikeQuery() {
        return realNameForLikeQuery;
    }

    public void setRealNameForLikeQuery(String realNameForLikeQuery) {
        this.realNameForLikeQuery = realNameForLikeQuery;
    }

    public String getUserRefereeName() {
        return userRefereeName;
    }

    public void setUserRefereeName(String userRefereeName) {
        this.userRefereeName = userRefereeName;
    }

    public UserExt getUserExt() {
        return userExt;
    }

    public void setUserExt(UserExt userExt) {
        this.userExt = userExt;
    }

    public String getOssUserId() {
        return ossUserId;
    }

    public void setOssUserId(String ossUserId) {
        this.ossUserId = ossUserId;
    }

    public Long getTotalFollowNum() {
        return totalFollowNum;
    }

    public void setTotalFollowNum(Long totalFollowNum) {
        this.totalFollowNum = totalFollowNum;
    }

    public Long getTotalFansNum() {
        return totalFansNum;
    }

    public void setTotalFansNum(Long totalFansNum) {
        this.totalFansNum = totalFansNum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
