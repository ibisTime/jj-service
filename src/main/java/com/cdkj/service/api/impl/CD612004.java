package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeShopAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeShop;
import com.cdkj.service.dto.req.CD612004Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 新增店铺代运营
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612004 extends AProcessor {

    private IServeShopAO serveShopAO = SpringContextHolder
        .getBean(IServeShopAO.class);

    private CD612004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeShop data = ServeConverter.converter(req);
        String code = serveShopAO.addServeShop(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612004Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getTgfw(), req.getFeeMode(), req.getPayCycle(),
            req.getScyylm(), req.getSucCase(), req.getPublisher());
    }
}
