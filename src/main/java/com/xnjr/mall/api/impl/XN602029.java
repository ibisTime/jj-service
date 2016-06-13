package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvoiceAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.dto.req.XN602029Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 首款/尾款确认
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN602029 extends AProcessor {

    private IInvoiceAO invoiceAO = SpringContextHolder
        .getBean(IInvoiceAO.class);

    private XN602029Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Invoice data = new Invoice();
        data.setCode(req.getCode());
        data.setAmount(Long.valueOf(req.getAmount()));
        data.setFromType(req.getFromType());
        data.setFromCode(req.getFromCode());
        data.setPdf(req.getPdf());
        data.setToCardNo(req.getToCardNo());
        data.setRemark(req.getRemark());
        int count = invoiceAO.payInvoice(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602029Req.class);
        StringValidater
            .validateBlank(req.getCode(), req.getFromType(), req.getFromCode(),
                req.getToCardNo(), req.getPdf(), req.getRemark());
        StringValidater.validateAmount(req.getAmount());
    }
}
