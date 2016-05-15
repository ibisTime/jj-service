package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2060Req;
import com.xnjr.mall.dto.res.XNfd2060Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 企业和用户关系申请
 * @author: xieyj 
 * @since: 2016年4月22日 上午3:30:46 
 * @history:
 */
public class XNfd2060 extends AProcessor {
    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserCompanyAO.doBindUserCompany(req.getUserId(),
            req.getCompanyCode(), req.getSqghPicture(), req.getRemark());
        return new XNfd2060Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2060Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getCompanyCode(),
            req.getSqghPicture());
    }
}
