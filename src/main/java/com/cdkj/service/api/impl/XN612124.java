package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeCpAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.dto.req.XN612124Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增仓配服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:18:07 
 * @history:
 */
public class XN612124 extends AProcessor {

    private IServeCpAO serveCpAO = SpringContextHolder
        .getBean(IServeCpAO.class);

    private XN612124Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeCp data = ServeConverter.converter(req);
        String code = serveCpAO.addServeCp(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612124Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getCkNum(), req.getCkArea(), req.getGoodsKind(),
            req.getDsendNum(), req.getPublisher());
    }
}
