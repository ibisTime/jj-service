package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.dto.req.XN612126Req;
import com.cdkj.service.dto.req.XN612127Req;

public interface IServeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServe(XN612126Req req);

    public void dropServe(String code);

    public void editServe(XN612127Req req);

    public void editServeStatus(String code, String dealer, String dealNote);

    public void editServeHot(String code, String isHot, String orderNo,
            String dealer);

    public void editServeHotLocation(String code, String action);

    public Paginable<Serve> queryServePage(int start, int limit, Serve condition);

    public List<Serve> queryServeList(Serve condition);

    public Serve getServe(String code);

}
