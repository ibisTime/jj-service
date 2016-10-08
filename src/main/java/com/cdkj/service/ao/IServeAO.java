package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Serve;

public interface IServeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServe(Serve data);

    public int dropServe(String code);

    public int editServe(Serve data);

    public int editServeStatus(String code, String dealNote, String dealer);

    public int editServeHot(String code, String isHot, String orderNo,
            String dealer);

    public Paginable<Serve> queryServePage(int start, int limit, Serve condition);

    public List<Serve> queryServeList(Serve condition);

    public Serve getServe(String code);

}
