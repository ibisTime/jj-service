package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IBcIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612200Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 
 * @author: asus 
 * @since: 2017年6月5日 下午5:44:12 
 * @history:
 */
public class XN612200 extends AProcessor {
    private IBcIntentionAO bcIntentionAO = SpringContextHolder
        .getBean(IBcIntentionAO.class);

    private XN612200Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(bcIntentionAO.addBcIntention(req.getType(),
            req.getCompanyCode(), req.getDemandCode(), req.getResumeCode(),
            req.getSubmitter()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612200Req.class);
        StringValidater.validateBlank(req.getType(), req.getCompanyCode(),
            req.getSubmitter());
    }

}
