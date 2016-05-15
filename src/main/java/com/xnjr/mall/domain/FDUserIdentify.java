package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 用户实名认证流水
 * @author: luoqi 
 * @since: 2015年3月7日 下午6:04:48 
 * @history:
 */
public class FDUserIdentify extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5851295115059106230L;

    private Date createDatetimeStart;

    private Date createDatetimeEnd;

    // ***************** db propertity ******************
    private String userId;

    // 证件类型
    private String idKind;

    // 证件号码
    private String idNo;

    // 真实姓名
    private String realName;

    // 错误代码
    private String errorCode;

    // 错误信息
    private String errorInfo;

    // 验证时间
    private Date createDatetime;

    public Date getCreateDatetimeStart() {
        return createDatetimeStart;
    }

    public void setCreateDatetimeStart(Date createDatetimeStart) {
        this.createDatetimeStart = createDatetimeStart;
    }

    public Date getCreateDatetimeEnd() {
        return createDatetimeEnd;
    }

    public void setCreateDatetimeEnd(Date createDatetimeEnd) {
        this.createDatetimeEnd = createDatetimeEnd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Override
    public String toString() {
        return "UserIdentifyDO [createDatetimeStart=" + createDatetimeStart
                + ", createDatetimeEnd=" + createDatetimeEnd + ", userId="
                + userId + ", realName=" + realName + ", idKind=" + idKind
                + ", idNo=" + idNo + ", errorCode=" + errorCode
                + ", errorInfo=" + errorInfo + ", createDatetime="
                + createDatetime + "]";
    }

}
