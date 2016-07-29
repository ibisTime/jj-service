package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISaleGuideAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.api.converter.SaleGuideConverter;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SaleGuide;
import com.xnjr.mall.dto.req.XNlh5102Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 修改分销引导记录
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:22:07 
 * @history:
 */
public class XNlh5102 extends AProcessor {

    private ISaleGuideAO saleGuideAO = SpringContextHolder
        .getBean(ISaleGuideAO.class);

    private XNlh5102Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SaleGuide condition = SaleGuideConverter.converter(req);
        int count = saleGuideAO.doRefreshSaleGuide(condition);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5102Req.class);
        StringValidater.validateNumber(req.getPrice(), req.getQuantity());
    }
}
