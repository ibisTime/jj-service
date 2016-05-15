/**
 * @Title AccountBOImpl.java 
 * @Package com.ibis.account.bo.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:21:38 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.AccountUtil;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IFDAFJourDAO;
import com.xnjr.mall.dao.IFDAJourDAO;
import com.xnjr.mall.dao.IFDAccountDAO;
import com.xnjr.mall.domain.FDAccount;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.enums.EAccountJourStatus;
import com.xnjr.mall.enums.EAccountStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:21:38 
 * @history:
 */
@Component
public class FDAccountBOImpl extends PaginableBOImpl<FDAccount> implements
        IFDAccountBO {

    @Autowired
    private IFDAccountDAO fdAccountDAO;

    @Autowired
    private IFDAFJourDAO fdAFJourDAO;

    @Autowired
    private IFDAJourDAO fdAJourDAO;

    @Override
    public String distributeAccount(String userId, String realName,
            String currency) {
        String accountNumber = null;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(currency)) {
            accountNumber = OrderNoGenerater.generateM("A");
            FDAccount data = new FDAccount();
            data.setUserId(userId);
            data.setRealName(realName);
            data.setAccountNumber(accountNumber);
            data.setStatus(EAccountStatus.NORMAL.getCode());
            data.setAmount(0L);

            data.setFrozenAmount(0L);
            data.setCurrency(currency);
            data.setMd5(AccountUtil.md5(data.getAmount()));
            data.setCreateDatetime(new Date());
            fdAccountDAO.insert(data);
        }
        return accountNumber;
    }

    @Override
    public int refreshStatus(String accountNumber, EAccountStatus status) {
        int count = 0;
        if (StringUtils.isNotBlank(accountNumber)) {

            FDAccount data = new FDAccount();
            data.setAccountNumber(accountNumber);
            data.setStatus(status.getCode());
            data.setUpdateDatetime(new Date());
            count = fdAccountDAO.updateStatus(data);

        }
        return count;
    }

    @Override
    public void refreshRealName(String userId, String realName) {
        FDAccount data = new FDAccount();
        data.setUserId(userId);
        data.setRealName(realName);
        data.setUpdateDatetime(new Date());
        fdAccountDAO.updateRealName(data);
    }

    @Override
    public FDAccount getAccount(String accountNumber) {
        FDAccount data = null;
        if (StringUtils.isNotBlank(accountNumber)) {
            FDAccount condition = new FDAccount();
            condition.setAccountNumber(accountNumber);
            data = fdAccountDAO.select(condition);
            if (data == null) {
                throw new BizException("xn702502", "无对应账户，请检查账号正确性");
            }
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IFDAccountBO#getAccountByUserId(java.lang.String)
     */
    @Override
    public FDAccount getAccountByUserId(String userId) {
        FDAccount data = null;
        if (StringUtils.isNotBlank(userId)) {
            FDAccount condition = new FDAccount();
            condition.setUserId(userId);
            data = fdAccountDAO.select(condition);
            if (data == null) {
                throw new BizException("xn702502", "无对应账户，请检查用户编号正确性");
            }
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IAccountBO#queryAccountList(com.ibis.account.domain.Account)
     */
    @Override
    public List<FDAccount> queryAccountList(FDAccount data) {
        return fdAccountDAO.selectList(data);
    }

    @Override
    public int refreshAmount(String accountNumber, Long transAmount,
            String bizType, String refNo, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(accountNumber)) {
            FDAccount dbAccount = this.getAccount(accountNumber);
            Long nowAmount = dbAccount.getAmount() + transAmount;
            if (nowAmount < 0) {
                throw new BizException("li779001", "账户余额不足");
            }
            FDAccount account = new FDAccount();
            account.setAccountNumber(accountNumber);
            account.setAmount(nowAmount);
            account.setMd5(AccountUtil.md5(account.getAmount()));
            account.setUpdateDatetime(new Date());
            count = fdAccountDAO.updateAmount(account);
            // 记录流水
            FDAccountJour accountJour = new FDAccountJour();
            accountJour.setStatus(EAccountJourStatus.todoCheck.getCode());
            accountJour.setBizType(bizType);
            accountJour.setRefNo(refNo);
            accountJour.setTransAmount(transAmount);

            accountJour.setPreAmount(dbAccount.getAmount());

            accountJour.setPostAmount(nowAmount);
            accountJour.setRemark(remark);
            accountJour.setCreateDatetime(new Date());
            accountJour.setWorkDate(DateUtil
                .getToday(DateUtil.DB_DATE_FORMAT_STRING));
            accountJour.setAccountNumber(accountNumber);
            fdAJourDAO.insert(accountJour);
        }
        return count;
    }

    public int refreshAmountWithoutJour(String userId) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            // 检查账户是否存在
            FDAccount dbAccount = this.getAccountByUserId(userId);
            // 统计该用户拥有的账户总金额
            FDAccount condition = new FDAccount();
            condition.setUserId(userId);
            Long totalAmount = fdAccountDAO.selectTotalAmount(condition);
            if (totalAmount == null) {
                totalAmount = 0L;
            }
            // 更新账户金额
            FDAccount account = new FDAccount();
            account.setAccountNumber(dbAccount.getAccountNumber());
            account.setAmount(totalAmount);
            account.setMd5(AccountUtil.md5(totalAmount));
            account.setUpdateDatetime(new Date());
            count = fdAccountDAO.updateAmount(account);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IFDAccountBO#getTotalAccountAmount(java.lang.String)
     */
    @Override
    public Long getTotalAccountAmount(String userId) {
        Long totalAmount = 0L;
        if (StringUtils.isNotBlank(userId)) {
            // 统计该用户拥有的账户总金额
            FDAccount condition = new FDAccount();
            condition.setUserId(userId);
            totalAmount = fdAccountDAO.selectTotalAmount(condition);
            if (totalAmount == null) {
                totalAmount = 0L;
            }
        }
        return totalAmount;
    }
}
