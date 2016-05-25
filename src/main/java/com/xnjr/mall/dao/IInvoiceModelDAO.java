package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.InvoiceModel;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:03:38 
 * @history:
 */
public interface IInvoiceModelDAO extends IBaseDAO<InvoiceModel> {
    String NAMESPACE = IInvoiceModelDAO.class.getName().concat(".");
}
