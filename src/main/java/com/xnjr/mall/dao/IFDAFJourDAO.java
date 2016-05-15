/**
 * @Title IAFJourDAO.java 
 * @Package com.ibis.account.dao 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:08:03 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDAccountFrozenJour;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:08:03 
 * @history:
 */
public interface IFDAFJourDAO extends IBaseDAO<FDAccountFrozenJour> {
    String NAMESPACE = IFDAFJourDAO.class.getName().concat(".");
}
