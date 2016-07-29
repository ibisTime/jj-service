package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISaleGuideAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.api.converter.SaleGuideConverter;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.SaleGuide;
import com.xnjr.mall.dto.req.XNlh5104Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 列表查询分销引导表
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:24:30 
 * @history:
 */
public class XNlh5104 extends AProcessor {

    private ISaleGuideAO saleGuideAO = SpringContextHolder
        .getBean(ISaleGuideAO.class);

    private XNlh5104Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SaleGuide condition = SaleGuideConverter.converter(req);
        return saleGuideAO.querySaleGuideList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5104Req.class);
    }
}
