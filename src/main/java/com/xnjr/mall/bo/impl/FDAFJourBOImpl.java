/**
 * @Title AFJourBOImpl.java 
 * @Package com.ibis.account.bo.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:21:54 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDAFJourBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IFDAFJourDAO;
import com.xnjr.mall.domain.FDAccountFrozenJour;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:21:54 
 * @history:
 */
@Component
public class FDAFJourBOImpl extends PaginableBOImpl<FDAccountFrozenJour>
        implements IFDAFJourBO {
    @Autowired
    private IFDAFJourDAO afJourDAO;

    /** 
     * @see com.ibis.account.bo.IAFJourBO#getAFJour(java.lang.Long)
     */
    @Override
    public FDAccountFrozenJour getAFJour(Long afjNo) {
        FDAccountFrozenJour data = null;
        if (afjNo > 0) {
            FDAccountFrozenJour condition = new FDAccountFrozenJour();
            condition.setAfjNo(afjNo);
            data = afJourDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IAFJourBO#queryAFJourList(com.ibis.account.domain.FDAccountFrozenJour)
     */
    @Override
    public List<FDAccountFrozenJour> queryAFJourList(
            FDAccountFrozenJour condition) {
        return afJourDAO.selectList(condition);
    }
}
