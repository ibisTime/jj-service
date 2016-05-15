package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2068Req;
import com.xnjr.mall.dto.res.XNfd2068Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 管理端-变更隶属人
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:38 
 * @history:
 */
public class XNfd2068 extends AProcessor {

    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2068Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserCompanyAO.doChangeUserCompany(req.getFromUserId(),
            req.getToUserId(), req.getCompanyCode(), req.getSqghPicture(),
            req.getRemark(), req.getUpdater());
        return new XNfd2068Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2068Req.class);
        StringValidater.validateBlank(req.getFromUserId(), req.getToUserId(),
            req.getCompanyCode(), req.getSqghPicture(), req.getRemark(),
            req.getUpdater());
    }
}
