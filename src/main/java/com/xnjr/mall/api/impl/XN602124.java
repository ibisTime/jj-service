package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGoodsOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602124Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

public class XN602124 extends AProcessor {

    private IGoodsOrderAO goodsOrderAO = SpringContextHolder
        .getBean(IGoodsOrderAO.class);

    private XN602124Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return goodsOrderAO.getGoodsOrder(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602124Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
