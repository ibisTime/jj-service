/**
 * @Title FDUserAccountAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午9:53:24 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDUserAccountAO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUserAccount;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:53:24 
 * @history:
 */
@Service
public class FDUserAccountAOImpl implements IFDUserAccountAO {

    @Autowired
    IFDUserAccountBO fdUserAccountBO;

    /** 
     * @see com.xnjr.mall.ao.IFDUserAccountAO#getAccount(java.lang.String)
     */
    @Override
    public FDUserAccount getAccountByUserId(String userId) {
        return fdUserAccountBO.getAccountByUserId(userId);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserAccountAO#getAccount(java.lang.String)
     */
    @Override
    public FDUserAccount getAccount(String accountNumber) {
        return fdUserAccountBO.getAccount(accountNumber);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserAccountAO#queryUserAccountPage(com.xnjr.mall.domain.FDUserAccount)
     */
    @Override
    public Paginable<FDUserAccount> queryUserAccountPage(int start, int limit,
            FDUserAccount condition) {
        return fdUserAccountBO.getPaginable(start, limit, condition);
    }
}
