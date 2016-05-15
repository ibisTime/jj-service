package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2040Req;
import com.xnjr.mall.dto.res.XNfd2040Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-检查企业是否存在，有返回公司编号
 * @author: xieyj 
 * @since: 2016年4月22日 上午3:30:46 
 * @history:
 */
public class XNfd2040 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String companyCode = fdCompanyAO.getCompanyCodeByCondition(
            req.getName(), req.getGsyyzzNo());
        return new XNfd2040Res(companyCode);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2040Req.class);
        StringValidater.validateBlank(req.getName(), req.getGsyyzzNo());
    }
}
