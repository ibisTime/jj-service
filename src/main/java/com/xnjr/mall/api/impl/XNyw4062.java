package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4062Req;
import com.xnjr.mall.dto.res.XNyw4062Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 业务资料审核
 * @author: myb858 
 * @since: 2016年1月17日 下午4:31:50 
 * @history:
 */
public class XNyw4062 extends AProcessor {
    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XNyw4062Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        businessAO.checkBusiness(req.getBusinessCode(), req.getCheckUser(),
            req.getCheckResult(), req.getCheckNote(), req.getTradePwd());
        return new XNyw4062Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4062Req.class);
        StringValidater.validateBlank(req.getBusinessCode(),
            req.getCheckUser(), req.getCheckResult(), req.getCheckNote(),
            req.getTradePwd());
    }

}
