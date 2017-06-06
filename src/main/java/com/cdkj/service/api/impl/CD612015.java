package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeCyyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.dto.req.XN612129Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 修改产业园
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612015 extends AProcessor {

    private IServeCyyAO serveCyyAO = SpringContextHolder
        .getBean(IServeCyyAO.class);

    private XN612129Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeCyy data = ServeConverter.converter(req);
        int count = serveCyyAO.editServeCyy(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612129Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getQuoteMin(), req.getQuoteMax(), req.getBgArea(),
            req.getAvailBgArea(), req.getCcArea(), req.getAvailCcArea(),
            req.getPublisher());
    }
}
