package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNgs5000Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统账户查询
 * @author: myb858 
 * @since: 2016年1月21日 下午8:03:02 
 * @history:
 */
public class XNgs5000 extends AProcessor {
    private IGSAccountAO gsAccountAO = SpringContextHolder
        .getBean(IGSAccountAO.class);

    XNgs5000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gsAccountAO.getGSAccount();
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs5000Req.class);
        StringValidater.validateBlank(req.getAccountNumber());
    }
}
