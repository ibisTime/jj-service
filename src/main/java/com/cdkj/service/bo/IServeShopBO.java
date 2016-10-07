package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.ServeShop;

public interface IServeShopBO extends IPaginableBO<ServeShop> {

    public boolean isServeShopExist(String code);

    public String saveServeShop(ServeShop data);

    public int removeServeShop(String code);

    public int refreshServeShop(ServeShop data);

    public List<ServeShop> queryServeShopList(ServeShop condition);

    public ServeShop getServeShop(String code);

}
