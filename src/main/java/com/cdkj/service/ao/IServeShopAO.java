package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeShop;

public interface IServeShopAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServeShop(ServeShop data);

    public int dropServeShop(String code);

    public int editServeShop(ServeShop data);

    public Paginable<ServeShop> queryServeShopPage(int start, int limit,
            ServeShop condition);

    public List<ServeShop> queryServeShopList(ServeShop condition);

    public ServeShop getServeShop(String code);

}
