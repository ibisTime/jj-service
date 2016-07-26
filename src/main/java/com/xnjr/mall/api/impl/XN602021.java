package com.xnjr.mall.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.xnjr.mall.ao.IInvoiceAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.dto.req.XN602021Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 3.2、 多种型号购买
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN602021 extends AProcessor {

    private IInvoiceAO invoiceAO = SpringContextHolder
        .getBean(IInvoiceAO.class);

    private XN602021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Invoice data = new Invoice();
        data.setAddressCode(req.getAddressCode());
        data.setApplyUser(req.getApplyUser());
        data.setApplyNote(req.getApplyNote());
        data.setReceiptType(req.getReceiptType());
        data.setReceiptTitle(req.getReceiptTitle());

        data.setToUser(req.getToUser());
        return invoiceAO.commitInvoice(req.getCartCodeList(), data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602021Req.class);
        StringValidater.validateBlank(req.getAddressCode(), req.getApplyUser(),
            req.getToUser());
        if (CollectionUtils.isEmpty(req.getCartCodeList())) {
            throw new BizException("xn702000", "购物车中货物不能为空");
        }

    }
}
