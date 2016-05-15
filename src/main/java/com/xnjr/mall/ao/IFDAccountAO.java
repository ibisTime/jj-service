package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDAccount;
import com.xnjr.mall.spring.ServiceModule;

/**
 * @author: xieyj 
 * @since: 2016年4月23日 下午5:30:41 
 * @history:
 */
@ServiceModule
public interface IFDAccountAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    public FDAccount getAccount(String userId);

    /**
     * 分页查询账户
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年6月26日 下午4:04:11 myb858
     * @history:
     */
    public Paginable<FDAccount> queryAccountPage(int start, int limit,
            FDAccount condition);

    /**
     * 账户列表查询
     * @param condition
     * @return 
     * @create: 2015年12月12日 下午5:06:40 haiqingzheng
     * @history:
     */
    public List<FDAccount> queryAccountList(FDAccount condition);

    public Long getTotalPrincipal(String userId);
}
