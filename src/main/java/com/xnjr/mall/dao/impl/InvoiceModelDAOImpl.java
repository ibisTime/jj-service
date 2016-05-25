/**
 * @Title InvoiceModelDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:33:38 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IInvoiceModelDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.InvoiceModel;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:33:38 
 * @history:
 */
@Repository("invoiceModelDAOImpl")
public class InvoiceModelDAOImpl extends AMybatisTemplate implements
        IInvoiceModelDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(InvoiceModel data) {
        return super.insert(NAMESPACE.concat("insert_invoiceModel"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(InvoiceModel data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public InvoiceModel select(InvoiceModel condition) {
        return super.select(NAMESPACE.concat("select_invoiceModel"), condition,
            InvoiceModel.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(InvoiceModel condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_invoiceModel_count"), condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<InvoiceModel> selectList(InvoiceModel condition) {
        return super.selectList(NAMESPACE.concat("select_invoiceModel"),
            condition, InvoiceModel.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<InvoiceModel> selectList(InvoiceModel condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_invoiceModel"), start,
            count, condition, InvoiceModel.class);
    }
}
