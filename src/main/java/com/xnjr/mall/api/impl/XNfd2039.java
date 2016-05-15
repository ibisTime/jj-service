package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2039Req;
import com.xnjr.mall.dto.res.XNfd2039Res;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 企业KYC审核
 * @author: xieyj 
 * @since: 2016年4月22日 上午3:30:46 
 * @history:
 */
public class XNfd2039 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2039Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdCompanyAO.doKYC(req.getCode(), req.getKycUser(), req.getKycResult(),
            req.getKycNote(), req.getServeList(), req.getQuoteList(),
            StringValidater.toInteger(req.getLevel()));
        return new XNfd2039Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2039Req.class);
        StringValidater.validateBlank(req.getCode(), req.getKycUser(),
            req.getKycResult(), req.getKycNote());
        if (EBoolean.YES.getCode().equalsIgnoreCase(req.getKycResult())) {
            StringValidater.validateBlank(req.getServeList(),
                req.getQuoteList(), req.getLevel());
        }
    }
}
