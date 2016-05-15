package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.WillInvest;

/**
 * 投资记录DAO
 * @author: xieyj 
 * @since: 2015年11月13日 上午10:31:38 
 * @history:
 */
public interface IWillInvestDAO extends IBaseDAO<WillInvest> {
    String NAMESPACE = IWillInvestDAO.class.getName().concat(".");
}
