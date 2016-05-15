/**
 * @Title FDCompanyAccountAO.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月24日 下午5:47:14 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDCompanyAccountAO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDCompanyAccount;

/** 
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:47:14 
 * @history:
 */
@Service
public class FDCompanyAccountAO implements IFDCompanyAccountAO {
    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    /** 
     * @see com.xnjr.mall.ao.IFDCompanyAccountAO#getAccountByCompanyCode(java.lang.String)
     */
    @Override
    public FDCompanyAccount getAccountByCompanyCode(String companyCode) {
        return fdCompanyAccountBO.getAccountByCompanyCode(companyCode);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDCompanyAccountAO#queryAccountPage(int, int, com.xnjr.mall.domain.FDAccount)
     */
    @Override
    public Paginable<FDCompanyAccount> queryAccountPage(int start, int limit,
            FDCompanyAccount condition) {
        return fdCompanyAccountBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDCompanyAccountAO#queryAccountList(com.xnjr.mall.domain.FDAccount)
     */
    @Override
    public List<FDCompanyAccount> queryAccountList(FDCompanyAccount condition) {
        return fdCompanyAccountBO.queryAccountList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDCompanyAccountAO#getAccount(java.lang.String)
     */
    @Override
    public FDCompanyAccount getAccount(String accountNumber) {
        return fdCompanyAccountBO.getAccount(accountNumber);
    }
}
