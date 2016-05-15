package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4061Req;
import com.xnjr.mall.dto.res.XNyw4061Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 重提业务资料
 * @author: myb858 
 * @since: 2016年1月17日 下午4:31:33 
 * @history:
 */
public class XNyw4061 extends AProcessor {
    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XNyw4061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        businessAO.reuploadBusiness(req.getCode(), req.getName(),
            StringValidater.toLong(req.getPrincipal()),
            StringValidater.toLong(req.getProfit()), req.getHsbUrl(),
            req.getHspzUrl(), req.getFjUrl(), req.getStartDatetime(),
            req.getEndDatetime(), req.getApplyUser(), req.getRemark(),
            req.getList());
        return new XNyw4061Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4061Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getHsbUrl(), req.getHspzUrl(), req.getFjUrl(),
            req.getStartDatetime(), req.getEndDatetime(), req.getApplyUser(),
            req.getRemark());
        StringValidater.validateAmount(req.getPrincipal(), req.getProfit());

    }

}
