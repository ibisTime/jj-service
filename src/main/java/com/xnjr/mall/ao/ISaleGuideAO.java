package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.SaleGuide;

public interface ISaleGuideAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /** 
     * 修改分销引导
     * @param data
     * @return 
     * @create: 2016年7月29日 下午1:14:20 zuixian
     * @history: 
     */
    public int doRefreshSaleGuide(SaleGuide data);

    /** 
     * 分页查询
     * @param condition
     * @return 
     * @create: 2016年7月29日 下午1:14:40 zuixian
     * @history: 
     */
    public Paginable<SaleGuide> querySaleGuidePage(int start, int limit,
            SaleGuide condition);

    /** 
     * 列表查询
     * @param condition
     * @return 
     * @create: 2016年7月29日 下午1:14:40 zuixian
     * @history: 
     */
    public List<SaleGuide> querySaleGuideList(SaleGuide condition);

    /** 
     * 详情查询
     * @param condition
     * @return 
     * @create: 2016年7月29日 下午1:14:57 zuixian
     * @history: 
     */
    public SaleGuide getSaleGuide(String code);
}
