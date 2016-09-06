package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.InvoiceModel;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface IInvoiceModelBO extends IPaginableBO<InvoiceModel> {

    /**
     * 保存发货单型号
     * @param invoiceCode
     * @param modelCode
     * @param quantity
     * @param salePrice
     * @param saleCnyPrice
     * @return 
     * @create: 2016年9月5日 下午8:46:12 xieyj
     * @history:
     */
    public String saveInvoiceModel(String invoiceCode, String modelCode,
            Integer quantity, Long salePrice, Long saleCnyPrice);

    /**
     * 查询发货单型号列表
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:36:15 xieyj
     * @history:
     */
    public List<InvoiceModel> queryInvoiceModelList(InvoiceModel data);

    /**
     * 查询发货单型号详情
     * @param code
     * @return 
     * @create: 2016年5月24日 下午9:36:24 xieyj
     * @history:
     */
    public InvoiceModel getInvoiceModel(String code);
}
