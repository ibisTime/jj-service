package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeKfwbAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.dto.req.CD612009Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 修改客服外包
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612009 extends AProcessor {

    private IServeKfwbAO serveKfwbAO = SpringContextHolder
        .getBean(IServeKfwbAO.class);

    private CD612009Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeKfwb data = ServeConverter.converter(req);
        int count = serveKfwbAO.editServeKfwb(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612009Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getQuoteMin(), req.getQuoteMax(), req.getKfNum(),
            req.getMtradeAmount(), req.getBusiness(), req.getFeeMode(),
            req.getPublisher());
    }
}
