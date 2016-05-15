package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDAccountFrozenJour;
import com.xnjr.mall.spring.ServiceModule;

/**
 * @author: xieyj 
 * @since: 2016年4月23日 下午5:51:00 
 * @history:
 */
@ServiceModule
public interface IFDAFJourAO {
    String DEFAULT_ORDER_COLUMN = "afj_no";

    public Paginable<FDAccountFrozenJour> queryAccountFrozenJourPage(int start,
            int limit, FDAccountFrozenJour condition);
}
