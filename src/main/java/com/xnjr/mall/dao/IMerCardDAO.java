/**
 * @Title IMerCardDAO.java 
 * @Package com.xnjr.mall.dao 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午5:29:14 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.MerCard;

/** 
 * @author: xieyj 
 * @since: 2016年6月11日 下午5:29:14 
 * @history:
 */
public interface IMerCardDAO extends IBaseDAO<MerCard> {
    String NAMESPACE = IMerCardDAO.class.getName().concat(".");

    public int updateMerCard(MerCard data);
}
