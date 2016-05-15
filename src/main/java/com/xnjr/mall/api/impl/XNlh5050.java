package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IHLOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5050Req;
import com.xnjr.mall.dto.res.XNlh5050Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 人工干预账户申请
 * @author: myb858 
 * @since: 2015年8月26日 下午3:24:07 
 * @history:
 */
public class XNlh5050 extends AProcessor {
    private IHLOrderAO hlOrderAO = SpringContextHolder
        .getBean(IHLOrderAO.class);

    private XNlh5050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long amount = StringValidater.toLong(req.getAmount());
        return new XNlh5050Res(hlOrderAO.doBalance(req.getAccountNumber(),
            amount, req.getUpdater(), req.getRemark()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5050Req.class);
        StringValidater.validateBlank(req.getAccountNumber(), req.getUpdater(),
            req.getRemark());
        StringValidater.validateAmount(req.getAmount());
    }
}
