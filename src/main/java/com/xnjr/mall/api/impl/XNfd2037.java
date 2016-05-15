package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2037Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-查询企业详情(管)
 * @author: xieyj 
 * @since: 2016年4月21日 下午10:08:51 
 * @history:
 */
public class XNfd2037 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2037Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdCompanyAO.doGetCompany(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2037Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
