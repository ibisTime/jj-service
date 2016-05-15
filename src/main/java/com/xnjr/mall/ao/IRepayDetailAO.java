package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.RepayDetail;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: wuql
 * @since: 2016年1月21日 下午8:02:13 
 * @history:
 */
@ServiceModule
public interface IRepayDetailAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public void repayShi(String code, String remark, String tradePwd);

    public void repayKong(String code, String remark, String tradePwd);

    public Paginable<RepayDetail> queryRepayDetailPage(int start, int limit,
            RepayDetail condition);

    public RepayDetail getRepayDetail(String code);

    public Long getTotalInvest(String userId);

    public Long getTotalProfit(String userId);
}
