package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IContractAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4081Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * front-合同详情
 * @author: xieyj 
 * @since: 2016年4月30日 下午1:31:12 
 * @history:
 */
public class XNyw4081 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XNyw4081Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return contractAO.getContract(req.getContractCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4081Req.class);
        StringValidater.validateBlank(req.getContractCode());
    }
}
