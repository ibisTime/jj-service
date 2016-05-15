package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Contract;

public interface IContractDAO extends IBaseDAO<Contract> {
    String NAMESPACE = IContractDAO.class.getName().concat(".");

    public int stopContract(Contract data);
}
