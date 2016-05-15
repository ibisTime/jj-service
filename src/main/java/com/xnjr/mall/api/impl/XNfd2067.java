package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.dto.req.XNfd2067Req;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 管理端-根据CompanyCode查询绑定的用户列表
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:38 
 * @history:
 */
public class XNfd2067 extends AProcessor {

    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2067Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUserCompany condition = new FDUserCompany();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setStatus(EKYCStatus.KYC_YES.getCode());
        return fdUserCompanyAO.queryUserList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2067Req.class);
        StringValidater.validateBlank(req.getCompanyCode());
    }
}
