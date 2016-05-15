package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0040Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

public class XNfd0040 extends AProcessor {

    private IFDAccountAO fdAccountAO = SpringContextHolder
        .getBean(IFDAccountAO.class);

    private XNfd0040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdAccountAO.getAccount(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0040Req.class);
        StringValidater.validateBlank(req.getUserId());

    }
}
