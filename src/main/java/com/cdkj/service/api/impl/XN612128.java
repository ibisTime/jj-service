package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeCyyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612128Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增产业园
 * @author: asus 
 * @since: 2017年6月7日 上午10:20:49 
 * @history:
 */
public class XN612128 extends AProcessor {

    private IServeCyyAO serveCyyAO = SpringContextHolder
        .getBean(IServeCyyAO.class);

    private XN612128Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(serveCyyAO.addServeCyy(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612128Req.class);
        StringValidater.validateBlank(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(), req.getQuoteMin(),
            req.getQuoteMax(), req.getQualityCode(), req.getBgArea(),
            req.getAvailBgArea(), req.getCcArea(), req.getAvailCcArea(),
            req.getPublisher());
    }
}
