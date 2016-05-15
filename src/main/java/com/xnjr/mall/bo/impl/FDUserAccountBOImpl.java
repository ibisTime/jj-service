package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.AccountUtil;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IFDAFJourDAO;
import com.xnjr.mall.dao.IFDAJourDAO;
import com.xnjr.mall.dao.IFDAccountDAO;
import com.xnjr.mall.dao.IFDUserAccountDAO;
import com.xnjr.mall.domain.FDAccountFrozenJour;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.enums.EAccountJourStatus;
import com.xnjr.mall.enums.EAccountStatus;
import com.xnjr.mall.enums.EBizType;
import com.xnjr.mall.exception.BizException;

/**
 * 用户账户
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:48:20 
 * @history:
 */
@Component
public class FDUserAccountBOImpl extends PaginableBOImpl<FDUserAccount>
        implements IFDUserAccountBO {
    @Autowired
    private IFDAccountDAO fdAccountDAO;

    @Autowired
    private IFDAFJourDAO fdAFJourDAO;

    @Autowired
    private IFDAJourDAO fdAJourDAO;

    @Autowired
    private IFDUserAccountDAO fdUserAccountDAO;

    @Autowired
    private IFDAccountBO fdAccountBO;

    @Override
    public String distributeAccount(String userId, String realName,
            String currency) {
        String accountNumber = null;
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(currency)) {
            accountNumber = OrderNoGenerater.generateM("FI");
            FDUserAccount data = new FDUserAccount();
            data.setUserId(userId);
            data.setRealName(realName);
            data.setAccountNumber(accountNumber);
            data.setStatus(EAccountStatus.NORMAL.getCode());
            data.setAmount(0L);

            data.setFrozenAmount(0L);
            data.setCurrency(currency);
            data.setMd5(AccountUtil.md5(data.getAmount()));
            data.setCreateDatetime(new Date());
            fdUserAccountDAO.insert(data);
        }
        return accountNumber;
    }

    @Override
    public int refreshStatus(String accountNumber, EAccountStatus status) {
        int count = 0;
        if (StringUtils.isNotBlank(accountNumber)) {
            FDUserAccount data = new FDUserAccount();
            data.setAccountNumber(accountNumber);
            data.setStatus(status.getCode());
            data.setUpdateDatetime(new Date());
            count = fdUserAccountDAO.updateStatus(data);

        }
        return count;
    }

    @Override
    public FDUserAccount getAccount(String accountNumber) {
        FDUserAccount data = null;
        if (StringUtils.isNotBlank(accountNumber)) {
            FDUserAccount condition = new FDUserAccount();
            condition.setAccountNumber(accountNumber);
            data = fdUserAccountDAO.select(condition);
            if (data == null) {
                throw new BizException("xn702502", "无对应账户，请检查账号正确性");
            }
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IFDUserAccountBO#getAccountByCompanyCode(java.lang.String)
     */
    @Override
    public FDUserAccount getAccountByUserId(String userId) {
        FDUserAccount data = null;
        if (StringUtils.isNotBlank(userId)) {
            FDUserAccount condition = new FDUserAccount();
            condition.setUserId(userId);
            data = fdUserAccountDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IAccountBO#queryAccountList(com.ibis.account.domain.Account)
     */
    @Override
    public List<FDUserAccount> queryAccountList(FDUserAccount data) {
        return fdUserAccountDAO.selectList(data);
    }

    @Override
    public int refreshAmount(String accountNumber, Long transAmount,
            String bizType, String refNo, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(accountNumber)) {
            FDUserAccount dbAccount = this.getAccount(accountNumber);
            Long nowAmount = dbAccount.getAmount() + transAmount;
            if (nowAmount < 0) {
                throw new BizException("fd0000", "账户余额不足");
            }
            FDUserAccount account = new FDUserAccount();
            account.setAccountNumber(accountNumber);
            account.setAmount(nowAmount);
            account.setMd5(AccountUtil.md5(account.getAmount()));
            account.setUpdateDatetime(new Date());
            count = fdUserAccountDAO.updateAmount(account);
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
            // // 更新客户账户余额
            // fdAccountBO.refreshAmountWithoutJour(dbAccount.getUserId());
        }
        return count;
    }

    @Override
    public int refreshAmountWithoutCheck(String accountNumber,
            Long transAmount, String bizType, String refNo) {
        int count = 0;
        if (StringUtils.isNotBlank(accountNumber)) {
            FDUserAccount dbAccount = this.getAccount(accountNumber);
            Long nowAmount = dbAccount.getAmount() + transAmount;
            if (nowAmount < 0) {
                throw new BizException("fd0000", "账户余额不足");
            }
            FDUserAccount account = new FDUserAccount();
            account.setAccountNumber(accountNumber);
            account.setAmount(nowAmount);
            account.setMd5(AccountUtil.md5(account.getAmount()));
            account.setUpdateDatetime(new Date());
            count = fdUserAccountDAO.updateAmount(account);
        }
        return count;
    }

    @Override
    public void freezeAmount(String accountNumber, Long freezeAmount,
            EBizType bizType, String refNo) {
        if (freezeAmount < 0) {
            throw new BizException("xn702000", "冻结金额不能小于0");
        }
        if (StringUtils.isNotBlank(accountNumber)) {
            FDUserAccount dbAccount = this.getAccount(accountNumber);
            Long nowAmount = dbAccount.getAmount() - freezeAmount;
            if (nowAmount < 0) {
                throw new BizException("xn702000", "账户余额不足");
            }
            Long nowFrozenAmount = dbAccount.getFrozenAmount() + freezeAmount;
            Date now = new Date();
            FDUserAccount account = new FDUserAccount();
            account.setAccountNumber(accountNumber);
            account.setAmount(nowAmount);
            account.setFrozenAmount(nowFrozenAmount);
            account.setMd5(AccountUtil.md5(account.getAmount()));
            account.setUpdateDatetime(now);
            fdUserAccountDAO.updateFrozenAmount(account);
            // 记录资金流水
            FDAccountJour accountJour = new FDAccountJour();
            accountJour.setStatus(EAccountJourStatus.todoCheck.getCode());
            accountJour.setBizType(bizType.getCode());
            accountJour.setRefNo(refNo);
            accountJour.setTransAmount(-freezeAmount);
            accountJour.setPreAmount(dbAccount.getAmount());

            accountJour.setPostAmount(nowAmount);
            accountJour.setRemark(bizType.getValue());
            accountJour.setCreateDatetime(new Date());
            accountJour.setWorkDate(DateUtil
                .getToday(DateUtil.DB_DATE_FORMAT_STRING));
            accountJour.setAccountNumber(accountNumber);
            fdAJourDAO.insert(accountJour);
            // 记录冻结流水
            FDAccountFrozenJour accountFrozenJour = new FDAccountFrozenJour();
            accountFrozenJour.setBizType(bizType.getCode());
            accountFrozenJour.setRefNo(refNo);
            accountFrozenJour.setTransAmount(freezeAmount);
            accountFrozenJour.setPreAmount(dbAccount.getFrozenAmount());

            accountFrozenJour.setPostAmount(nowFrozenAmount);
            accountFrozenJour.setRemark(bizType.getValue());
            accountFrozenJour.setCreateDatetime(now);
            accountFrozenJour.setAccountNumber(accountNumber);
            fdAFJourDAO.insert(accountFrozenJour);
        }
    }

    @Override
    public void unfreezeAmount(String accountNumber, Long unfreezeAmount,
            EBizType bizType, String refNo, boolean backFlag) {
        if (unfreezeAmount < 0) {
            throw new BizException("xn702000", "解结金额不能小于0");
        }

        if (StringUtils.isNotBlank(accountNumber)) {
            FDUserAccount dbAccount = this.getAccount(accountNumber);
            Long nowFrozenAmount = dbAccount.getFrozenAmount() - unfreezeAmount;
            if (nowFrozenAmount < 0) {
                throw new BizException("xn702000", "本次账户解冻金额，会使账户冻结金额小于0");
            }
            if (backFlag) {// 解冻的金额返回至余额中
                Long nowAmount = dbAccount.getAmount() + unfreezeAmount;
                Date now = new Date();
                FDUserAccount account = new FDUserAccount();
                account.setAccountNumber(accountNumber);
                account.setAmount(nowAmount);
                account.setFrozenAmount(nowFrozenAmount);
                account.setMd5(AccountUtil.md5(account.getAmount()));
                account.setUpdateDatetime(now);
                fdUserAccountDAO.updateFrozenAmount(account);
                // 记录资金流水
                FDAccountJour accountJour = new FDAccountJour();
                accountJour.setStatus(EAccountJourStatus.todoCheck.getCode());
                accountJour.setBizType(bizType.getCode());
                accountJour.setRefNo(refNo);
                accountJour.setTransAmount(unfreezeAmount);
                accountJour.setPreAmount(dbAccount.getAmount());

                accountJour.setPostAmount(nowAmount);
                accountJour.setRemark("解冻金额返还回余额");
                accountJour.setCreateDatetime(new Date());
                accountJour.setWorkDate(DateUtil
                    .getToday(DateUtil.DB_DATE_FORMAT_STRING));
                accountJour.setAccountNumber(accountNumber);
                fdAJourDAO.insert(accountJour);
                // 记录冻结流水
                FDAccountFrozenJour accountFrozenJour = new FDAccountFrozenJour();
                accountFrozenJour.setBizType(bizType.getCode());
                accountFrozenJour.setRefNo(refNo);
                accountFrozenJour.setTransAmount(-unfreezeAmount);
                accountFrozenJour.setPreAmount(dbAccount.getFrozenAmount());

                accountFrozenJour.setPostAmount(nowFrozenAmount);
                accountFrozenJour.setRemark("解冻金额返还回余额");
                accountFrozenJour.setCreateDatetime(now);
                accountFrozenJour.setAccountNumber(accountNumber);
                fdAFJourDAO.insert(accountFrozenJour);
            } else {
                Long nowAmount = dbAccount.getAmount();
                Date now = new Date();
                FDUserAccount account = new FDUserAccount();
                account.setAccountNumber(accountNumber);
                account.setAmount(nowAmount);
                account.setFrozenAmount(nowFrozenAmount);
                account.setMd5(AccountUtil.md5(account.getAmount()));
                account.setUpdateDatetime(now);
                fdUserAccountDAO.updateFrozenAmount(account);
                // 记录流水
                FDAccountFrozenJour accountFrozenJour = new FDAccountFrozenJour();
                accountFrozenJour.setBizType(bizType.getCode());
                accountFrozenJour.setRefNo(refNo);
                accountFrozenJour.setTransAmount(-unfreezeAmount);
                accountFrozenJour.setPreAmount(dbAccount.getFrozenAmount());

                accountFrozenJour.setPostAmount(nowFrozenAmount);
                accountFrozenJour.setRemark("解冻金额直接扣减使用");
                accountFrozenJour.setCreateDatetime(now);
                accountFrozenJour.setAccountNumber(accountNumber);
                fdAFJourDAO.insert(accountFrozenJour);
            }

        }
    }

    /** 
     * @see com.xnjr.mall.bo.IFDUserAccountBO#refreshAmountWithdrawJour(com.xnjr.mall.domain.FDUserAccount, java.lang.Long)
     */
    @Override
    public int refreshAmountWithdrawJour(FDUserAccount fdUserAccount,
            Long transAmount) {
        int count = 0;
        if (fdUserAccount != null) {
            Long postAmount = fdUserAccount.getAmount() + transAmount;
            fdUserAccount.setAmount(postAmount);
            fdUserAccount.setMd5(AccountUtil.md5(fdUserAccount.getAmount()));
            fdUserAccount.setUpdateDatetime(new Date());
            count = fdUserAccountDAO.updateAmount(fdUserAccount);
        }
        return count;
    }
}
