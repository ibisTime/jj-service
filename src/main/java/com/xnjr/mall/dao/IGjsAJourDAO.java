/**
 * @Title IGjsAccountDAO.java 
 * @Package com.ibis.account.dao 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:07:37 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.GjsAccountJour;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:07:37 
 * @history:
 */
public interface IGjsAJourDAO extends IBaseDAO<GjsAccountJour> {
    String NAMESPACE = IGjsAJourDAO.class.getName().concat(".");

    /** 
     * 对账
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateCheck(GjsAccountJour data);
}
