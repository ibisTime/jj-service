package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2063Req;
import com.xnjr.mall.dto.res.XNfd2063Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-隶属关系申请
 * @author: xieyj 
 * @since: 2016年4月22日 上午3:30:46 
 * @history:
 */
public class XNfd2063 extends AProcessor {
    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2063Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserCompanyAO.doKYC(StringValidater.toLong(req.getId()),
            req.getKycUser(), req.getKycResult(), req.getKycNote());
        return new XNfd2063Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2063Req.class);
        StringValidater.validateBlank(req.getKycUser(), req.getKycResult(),
            req.getKycNote());
    }
}
