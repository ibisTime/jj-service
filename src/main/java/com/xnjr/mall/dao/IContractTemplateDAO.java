package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.ContractTemplate;

public interface IContractTemplateDAO extends IBaseDAO<ContractTemplate> {
    String NAMESPACE = IContractTemplateDAO.class.getName().concat(".");

    public int update(ContractTemplate data);
}
