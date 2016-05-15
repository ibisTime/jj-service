package com.xnjr.mall.api.impl;

import java.util.List;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.ao.IBusinessTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.BusinessTable;
import com.xnjr.mall.dto.req.XNyw4067Req;
import com.xnjr.mall.dto.res.XNyw4067Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 业务详情（核算表）查询：查询businessTable表
 * @author: myb858 
 * @since: 2016年1月13日 上午11:04:29 
 * @history:
 */
public class XNyw4067 extends AProcessor {
    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private IBusinessTableAO businessTableAO = SpringContextHolder
        .getBean(IBusinessTableAO.class);

    private XNyw4067Req req;

    @Override
    public Object doBusiness() throws BizException {
        XNyw4067Res res = new XNyw4067Res();
        List<BusinessTable> list = businessTableAO.queryBusinessTableList(req
            .getBusinessCode());
        Business business = businessAO.getBusiness(req.getBusinessCode());
        res.setBusinessTableList(list);
        res.setBusiness(business);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4067Req.class);
        StringValidater.validateBlank(req.getBusinessCode(), req.getUserId());
    }

}
