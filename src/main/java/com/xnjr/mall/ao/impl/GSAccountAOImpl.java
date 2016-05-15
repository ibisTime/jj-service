package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IGSAccountAO;
import com.xnjr.mall.bo.IGSAccountBO;
import com.xnjr.mall.domain.GSAccount;

/**
 * 
 * @author: duanjiewen
 * @since: 2016年4月19日 下午4:45:31 
 * @history:
 */
@Service
public class GSAccountAOImpl implements IGSAccountAO {

    @Autowired
    IGSAccountBO gsAccountBO;

    @Override
    public GSAccount getGSAccount() {
        return gsAccountBO.getGSAccount();
    }

}
