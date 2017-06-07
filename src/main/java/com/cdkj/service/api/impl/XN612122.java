package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeKfwbAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.dto.req.XN612122Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增客服外包
 * @author: asus 
 * @since: 2017年6月7日 上午10:17:21 
 * @history:
 */
public class XN612122 extends AProcessor {

    private IServeKfwbAO serveKfwbAO = SpringContextHolder
        .getBean(IServeKfwbAO.class);

    private XN612122Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeKfwb data = ServeConverter.converter(req);
        String code = serveKfwbAO.addServeKfwb(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612122Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getKfNum(), req.getMtradeAmount(), req.getBusiness(),
            req.getFeeMode(), req.getPublisher());
    }
}
