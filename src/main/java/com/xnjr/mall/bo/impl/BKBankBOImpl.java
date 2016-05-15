package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IBKBankBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IBKBankDAO;
import com.xnjr.mall.domain.BKBank;

/** 
 * BKBank
 * @author: miyb 
 * @since: 2015-6-16 下午4:52:49 
 * @history:
 */
@Component
public class BKBankBOImpl extends PaginableBOImpl<BKBank> implements IBKBankBO {
    @Autowired
    private IBKBankDAO bkBankDAO;

    @Override
    public boolean isBKBankExist(String code) {
        BKBank bank = new BKBank();
        bank.setCode(code);
        if (bkBankDAO.selectTotalCount(bank) >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public int saveBKBank(BKBank data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getCode())) {
            count = bkBankDAO.insert(data);
        }
        return count;
    }

    @Override
    public int removeBKBank(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BKBank data = new BKBank();
            data.setCode(code);
            count = bkBankDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBkBank(BKBank data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getCode())) {
            count = bkBankDAO.update(data);
        }
        return count;

    }

    @Override
    public BKBank getBKBank(String code) {
        BKBank data = null;
        if (StringUtils.isNotBlank(code)) {
            BKBank condition = new BKBank();
            condition.setCode(code);
            data = bkBankDAO.select(condition);
        }
        return data;
    }

    @Override
    public List<BKBank> queryBKBankList(BKBank data) {
        return bkBankDAO.selectList(data);
    }

}
