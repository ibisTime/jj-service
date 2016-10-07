package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeCp;

public interface IServeCpAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeCp(ServeCp data);

    public int dropServeCp(String code);

    public int editServeCp(ServeCp data);

    public Paginable<ServeCp> queryServeCpPage(int start, int limit,
            ServeCp condition);

    public List<ServeCp> queryServeCpList(ServeCp condition);

    public ServeCp getServeCp(String code);

}
