package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.dto.req.XN612122Req;
import com.cdkj.service.dto.req.XN612123Req;

public interface IServeKfwbAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeKfwb(XN612122Req req);

    public void dropServeKfwb(String code);

    public void editServeKfwb(XN612123Req req);

    public Paginable<ServeKfwb> queryServeKfwbPage(int start, int limit,
            ServeKfwb condition);

    public List<ServeKfwb> queryServeKfwbList(ServeKfwb condition);

    public ServeKfwb getServeKfwb(String code);

}
