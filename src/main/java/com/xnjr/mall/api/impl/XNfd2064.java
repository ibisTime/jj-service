package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.dto.req.XNfd2064Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * front-分页查询kyc申请书
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:38 
 * @history:
 */
public class XNfd2064 extends AProcessor {

    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2064Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUserCompany condition = new FDUserCompany();
        condition.setUserId(req.getUserId());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setStatus(req.getStatus());
        return fdUserCompanyAO.queryCompanyList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2064Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}
