package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvoiceAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.dto.req.XN602020Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 立即购买
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN602020 extends AProcessor {

    private IInvoiceAO invoiceAO = SpringContextHolder
        .getBean(IInvoiceAO.class);

    private XN602020Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Invoice data = new Invoice();
        data.setApplyUser(req.getApplyUser());
        data.setApplyNote(req.getApplyNote());
        data.setAddressCode(req.getAddressCode());
        data.setReceiptType(req.getReceiptType());
        data.setReceiptTitle(req.getReceiptTitle());
        data.setToUser(req.getToUser());
        return invoiceAO.commitInvoice(req.getModelCode(),
            Integer.valueOf(req.getQuantity()),
            Long.valueOf(req.getSalePrice()), data);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602020Req.class);
        StringValidater.validateBlank(req.getApplyUser(), req.getAddressCode(),
            req.getModelCode());
        StringValidater.validateNumber(req.getQuantity());
        StringValidater.validateAmount(req.getSalePrice());
    }
}
