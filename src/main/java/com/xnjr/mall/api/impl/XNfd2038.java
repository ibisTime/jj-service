package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2038Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-根据userId获取企业列表(管)
 * @author: xieyj 
 * @since: 2016年4月21日 下午9:42:35 
 * @history:
 */
public class XNfd2038 extends AProcessor {
    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2038Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdUserCompanyAO.queryCompanyListByUserId(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2038Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}
