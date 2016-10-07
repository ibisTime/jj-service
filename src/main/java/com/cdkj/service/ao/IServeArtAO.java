package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeArt;

public interface IServeArtAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeArt(ServeArt data);

    public int dropServeArt(String code);

    public int editServeArt(ServeArt data);

    public Paginable<ServeArt> queryServeArtPage(int start, int limit,
            ServeArt condition);

    public List<ServeArt> queryServeArtList(ServeArt condition);

    public ServeArt getServeArt(String code);

}
