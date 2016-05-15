package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDBankCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2010Req;
import com.xnjr.mall.dto.res.XNfd2010Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 新增个人银行卡
 * @author: xieyj 
 * @since: 2016年4月23日 上午9:50:50 
 * @history:
 */
public class XNfd2010 extends AProcessor {
    private IFDBankCardAO fdBankcardAO = SpringContextHolder
        .getBean(IFDBankCardAO.class);

    private XNfd2010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNfd2010Res(fdBankcardAO.addBankCard(req.getUserId(),
            req.getBankCode(), req.getSubbranch(), req.getBankCardNo()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2010Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getBankCode(),
            req.getSubbranch(), req.getBankCardNo());
    }

}
