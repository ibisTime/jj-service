package com.xnjr.mall.dto.req;

import java.util.List;

import com.xnjr.mall.domain.BusinessTable;

public class XNyw4061Req {
    private String code;

    // 业务名称
    private String name;

    // 本金
    private String principal;

    // 收益
    private String profit;

    // 核算表附件
    private String hsbUrl;

    // 核算凭证附件
    private String hspzUrl;

    // 附件
    private String fjUrl;

    // 开始时间（与结束时间一同提交），它与收款确认时间进行比较！
    private String startDatetime;

    // 结束时间
    private String endDatetime;

    // 发起人
    private String applyUser;

    // 备注
    private String remark;

    private List<BusinessTable> list;

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

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getHsbUrl() {
        return hsbUrl;
    }

    public void setHsbUrl(String hsbUrl) {
        this.hsbUrl = hsbUrl;
    }

    public String getHspzUrl() {
        return hspzUrl;
    }

    public void setHspzUrl(String hspzUrl) {
        this.hspzUrl = hspzUrl;
    }

    public String getFjUrl() {
        return fjUrl;
    }

    public void setFjUrl(String fjUrl) {
        this.fjUrl = fjUrl;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<BusinessTable> getList() {
        return list;
    }

    public void setList(List<BusinessTable> list) {
        this.list = list;
    }

}
