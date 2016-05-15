package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.GSAccount;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午3:55:40 
 * @history:
 */
public interface IGSAccountDAO extends IBaseDAO<GSAccount> {
    String NAMESPACE = IGSAccountDAO.class.getName().concat(".");

    /**
     * 修改账户余额
     * @param data
     * @return 
     * @create: 2016年4月19日 下午3:56:31 duanjiewen
     * @history:
     */
    public int updateAmount(GSAccount data);

    /**
     * 修改账户冻结金额（一定同时更改账户余额）
     * @param data
     * @return 
     * @create: 2016年4月19日 下午3:57:07duanjiewen
     * @history:
     */
    public int updateFrozenAmount(GSAccount data);

    /**
     * 修改账户状态
     * @param data
     * @return 
     * @create: 2016年4月19日 下午3:57:49 Gejin
     * @history:
     */
    public int updateStatus(GSAccount data);
}
