package com.xnjr.mall.bo.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IGSAJourBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IGSAJourDAO;
import com.xnjr.mall.domain.GSAccountJour;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午5:07:21 
 * @history:
 */
@Component
public class GSAJourBOImpl extends PaginableBOImpl<GSAccountJour> implements
        IGSAJourBO {
    @Autowired
    private IGSAJourDAO gsAJourDAO;

    @Override
    public GSAccountJour getAccountJour(String accountNumber) {
        GSAccountJour data = null;
        if (StringUtils.isNotBlank(accountNumber)) {
            GSAccountJour condition = new GSAccountJour();
            condition.setAccountNumber(accountNumber);
            data = gsAJourDAO.select(condition);
        }
        return data;
    }

}
