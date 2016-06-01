package com.xnjr.mall.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IAccountBO;

@Component
public class AccountBOImpl implements IAccountBO {
    static Logger logger = Logger.getLogger(AccountBOImpl.class);

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#transferOrder(java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String)
     */
    @Override
    public void transferOrder(String accountNumber, String direction,
            Long amount, Long fee, String remark, String tradePwd) {
        // TODO Auto-generated method stub
    }
}
