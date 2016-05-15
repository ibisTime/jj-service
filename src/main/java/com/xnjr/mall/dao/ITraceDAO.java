package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Trace;

/**
 * 跟踪记录DAO
 * @author: xieyj 
 * @since: 2015年11月13日 上午10:31:38 
 * @history:
 */
public interface ITraceDAO extends IBaseDAO<Trace> {
    String NAMESPACE = ITraceDAO.class.getName().concat(".");

    /**
     * 根据用户编号和业务编号查询跟踪关系是否存在
     * @param data
     * @return 
     * @create: 2016年5月2日 上午11:13:27 xieyj
     * @history:
     */
    public Long selectTotalCountByBussinessAndUser(Trace data);
}
