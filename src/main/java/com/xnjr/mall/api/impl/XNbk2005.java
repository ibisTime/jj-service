package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKBankAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNbk2005Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 根据编号获取银行详情
 * @author: xieyj 
 * @since: 2016年4月15日 上午10:35:14 
 * @history:
 */
public class XNbk2005 extends AProcessor {
    private IBKBankAO bkBankAO = SpringContextHolder.getBean(IBKBankAO.class);

    private XNbk2005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bkBankAO.getBKBank(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2005Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
