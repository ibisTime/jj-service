package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ICbIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612176Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询CB意向
 * @author: asus 
 * @since: 2017年6月7日 下午6:39:56 
 * @history:
 */
public class XN612176 extends AProcessor {
    private ICbIntentionAO cbIntentionAO = SpringContextHolder
        .getBean(ICbIntentionAO.class);

    private XN612176Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return cbIntentionAO.getCbIntention(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612176Req.class);
        StringValidater.validateNumber(req.getCode());
    }

}
