/**
 * @Title InvoiceBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月25日 上午8:15:46 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IInvoiceModelBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IInvoiceModelDAO;
import com.xnjr.mall.domain.InvoiceModel;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午8:15:46 
 * @history:
 */
@Component
public class InvoiceModelBOImpl extends PaginableBOImpl<InvoiceModel> implements
        IInvoiceModelBO {

    @Autowired
    private IInvoiceModelDAO invoiceModelDAO;

    /** 
     * @see com.xnjr.mall.bo.IInvoiceModelBO#saveInvoiceModel()
     */
    @Override
    public String saveInvoiceModel(String invoiceCode, String modelCode,
            Integer quantity, Long salePrice) {
        String code = OrderNoGenerater.generateM(EGeneratePrefix.IM.getCode());
        InvoiceModel data = new InvoiceModel();
        data.setCode(code);
        data.setInvoiceCode(invoiceCode);
        data.setModelCode(modelCode);
        data.setQuantity(quantity);
        data.setSalePrice(salePrice);
        invoiceModelDAO.insert(data);
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceModelBO#queryInvoiceModelList(com.xnjr.mall.domain.InvoiceModel)
     */
    @Override
    public List<InvoiceModel> queryInvoiceModelList(InvoiceModel condition) {
        return invoiceModelDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IInvoiceModelBO#getInvoiceModel(java.lang.String)
     */
    @Override
    public InvoiceModel getInvoiceModel(String code) {
        InvoiceModel data = null;
        if (StringUtils.isNotBlank(code)) {
            InvoiceModel condition = new InvoiceModel();
            condition.setCode(code);
            data = invoiceModelDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "发货单型号编号不存在");
            }
        }
        return data;
    }

}
