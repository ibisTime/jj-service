package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvoiceAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.dto.req.XN602024Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 发货确认（0 不发，1 发）
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN602024 extends AProcessor {

    private IInvoiceAO invoiceAO = SpringContextHolder
        .getBean(IInvoiceAO.class);

    private XN602024Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Invoice data = new Invoice();
        data.setCode(req.getCode());
        data.setApproveUser(req.getApproveUser());
        data.setApplyNote(req.getApproveUser());
        int count = invoiceAO.sendInvoice(req.getCode(), req.getApproveUser(),
            req.getApproveResult(), req.getApproveNote());
        return new BooleanRes(count > 0 ? true : false);

    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602024Req.class);
        StringValidater.validateBlank(req.getCode(), req.getApproveUser(),
            req.getApproveNote());
    }
}
