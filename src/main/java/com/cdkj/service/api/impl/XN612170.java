package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ICbIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612170Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * CB意向申请/职位申请
 * @author: asus 
 * @since: 2017年6月7日 下午5:36:04 
 * @history:
 */
public class XN612170 extends AProcessor {
    private ICbIntentionAO cbIntentionAO = SpringContextHolder
        .getBean(ICbIntentionAO.class);

    private XN612170Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(cbIntentionAO.addCbIntention(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612170Req.class);
        StringValidater.validateBlank(req.getType(), req.getSubmitter());
        StringValidater.validateEmoji(req.getHzContent());
    }
}
