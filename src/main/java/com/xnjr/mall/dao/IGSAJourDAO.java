package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.GSAccountJour;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午4:26:58 
 * @history:
 */
public interface IGSAJourDAO extends IBaseDAO<GSAccountJour> {

    String NAMESPACE = IGSAJourDAO.class.getName().concat(".");

    /**
     * 对账
     * @param data
     * @return 
     * @create: 2016年4月19日 下午4:27:45 duanjiewen
     * @history:
     */
    public int updateCheck(GSAccountJour data);
}
