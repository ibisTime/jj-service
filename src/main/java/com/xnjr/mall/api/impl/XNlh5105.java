package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISaleGuideAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.dto.req.XNlh5105Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 详情查询分销引导表
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:25:24 
 * @history:
 */
public class XNlh5105 extends AProcessor {

    private ISaleGuideAO saleGuideAO = SpringContextHolder
        .getBean(ISaleGuideAO.class);

    private XNlh5105Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return saleGuideAO.getSaleGuide(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5105Req.class);
    }
}
