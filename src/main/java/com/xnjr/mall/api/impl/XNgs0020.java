package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统账户查询
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午4:47:52 
 * @history:
 */
public class XNgs0020 extends AProcessor {
    private IGSAccountAO gsAccountAO = SpringContextHolder
        .getBean(IGSAccountAO.class);

    @Override
    public Object doBusiness() throws BizException {

        return gsAccountAO.getGSAccount();

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        // TODO Auto-generated method stub

    }

}
