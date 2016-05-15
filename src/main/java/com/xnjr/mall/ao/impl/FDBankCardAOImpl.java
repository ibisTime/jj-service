package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDBankCardAO;
import com.xnjr.mall.bo.IBKBankBO;
import com.xnjr.mall.bo.IFDBankCardBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.domain.FDBankCard;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年4月22日 下午10:27:49 
 * @history:
 */
@Service
public class FDBankCardAOImpl implements IFDBankCardAO {
    @Autowired
    IFDBankCardBO fdBankCardBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IBKBankBO bkBankBO;

    @Override
    public Long addBankCard(String userId, String bankCode, String subbranch,
            String bankCardNo) {
        FDUser user = fdUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        BKBank bank = bkBankBO.getBKBank(bankCode);
        if (bank == null) {
            throw new BizException("fd0000", "银行不存在");
        }
        fdBankCardBO.checkBankCardNo(bankCardNo);
        return fdBankCardBO.saveBankCard(userId, user.getRealName(), bankCode,
            bank.getName(), subbranch, bankCardNo);
    }

    @Override
    public void editBankCard(Long id, String userId, String bankCode,
            String subbranch, String bankCardNo) {
        FDUser user = fdUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        BKBank bank = bkBankBO.getBKBank(bankCode);
        if (bank == null) {
            throw new BizException("fd0000", "银行不存在");
        }
        FDBankCard bankCard = fdBankCardBO.getBankCard(id);
        if (bankCard == null) {
            throw new BizException("fd0000", "银行卡编号不存在");
        }
        fdBankCardBO.refreshBankCard(id, userId, user.getRealName(), bankCode,
            bank.getName(), subbranch, bankCardNo);
    }

    @Override
    public void dropBankCard(Long id) {
        if (!fdBankCardBO.isBankCardExist(id)) {
            throw new BizException("fd0000", "银行卡编号不存在");
        }
        fdBankCardBO.removeBankCard(id);
    }

    @Override
    public FDBankCard getBankCard(Long id) {
        return fdBankCardBO.getBankCard(id);
    }

    @Override
    public Paginable<FDBankCard> queryBankCardPage(int start, int limit,
            FDBankCard condition) {
        return fdBankCardBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<FDBankCard> queryBankCardList(FDBankCard data) {
        return fdBankCardBO.queryBankCardList(data);
    }
}
