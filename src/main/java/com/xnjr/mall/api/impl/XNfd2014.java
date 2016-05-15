package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDBankCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDBankCard;
import com.xnjr.mall.dto.req.XNfd2014Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 查询个人银行卡列表
 * @author: xieyj 
 * @since: 2016年4月22日 下午8:57:53 
 * @history:
 */
public class XNfd2014 extends AProcessor {
    private IFDBankCardAO fdBankCardAO = SpringContextHolder
        .getBean(IFDBankCardAO.class);

    private XNfd2014Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDBankCard condition = new FDBankCard();
        condition.setUserId(req.getUserId());
        return fdBankCardAO.queryBankCardList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2014Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}
