package com.xnjr.mall.dto.res;

import java.util.List;

import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.BusinessTable;

public class XNyw4065Res {
    private Business business;

    private List<BusinessTable> businessTableList;

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<BusinessTable> getBusinessTableList() {
        return businessTableList;
    }

    public void setBusinessTableList(List<BusinessTable> businessTableList) {
        this.businessTableList = businessTableList;
    }

}
