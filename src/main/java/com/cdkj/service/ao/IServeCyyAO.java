package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.dto.req.XN612128Req;
import com.cdkj.service.dto.req.XN612129Req;

public interface IServeCyyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeCyy(XN612128Req req);

    public void dropServeCyy(String code);

    public void editServeCyy(XN612129Req req);

    public Paginable<ServeCyy> queryServeCyyPage(int start, int limit,
            ServeCyy condition);

    public List<ServeCyy> queryServeCyyList(ServeCyy condition);

    public ServeCyy getServeCyy(String code);

}
