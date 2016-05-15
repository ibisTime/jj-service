package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDBankCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2015Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询个人银行卡详情
 * @author: xieyj 
 * @since: 2016年4月23日 上午10:05:50 
 * @history:
 */
public class XNfd2015 extends AProcessor {
    private IFDBankCardAO fdBankCardAO = SpringContextHolder
        .getBean(IFDBankCardAO.class);

    private XNfd2015Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdBankCardAO.getBankCard(StringValidater.toLong(req.getId()));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2015Req.class);
        StringValidater.validateBlank(req.getId());
    }
}
