package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2032Req;
import com.xnjr.mall.dto.res.XNfd2032Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-企业基本信息修改
 * @author: xieyj 
 * @since: 2016年4月21日 下午9:42:35 
 * @history:
 */
public class XNfd2032 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdCompanyAO.editCompany(req.getCode(), req.getName(),
            req.getGsyyzzNo(), req.getIdKind(), req.getIdNo(),
            req.getRealName(), req.getCurrency(),
            StringValidater.toLong(req.getCapital()), req.getProvince(),
            req.getCity(), req.getAddress());
        return new XNfd2032Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2032Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getGsyyzzNo(), req.getIdKind(), req.getIdNo(),
            req.getRealName(), req.getCurrency(), req.getCapital(),
            req.getProvince(), req.getCity());
        StringValidater.validateNumber(req.getCapital());
    }
}
