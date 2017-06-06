package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612053Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 公司热门设置
 * @author: asus 
 * @since: 2017年6月6日 下午2:22:43 
 * @history:
 */
public class XN612053 extends AProcessor {
    private ICompanyAO companyAO = SpringContextHolder
        .getBean(ICompanyAO.class);

    private XN612053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        companyAO
            .hotLocation(req.getCode(), req.getOrderNo(), req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612053Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
        StringValidater.validateNumber(req.getOrderNo());
    }

}
