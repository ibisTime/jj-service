package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDBankCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2012Req;
import com.xnjr.mall.dto.res.XNfd2012Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 编辑个人银行卡
 * @author: xieyj 
 * @since: 2016年4月23日 上午9:51:18 
 * @history:
 */
public class XNfd2012 extends AProcessor {
    private IFDBankCardAO fdBankcardAO = SpringContextHolder
        .getBean(IFDBankCardAO.class);

    private XNfd2012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdBankcardAO.editBankCard(StringValidater.toLong(req.getId()),
            req.getUserId(), req.getBankCode(), req.getSubbranch(),
            req.getBankCardNo());
        return new XNfd2012Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2012Req.class);
        StringValidater.validateBlank(req.getId(), req.getUserId(),
            req.getBankCode(), req.getSubbranch(), req.getBankCardNo());
    }

}
