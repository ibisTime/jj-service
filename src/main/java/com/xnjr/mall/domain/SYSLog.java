/**
 * @Title SYSLog.java 
 * @Package com.xnjr.moom.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午8:21:48 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月16日 下午8:21:48 
 * @history:
 */
public class SYSLog extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -1591506247044301367L;

    // *** 查询条件 ***
    private Date operateDatetimeStart;

    private Date operateDatetimeEnd;

    // *** db propertity **

    // 编号
    private String code;

    // 针对系统
    private String toSystem;

    // 针对表
    private String toTable;

    // 针对记录
    private String toRow;

    // 针对字段
    private String toColumn;

    // 操作类型 1-增2-删3-改4-登录
    private String operateType;

    // 变更前
    private String preValue;

    // 变更后
    private String postValue;

    // 操作人
    private String operater;

    // 操作时间
    private Date operateDatetime;

    public Date getOperateDatetimeStart() {
        return operateDatetimeStart;
    }

    public void setOperateDatetimeStart(Date operateDatetimeStart) {
        this.operateDatetimeStart = operateDatetimeStart;
    }

    public Date getOperateDatetimeEnd() {
        return operateDatetimeEnd;
    }

    public void setOperateDatetimeEnd(Date operateDatetimeEnd) {
        this.operateDatetimeEnd = operateDatetimeEnd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getToSystem() {
        return toSystem;
    }

    public void setToSystem(String toSystem) {
        this.toSystem = toSystem;
    }

    public String getToTable() {
        return toTable;
    }

    public void setToTable(String toTable) {
        this.toTable = toTable;
    }

    public String getToRow() {
        return toRow;
    }

    public void setToRow(String toRow) {
        this.toRow = toRow;
    }

    public String getToColumn() {
        return toColumn;
    }

    public void setToColumn(String toColumn) {
        this.toColumn = toColumn;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    public String getPostValue() {
        return postValue;
    }

    public void setPostValue(String postValue) {
        this.postValue = postValue;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public Date getOperateDatetime() {
        return operateDatetime;
    }

    public void setOperateDatetime(Date operateDatetime) {
        this.operateDatetime = operateDatetime;
    }

}
