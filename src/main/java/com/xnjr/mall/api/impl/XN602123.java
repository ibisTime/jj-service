package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGoodsOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.GoodsOrder;
import com.xnjr.mall.dto.req.XN602123Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

public class XN602123 extends AProcessor {

    private IGoodsOrderAO goodsOrderAO = SpringContextHolder
        .getBean(IGoodsOrderAO.class);

    private XN602123Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GoodsOrder condition = new GoodsOrder();
        condition.setCode(req.getCode());
        condition.setGoodsCode(req.getGoodsCode());
        condition.setStatus(req.getStatus());
        condition.setApplyUser(req.getApplyUser());
        return goodsOrderAO.queryGoodsOrderList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602123Req.class);
    }

}
