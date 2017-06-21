package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IOperateAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612112Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改店铺代运营
 * @author: asus 
 * @since: 2017年6月7日 上午10:15:42 
 * @history:
 */
public class XN612112 extends AProcessor {

    private IOperateAO operateAO = SpringContextHolder
        .getBean(IOperateAO.class);

    private XN612112Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        operateAO.editOperate(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612112Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getQuoteMin(), req.getQuoteMax(), req.getTgfw(),
            req.getFeeMode(), req.getPayCycle(), req.getScyylm(),
            req.getSucCase(), req.getPublisher());
        StringValidater.validateEmoji(req.getDescription());
    }
}
