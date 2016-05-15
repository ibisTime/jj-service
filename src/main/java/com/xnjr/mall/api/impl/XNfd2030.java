package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2030Req;
import com.xnjr.mall.dto.res.XNfd2030Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-填写公司基本信息
 * @author: xieyj 
 * @since: 2016年4月21日 下午7:52:37 
 * @history:
 */
public class XNfd2030 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = fdCompanyAO.addCompany(req.getName(), req.getGsyyzzNo(),
            req.getIdKind(), req.getIdNo(), req.getRealName(),
            req.getCurrency(), StringValidater.toLong(req.getCapital()),
            req.getProvince(), req.getCity(), req.getAddress(),
            req.getApplyUser());
        return new XNfd2030Res(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2030Req.class);
        StringValidater.validateBlank(req.getName(), req.getGsyyzzNo(),
            req.getIdKind(), req.getIdNo(), req.getRealName(),
            req.getCurrency(), req.getCapital(), req.getProvince(),
            req.getCity(), req.getApplyUser());
        StringValidater.validateNumber(req.getCapital());
    }
}
