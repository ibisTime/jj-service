package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2065Req;
import com.xnjr.mall.dto.res.XNfd2065Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 管理端-用户和企业解绑
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:38 
 * @history:
 */
public class XNfd2065 extends AProcessor {

    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2065Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserCompanyAO.doUnBindUserCompany(req.getUserId(),
            req.getCompanyCode(), req.getUpdater());
        return new XNfd2065Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2065Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getCompanyCode(),
            req.getUpdater());
    }
}
