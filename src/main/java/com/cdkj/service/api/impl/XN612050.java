package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612050Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 企业入驻
 * @author: asus 
 * @since: 2017年6月6日 下午2:22:43 
 * @history:
 */
public class XN612050 extends AProcessor {
    private ICompanyAO companyAO = SpringContextHolder
        .getBean(ICompanyAO.class);

    private XN612050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return companyAO.addCompany(req.getType(), req.getName(),
            req.getGsyyzzh(), req.getCorporation(), req.getIdNo(),
            req.getMobile(), req.getSmsCaptcha(), req.getPassword(),
            req.getPwdStrength());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612050Req.class);
        StringValidater.validateBlank(req.getType(), req.getName(),
            req.getCorporation(), req.getMobile(), req.getSmsCaptcha(),
            req.getPassword(), req.getPwdStrength());
    }
}
