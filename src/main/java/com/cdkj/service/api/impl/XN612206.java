package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IBcIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612206Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询BC意向
 * @author: asus 
 * @since: 2017年6月5日 下午5:44:12 
 * @history:
 */
public class XN612206 extends AProcessor {
    private IBcIntentionAO bcIntentionAO = SpringContextHolder
        .getBean(IBcIntentionAO.class);

    private XN612206Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bcIntentionAO.getBcIntention(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612206Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}
