package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.dto.req.XNfd2034Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 前端-查询个人的企业详情
 * @author: xieyj 
 * @since: 2016年4月21日 下午10:08:51 
 * @history:
 */
public class XNfd2034 extends AProcessor {
    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2034Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUserCompany fdUserCompany = fdUserCompanyAO.getUserCompany(
            req.getUserId(), req.getCompanyCode());
        FDCompany fdCompany = fdCompanyAO.doGetCompany(req.getCompanyCode());
        fdCompany.setStatus(fdUserCompany.getStatus());
        fdCompany.setKycNote(fdUserCompany.getKycNote());
        return fdCompany;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2034Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getCompanyCode());
    }
}
