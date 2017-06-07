package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.dto.req.XN612124Req;
import com.cdkj.service.dto.req.XN612125Req;

public interface IServeCpAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeCp(XN612124Req req);

    public void dropServeCp(String code);

    public void editServeCp(XN612125Req req);

    public Paginable<ServeCp> queryServeCpPage(int start, int limit,
            ServeCp condition);

    public List<ServeCp> queryServeCpList(ServeCp condition);

    public ServeCp getServeCp(String code);

}
