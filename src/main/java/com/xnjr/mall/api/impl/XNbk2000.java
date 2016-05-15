package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKBankAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.dto.req.XNbk2000Req;
import com.xnjr.mall.dto.res.XNbk2000Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 银行-增加
 * @author: xieyj 
 * @since: 2016年4月15日 上午10:17:02 
 * @history:
 */
public class XNbk2000 extends AProcessor {
    private IBKBankAO bkBankAO = SpringContextHolder.getBean(IBKBankAO.class);

    private XNbk2000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BKBank data = new BKBank();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setStatus(req.getStatus());
        data.setType(req.getType());
        data.setUrl1(req.getUrl1());
        data.setUrl2(req.getUrl2());
        data.setRemark(req.getRemark());
        return new XNbk2000Res(bkBankAO.addBKBank(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2000Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getStatus(), req.getType(), req.getUrl1(), req.getUrl2());
    }
}
