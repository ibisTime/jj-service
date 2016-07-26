/**
 * @Title InvoiceBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:15:46 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IInvoiceBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IInvoiceDAO;
import com.xnjr.mall.dao.IInvoiceModelDAO;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.domain.InvoiceModel;
import com.xnjr.mall.enums.EInvoiceStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:15:46 
 * @history:
 */
@Component
public class InvoiceBOImpl extends PaginableBOImpl<Invoice> implements
        IInvoiceBO {

    @Autowired
    private IInvoiceDAO invoiceDAO;

    @Autowired
    private IInvoiceModelDAO invoiceModelDAO;

    /** 
     * @see com.xnjr.mall.bo.IBuyGuideBO#isBuyGuideExist(java.lang.String)
     */
    @Override
    public boolean isInvoiceExist(String code) {
        Invoice condition = new Invoice();
        condition.setCode(code);
        if (invoiceDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#saveInvoice(com.xnjr.mall.domain.Invoice)
     */
    @Override
    public String saveInvoice(Invoice data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.IN.getCode());
            data.setCode(code);
            data.setStatus(EInvoiceStatus.TO_PAY.getCode());
            data.setApplyDatetime(new Date());
            data.setPayAmount(0L);
            invoiceDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#refreshInvoiceStatus(java.lang.String, java.lang.String)
     */
    @Override
    public int refreshInvoiceStatus(String code, String status) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isInvoiceExist(code)) {
                throw new BizException("xn0000", "发货单不存在");
            }
            Invoice data = new Invoice();
            data.setCode(code);
            data.setStatus(status);
            count = invoiceDAO.updateInvoiceStatus(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#cancelInvoice(java.lang.String, java.lang.String)
     */
    @Override
    public int cancelInvoice(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Invoice data = new Invoice();
            data.setCode(code);
            data.setStatus(EInvoiceStatus.FINISH.getCode());
            count = invoiceDAO.updateInvoiceCancel(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#cancelInvoice(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int cancelInvoice(String code, String approveUser,
            String approveNote, String status) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isInvoiceExist(code)) {
                throw new BizException("xn0000", "发货单不存在");
            }
            Invoice data = new Invoice();
            data.setCode(code);
            data.setStatus(status);
            data.setApproveUser(approveUser);
            data.setApproveNote(approveNote);
            data.setApproveDatetime(new Date());
            count = invoiceDAO.updateInvoiceCancelOss(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#sendInvoice(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int approveInvoice(String code, String approveUser, String status,
            String approveNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Invoice data = new Invoice();
            data.setCode(code);
            data.setApproveUser(approveUser);
            data.setStatus(status);
            data.setApproveDatetime(new Date());
            count = invoiceDAO.updateInvoiceApprove(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#queryInvoiceList(com.xnjr.mall.domain.Invoice)
     */
    @Override
    public List<Invoice> queryInvoiceList(Invoice condition) {
        return invoiceDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#getInvoice(java.lang.String)
     */
    @Override
    public Invoice getInvoice(String code) {
        Invoice data = null;
        if (StringUtils.isNotBlank(code)) {
            Invoice condition = new Invoice();
            condition.setCode(code);
            data = invoiceDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "发货单编号不存在");
            }
            InvoiceModel imCondition = new InvoiceModel();
            imCondition.setInvoiceCode(code);
            List<InvoiceModel> invoiceModelList = invoiceModelDAO
                .selectList(imCondition);
            Long totalAmount = 0L;
            for (InvoiceModel invoiceModel : invoiceModelList) {
                totalAmount += invoiceModel.getQuantity()
                        * invoiceModel.getSalePrice();
            }
            data.setTotalAmount(totalAmount);
            data.setInvoiceModelList(invoiceModelList);
        }
        return data;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceBO#refreshInvoicePayAmount(java.lang.String, java.lang.Long)
     */
    @Override
    public int refreshInvoicePayAmount(String code, Long payAmount) {
        int count = 0;
        if (isInvoiceExist(code)) {
            Invoice data = new Invoice();
            data.setCode(code);
            data.setPayAmount(payAmount);
            count = invoiceDAO.updateInvoicePayAmount(data);
        }
        return count;
    }

    @Override
    public int doFirstPay(String code, Long amount) {
        int count = 0;
        if (isInvoiceExist(code)) {
            Invoice data = new Invoice();
            data.setCode(code);
            data.setPayAmount(amount);
            data.setStatus(EInvoiceStatus.PAY_START.getCode());
            count = invoiceDAO.doFirstPay(data);
        }
        return count;
    }
}
