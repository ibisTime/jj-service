package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDAccountAO;
import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDAccount;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDCompanyAccount;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年4月23日 下午4:52:57 
 * @history:
 */
@Service
public class FDAccountAOImpl implements IFDAccountAO {

    @Autowired
    IFDAccountBO fdAccountBO;

    @Autowired
    IFDUserAccountBO fdUserAccountBO;

    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    /**
     * @see com.xnjr.mall.ao.IFDAccountAO#getAccount(java.lang.String)
     */
    @Override
    public FDAccount getAccount(String userId) {
        FDAccount account = fdAccountBO.getAccountByUserId(userId);
        if (account == null) {
            throw new BizException("li779001", userId + "用户不存在");
        }
        return account;
    }

    /** 
     * @see com.xnjr.mall.ao.IFDAccountAO#queryAccountPage(int, int, com.xnjr.mall.domain.FDAccount)
     */
    @Override
    public Paginable<FDAccount> queryAccountPage(int start, int limit,
            FDAccount condition) {
        Paginable<FDAccount> fdAccountPage = fdAccountBO.getPaginable(start,
            limit, condition);
        List<FDAccount> fdAccountList = fdAccountPage.getList();
        if (CollectionUtils.isNotEmpty(fdAccountList)) {
            for (FDAccount fdAccount : fdAccountList) {
                Long totalAmount = getTotalPrincipal(fdAccount.getUserId());
                fdAccount.setAmount(totalAmount);
            }
        }
        return fdAccountPage;
    }

    /** 
     * @see com.xnjr.mall.ao.IFDAccountAO#queryAccountList(com.xnjr.mall.domain.FDAccount)
     */
    @Override
    public List<FDAccount> queryAccountList(FDAccount condition) {
        return fdAccountBO.queryAccountList(condition);
    }

    @Override
    public Long getTotalPrincipal(String userId) {
        Long amount = 0L;
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        if (fdUser.getIndividualCode() != null) {
            FDUserAccount fdUserAccount = fdUserAccountBO
                .getAccountByUserId(userId);
            amount += fdUserAccount.getAmount();
        }
        List<FDCompany> companyList = fdUserCompanyBO
            .queryConfirmCompanyByUserId(userId);
        for (FDCompany fdCompany : companyList) {
            FDCompanyAccount fdCompanyAccount = fdCompanyAccountBO
                .getAccountByCompanyCode(fdCompany.getCode());
            amount += fdCompanyAccount.getAmount();
        }
        return amount;
    }

}
