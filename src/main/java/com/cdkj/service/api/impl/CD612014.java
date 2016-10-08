package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeCyyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.dto.req.CD612014Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 新增产业园
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612014 extends AProcessor {

    private IServeCyyAO serveCyyAO = SpringContextHolder
        .getBean(IServeCyyAO.class);

    private CD612014Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeCyy data = ServeConverter.converter(req);
        String code = serveCyyAO.addServeCyy(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612014Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getBgArea(), req.getAvailBgArea(), req.getCcArea(),
            req.getAvailCcArea(), req.getPublisher());
    }
}
