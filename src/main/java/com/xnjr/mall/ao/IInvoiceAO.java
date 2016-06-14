package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Invoice;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午10:39:37 
 * @history:
 */
public interface IInvoiceAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 立即购买
     * @param userId
     * @param modelCode
     * @param quantity
     * @param salePrice
     * @param data
     * @return 
     * @create: 2016年5月25日 上午10:48:20 xieyj
     * @history:
     */
    public String commitInvoice(String modelCode, Integer quantity,
            Long salePrice, Invoice data);

    /**
     * 批量提交发货单
     * @param userId
     * @param data
     * @return 
     * @create: 2016年5月25日 上午10:16:02 xieyj
     * @history:
     */
    public String commitInvoice(List<String> cartCodeList, Invoice data);

    /**
     * 支付订单，待确认
     * @param code
     * @param tradePwd
     * @return 
     * @create: 2016年5月25日 上午11:40:28 xieyj
     * @history:
     */
    public void toPayInvoice(String code, String tradePwd);

    /**
     * 取消发货单
     * @param code
     * @param userId
     * @param applyNote
     * @return 
     * @create: 2016年6月1日 下午6:09:54 xieyj
     * @history:
     */
    public int cancelInvoice(String code, String userId, String applyNote);

    /**
     * 取消发货单
     * @param code
     * @param approveUser
     * @param approveNote
     * @return 
     * @create: 2016年5月26日 下午4:51:22 xieyj
     * @history:
     */
    public int cancelInvoiceOss(String code, String approveUser,
            String approveNote);

    /**
     * 订单付款
     * @param code
     * @param amount
     * @param fromType
     * @param fromCode
     * @param pdf
     * @param toCardNo
     * @param approveUser
     * @param approveNote 
     * @create: 2016年6月13日 上午11:35:08 xieyj
     * @history:
     */
    public void payInvoice(String code, Long amount, String fromType,
            String fromCode, String pdf, String toCardNo, String approveUser,
            String approveNote);

    /**
     * 发货单分页查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public Paginable<Invoice> queryInvoicePage(int start, int limit,
            Invoice condition);

    /**
     * 发货单列表查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public List<Invoice> queryInvoiceList(Invoice condition);

    /**
     * 发货单详情
     * @param code
     * @return 
     * @create: 2016年5月24日 上午9:07:33 xieyj
     * @history:
     */
    public Invoice getInvoice(String code);

}
