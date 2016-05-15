package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDCompanyAccount;
import com.xnjr.mall.spring.ServiceModule;

/**
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:50:14 
 * @history:
 */
@ServiceModule
public interface IFDCompanyAccountAO {
    String DEFAULT_ORDER_COLUMN = "account_number";

    public FDCompanyAccount getAccountByCompanyCode(String companyCode);

    public Paginable<FDCompanyAccount> queryAccountPage(int start, int limit,
            FDCompanyAccount condition);

    public List<FDCompanyAccount> queryAccountList(FDCompanyAccount condition);

    public FDCompanyAccount getAccount(String accountNumber);
}
