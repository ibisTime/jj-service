package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IGSAJourAO;
import com.xnjr.mall.bo.IGSAJourBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.GSAccountJour;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午5:02:13 
 * @history:
 */
@Service
public class GSAJourAOImpl implements IGSAJourAO {
    @Autowired
    IGSAJourBO gsAJourBO;

    @Override
    public Paginable<GSAccountJour> queryGSAccountJourPage(int start,
            int limit, GSAccountJour condition) {
        return gsAJourBO.getPaginable(start, limit, condition);
    }

    @Override
    public GSAccountJour getAccountJour(String accountNumber) {
        return gsAJourBO.getAccountJour(accountNumber);
    }

}
