package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.common.DBPropertiesUtil;
import com.xnjr.mall.dao.IInvoiceDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Invoice;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:09:18 
 * @history:
 */
@Repository("invoiceDAOImpl")
public class InvoiceDAOImpl extends AMybatisTemplate implements IInvoiceDAO {

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Invoice data) {
        return super.insert(NAMESPACE.concat("insert_invoice"), data);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Invoice data) {
        return super.delete(NAMESPACE.concat("delete_invoice"), data);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Invoice select(Invoice condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.select(NAMESPACE.concat("select_invoice"), condition,
            Invoice.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Invoice condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(NAMESPACE.concat("select_invoice_count"),
            condition);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Invoice> selectList(Invoice condition) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_invoice"), condition,
            Invoice.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Invoice> selectList(Invoice condition, int start, int count) {
        condition.setUserDB(DBPropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_invoice"), start,
            count, condition, Invoice.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IInvoiceDAO#updateInvoiceStatus(com.xnjr.mall.domain.Invoice)
     */
    @Override
    public int updateInvoiceStatus(Invoice data) {
        return super.update("update_invoiceStatus", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IInvoiceDAO#updateInvoiceApply(com.xnjr.mall.domain.Invoice)
     */
    @Override
    public int updateInvoiceCancel(Invoice data) {
        return super.update("update_invoiceCancel", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IInvoiceDAO#updateInvoiceApprove(com.xnjr.mall.domain.Invoice)
     */
    @Override
    public int updateInvoiceApprove(Invoice data) {
        return super.update("update_invoiceApprove", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IInvoiceDAO#updateInvoicePayAmount(com.xnjr.mall.domain.Invoice)
     */
    @Override
    public int updateInvoicePayAmount(Invoice data) {
        return super.update("update_invoicePayAmount", data);
    }

    @Override
    public int doFirstPay(Invoice data) {
        return super.update("update_doFirstPay", data);
    }
}
