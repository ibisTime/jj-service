package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDBankCard;

public interface IFDBankCardDAO extends IBaseDAO<FDBankCard> {

    String NAMESPACE = IFDBankCardDAO.class.getName().concat(".");

    public int update(FDBankCard data);
}
