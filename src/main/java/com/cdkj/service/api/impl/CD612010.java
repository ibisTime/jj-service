package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeCpAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.dto.req.CD612010Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 新增仓配服务
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612010 extends AProcessor {

    private IServeCpAO serveCpAO = SpringContextHolder
        .getBean(IServeCpAO.class);

    private CD612010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeCp data = ServeConverter.converter(req);
        String code = serveCpAO.addServeCp(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612010Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getCkNum(), req.getCkArea(), req.getGoodsKind(),
            req.getDsendNum(), req.getPublisher());
    }
}
