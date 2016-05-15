package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDAFJourAO;
import com.xnjr.mall.bo.IFDAFJourBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDAccountFrozenJour;

/**
 * oss-查询冻结流水
 * @author: xieyj 
 * @since: 2016年4月23日 下午5:02:13 
 * @history:
 */
@Service
public class FDAFJourAOImpl implements IFDAFJourAO {
    @Autowired
    IFDAFJourBO fdAfJourBO;

    @Override
    public Paginable<FDAccountFrozenJour> queryAccountFrozenJourPage(int start,
            int limit, FDAccountFrozenJour condition) {
        return fdAfJourBO.getPaginable(start, limit, condition);
    }

}
