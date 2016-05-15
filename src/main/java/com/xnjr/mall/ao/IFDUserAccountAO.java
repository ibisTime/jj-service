package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.spring.ServiceModule;

/**
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:50:14 
 * @history:
 */
@ServiceModule
public interface IFDUserAccountAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    public FDUserAccount getAccountByUserId(String userId);

    public FDUserAccount getAccount(String accountNumber);

    public Paginable<FDUserAccount> queryUserAccountPage(int start, int limit,
            FDUserAccount condition);
}
