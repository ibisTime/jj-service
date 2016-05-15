package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.RepayDetail;

/**
 * 还款明细DAO
 * @author: wuql
 * @since: 2016年1月21日 下午6:03:31 
 * @history:
 */
public interface IRepayDetailDAO extends IBaseDAO<RepayDetail> {
    String NAMESPACE = IRepayDetailDAO.class.getName().concat(".");

    public int repayDetail(RepayDetail repayDetail);

    public Long getTotalInvest(RepayDetail condition);

    public Long getTotalProfit(RepayDetail condition);
}
