package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.dto.req.XNfd2062Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-分页查询kyc申请书
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:38 
 * @history:
 */
public class XNfd2062 extends AProcessor {

    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2062Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUserCompany condition = new FDUserCompany();
        condition.setRealName(req.getRealName());
        condition.setCompanyName(req.getCompanyName());
        condition.setStatus(req.getStatus());
        condition.setKycUser(req.getKycUser());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return fdUserCompanyAO.queryUserCompanyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2062Req.class);
    }
}
