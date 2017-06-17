package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IOperateAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612110Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增店铺代运营
 * @author: asus 
 * @since: 2017年6月7日 上午10:15:19 
 * @history:
 */
public class XN612110 extends AProcessor {

    private IOperateAO operateAO = SpringContextHolder
        .getBean(IOperateAO.class);

    private XN612110Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(operateAO.addOperate(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612110Req.class);
        StringValidater.validateBlank(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(), req.getQuoteMin(),
            req.getQuoteMax(), req.getTgfw(), req.getFeeMode(),
            req.getPayCycle(), req.getScyylm(), req.getSucCase(),
            req.getPublisher());
    }
}
