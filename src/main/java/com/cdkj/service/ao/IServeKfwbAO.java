package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeKfwb;

public interface IServeKfwbAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeKfwb(ServeKfwb data);

    public int dropServeKfwb(String code);

    public int editServeKfwb(ServeKfwb data);

    public Paginable<ServeKfwb> queryServeKfwbPage(int start, int limit,
            ServeKfwb condition);

    public List<ServeKfwb> queryServeKfwbList(ServeKfwb condition);

    public ServeKfwb getServeKfwb(String code);

}
