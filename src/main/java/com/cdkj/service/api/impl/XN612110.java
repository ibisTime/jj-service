package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeShopAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeShop;
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

    private IServeShopAO serveShopAO = SpringContextHolder
        .getBean(IServeShopAO.class);

    private XN612110Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeShop data = ServeConverter.converter(req);
        String code = serveShopAO.addServeShop(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612110Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getTgfw(), req.getFeeMode(), req.getPayCycle(),
            req.getScyylm(), req.getSucCase(), req.getPublisher());
    }
}
