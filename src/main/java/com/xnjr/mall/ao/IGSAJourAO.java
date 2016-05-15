package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.GSAccountJour;
import com.xnjr.mall.spring.ServiceModule;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午4:57:00 
 * @history:
 */
@ServiceModule
public interface IGSAJourAO {

    String DEFAULT_ORDER_COLUMN = "aj_no";

    /**
     * 分页查询系统账户流水
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年4月19日 下午4:57:48 Gejin
     * @history:
     */
    public Paginable<GSAccountJour> queryGSAccountJourPage(int start,
            int limit, GSAccountJour condition);

    /**
     * 详细查看系统账户流水
     * @param accountNumber
     * @return 
     * @create: 2016年4月19日 下午5:00:01 Gejin
     * @history:
     */
    public GSAccountJour getAccountJour(String accountNumber);
}
