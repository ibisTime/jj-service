package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.BKBank;

/** 
 * @author: miyb 
 * @since: 2015-6-16 上午10:42:25 
 * @history:
 */
public interface IBKBankDAO extends IBaseDAO<BKBank> {
    String NAMESPACE = IBKBankDAO.class.getName().concat(".");

    /**
     * 修改
     * @param data
     * @return 
     * @create: 2016年4月21日 上午11:41:31 myb858
     * @history:
     */
    public int update(BKBank data);
}
