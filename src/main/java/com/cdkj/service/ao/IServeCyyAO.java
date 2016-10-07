package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeCyy;

public interface IServeCyyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeCyy(ServeCyy data);

    public int dropServeCyy(String code);

    public int editServeCyy(ServeCyy data);

    public Paginable<ServeCyy> queryServeCyyPage(int start, int limit,
            ServeCyy condition);

    public List<ServeCyy> queryServeCyyList(ServeCyy condition);

    public ServeCyy getServeCyy(String code);

}
