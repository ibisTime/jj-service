package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKBankAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNbk2001Req;
import com.xnjr.mall.dto.res.XNbk2001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 银行-删除
 * @author: myb858 
 * @since: 2015年9月18日 下午2:25:29 
 * @history:
 */
public class XNbk2001 extends AProcessor {
    private IBKBankAO bkBankAO = SpringContextHolder.getBean(IBKBankAO.class);

    private XNbk2001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNbk2001Res(bkBankAO.dropBKBank(req.getCode()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2001Req.class);
        StringValidater.validateBlank(req.getCode());

    }
}
