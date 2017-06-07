package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ICbIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612173Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 处理CB意向/申请职位处理，状态更改为已完成(简单查看)
 * @author: asus 
 * @since: 2017年6月7日 下午6:12:23 
 * @history:
 */
public class XN612173 extends AProcessor {
    private ICbIntentionAO cbIntentionAO = SpringContextHolder
        .getBean(ICbIntentionAO.class);

    private XN612173Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        cbIntentionAO.editCbIntention(req.getCode(), req.getDealResult(),
            req.getUpdater(), req.getRemark());
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612173Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater(),
            req.getDealResult());
    }
}
