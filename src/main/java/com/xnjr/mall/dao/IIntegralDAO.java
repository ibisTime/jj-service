package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Integral;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:03:38 
 * @history:
 */
public interface IIntegralDAO extends IBaseDAO<Integral> {
    String NAMESPACE = IIntegralDAO.class.getName().concat(".");

    /**
     * 更新
     * @param data
     * @return 
     * @create: 2016年7月20日 下午5:20:11 xieyj
     * @history:
     */
    public int updateStatus(Integral data);
}
