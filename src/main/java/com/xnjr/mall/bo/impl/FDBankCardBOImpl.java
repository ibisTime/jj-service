package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDBankCardBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IFDBankCardDAO;
import com.xnjr.mall.domain.FDBankCard;
import com.xnjr.mall.enums.EBankCardStatus;
import com.xnjr.mall.exception.BizException;

/**
 * 资金方-个人银行卡
 * @author: xieyj 
 * @since: 2016年4月23日 上午8:38:54 
 * @history:
 */
@Component
public class FDBankCardBOImpl extends PaginableBOImpl<FDBankCard> implements
        IFDBankCardBO {
    @Autowired
    private IFDBankCardDAO fdBankCardDAO;

    @Override
    public Long saveBankCard(String userId, String realName, String bankCode,
            String bankName, String subbranch, String bankCardNo) {
        FDBankCard data = new FDBankCard();
        data.setUserId(userId);
        data.setRealName(realName);
        data.setBankCode(bankCode);
        data.setBankName(bankName);
        data.setSubbranch(subbranch);
        data.setBankcardNo(bankCardNo);
        data.setCreateDatetime(new Date());
        data.setStatus(EBankCardStatus.TOCONFIRM.getCode());
        fdBankCardDAO.insert(data);
        return data.getId();
    }

    @Override
    public int refreshBankCard(Long id, String userId, String realName,
            String bankCode, String bankName, String subbranch,
            String bankCardNo) {
        FDBankCard data = new FDBankCard();
        data.setId(id);
        data.setUserId(userId);
        data.setRealName(realName);
        data.setBankCode(bankCode);
        data.setBankName(bankName);
        data.setSubbranch(subbranch);
        data.setBankcardNo(bankCardNo);
        data.setUpdateDatetime(new Date());
        return fdBankCardDAO.update(data);
    }

    @Override
    public int removeBankCard(Long id) {
        int count = 0;
        if (id != null) {
            FDBankCard data = new FDBankCard();
            data.setId(id);
            count = fdBankCardDAO.delete(data);
        }
        return count;
    }

    @Override
    public FDBankCard getBankCard(Long id) {
        FDBankCard data = null;
        if (id != null) {
            FDBankCard condition = new FDBankCard();
            condition.setId(id);
            data = fdBankCardDAO.select(condition);
        }
        return data;
    }

    @Override
    public boolean isBankCardExist(Long id) {
        FDBankCard data = new FDBankCard();
        data.setId(id);
        if (fdBankCardDAO.selectTotalCount(data) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void checkBankCardNo(String bankCardNo) {
        FDBankCard data = new FDBankCard();
        data.setBankcardNo(bankCardNo);
        if (fdBankCardDAO.selectTotalCount(data) > 0) {
            throw new BizException("fd0000", "银行卡号已存在");
        }
    }

    @Override
    public List<FDBankCard> queryBankCardList(FDBankCard data) {
        return fdBankCardDAO.selectList(data);
    }
}
