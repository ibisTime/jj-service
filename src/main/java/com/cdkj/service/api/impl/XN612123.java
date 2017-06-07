package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeKfwbAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612123Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改客服外包
 * @author: asus 
 * @since: 2017年6月7日 上午10:17:44 
 * @history:
 */
public class XN612123 extends AProcessor {

    private IServeKfwbAO serveKfwbAO = SpringContextHolder
        .getBean(IServeKfwbAO.class);

    private XN612123Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        serveKfwbAO.editServeKfwb(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612123Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic(), req.getAdvPic(), req.getQuoteMin(),
            req.getQuoteMax(), req.getKfNum(), req.getMtradeAmount(),
            req.getBusiness(), req.getFeeMode(), req.getPublisher());
    }
}
