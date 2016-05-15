package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5060Req;
import com.xnjr.mall.dto.res.XNlh5060Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-对账结果录入：告诉系统哪些交易流水已对账待调帐,此时红冲蓝补的订单已经生成
 * @author: xieyj 
 * @since: 2016年4月30日 下午8:17:59 
 * @history:
 */
public class XNlh5060 extends AProcessor {
    private IFDAJourAO fdAJourAO = SpringContextHolder
        .getBean(IFDAJourAO.class);

    private XNlh5060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdAJourAO.doCheckJour(StringValidater.toLong(req.getAjNo()),
            req.getType(), req.getCheckUser(),
            StringValidater.toLong(req.getAmount()), req.getRemark());
        return new XNlh5060Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5060Req.class);
        StringValidater.validateBlank(req.getAjNo(), req.getType(),
            req.getCheckUser(), req.getRemark());
        StringValidater.validateAmount(req.getAmount());
    }
}
