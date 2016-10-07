package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.ServeShop;

public interface IServeShopDAO extends IBaseDAO<ServeShop> {
    String NAMESPACE = IServeShopDAO.class.getName().concat(".");

    public int update(ServeShop data);
}
