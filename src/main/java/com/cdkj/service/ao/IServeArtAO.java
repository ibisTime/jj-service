package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.dto.req.XN612120Req;
import com.cdkj.service.dto.req.XN612121Req;

public interface IServeArtAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeArt(XN612120Req req);

    public int dropServeArt(String code);

    public int editServeArt(XN612121Req req);

    public Paginable<ServeArt> queryServeArtPage(int start, int limit,
            ServeArt condition);

    public List<ServeArt> queryServeArtList(ServeArt condition);

    public ServeArt getServeArt(String code);

}
