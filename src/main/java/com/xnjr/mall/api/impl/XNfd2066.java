package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2066Req;
import com.xnjr.mall.dto.res.XNfd2066Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 管理端-用户和企业绑定
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:38 
 * @history:
 */
public class XNfd2066 extends AProcessor {

    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2066Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserCompanyAO.doBindUserCompany(req.getUserId(),
            req.getCompanyCode(), req.getSqghPicture(), req.getRemark(),
            req.getUpdater());
        return new XNfd2066Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2066Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getCompanyCode(),
            req.getSqghPicture(), req.getUpdater());
    }
}
