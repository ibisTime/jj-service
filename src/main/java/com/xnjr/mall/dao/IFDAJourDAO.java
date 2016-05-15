/**
 * @Title IAccountJour.java 
 * @Package com.ibis.account.dao 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:08:28 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDAccountJour;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:08:28 
 * @history:
 */
public interface IFDAJourDAO extends IBaseDAO<FDAccountJour> {
    String NAMESPACE = IFDAJourDAO.class.getName().concat(".");

    /** 
     * 对账结果录入
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int doCheckAccount(FDAccountJour data);
}
