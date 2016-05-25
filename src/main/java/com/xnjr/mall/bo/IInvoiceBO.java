package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Invoice;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface IInvoiceBO extends IPaginableBO<Invoice> {

    /**
     * 判断是否存在
     * @param code
     * @return 
     * @create: 2016年5月25日 上午8:22:46 xieyj
     * @history:
     */
    public boolean isInvoiceExist(String code);

    /**
     * 保存发货单
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:35:33 xieyj
     * @history:
     */
    public String saveInvoice(Invoice data);

    /**
     * 更新发货单状态
     * @param code
     * @param status
     * @return 
     * @create: 2016年5月25日 上午8:18:30 xieyj
     * @history:
     */
    public int refreshInvoiceStatus(String code, String status);

    /**
     * 取消发货单
     * @param code
     * @param applyNote
     * @return 
     * @create: 2016年5月25日 上午8:18:57 xieyj
     * @history:
     */
    public int cancelInvoice(String code, String applyNote);

    /**
     * 发货反馈更新
     * @param code
     * @param approveUser
     * @param status
     * @param approveNote
     * @return 
     * @create: 2016年5月25日 下午12:40:10 xieyj
     * @history:
     */
    public int approveInvoice(String code, String approveUser, String status,
            String approveNote);

    /**
     * 查询发货单列表
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:36:15 xieyj
     * @history:
     */
    public List<Invoice> queryInvoiceList(Invoice data);

    /**
     * 查询发货单详情
     * @param code
     * @return 
     * @create: 2016年5月24日 下午9:36:24 xieyj
     * @history:
     */
    public Invoice getInvoice(String code);
}
