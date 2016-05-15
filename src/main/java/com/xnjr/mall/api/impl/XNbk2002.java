package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKBankAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.dto.req.XNbk2002Req;
import com.xnjr.mall.dto.res.XNbk2002Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 银行-修改
 * @author: myb858 
 * @since: 2015年9月18日 下午2:25:39 
 * @history:
 */
public class XNbk2002 extends AProcessor {
    private IBKBankAO bankAO = SpringContextHolder.getBean(IBKBankAO.class);

    private XNbk2002Req req = null;

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
        return new XNbk2002Res(bankAO.editBKBank(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getStatus(), req.getType(), req.getUrl1(), req.getUrl2());
    }
}
