package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvoiceAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602023Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 取消订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN602023 extends AProcessor {

    private IInvoiceAO invoiceAO = SpringContextHolder
        .getBean(IInvoiceAO.class);

    private XN602023Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        int count = invoiceAO.cancelInvoice(req.getCode());
        return new BooleanRes(count > 0 ? true : false);

    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602023Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
