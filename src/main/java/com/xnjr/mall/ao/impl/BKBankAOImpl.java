/**
 * @Title BKBankAOImpl.java 
 * @Package com.ibis.account.ao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-6-16 下午4:35:34 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IBKBankAO;
import com.xnjr.mall.bo.IBKBankBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-6-16 下午4:35:34 
 * @history:
 */
@Service
public class BKBankAOImpl implements IBKBankAO {
    @Autowired
    IBKBankBO bkBankBO;

    /**
     * @see com.xnjr.mall.ao.IBKBankAO#addBKBank(com.xnjr.mall.domain.BKBank)
     */
    @Override
    public String addBKBank(BKBank data) {
        if (data != null && !bkBankBO.isBKBankExist(data.getCode())) {
            bkBankBO.saveBKBank(data);
        } else {
            throw new BizException("li01006", "银行编号已经存在！");
        }
        return data.getCode();
    }

    /**
     * @see com.xnjr.mall.ao.IBKBankAO#dropBKBank(java.lang.String)
     */
    @Override
    public boolean dropBKBank(String code) {
        if (bkBankBO.isBKBankExist((code))) {
            bkBankBO.removeBKBank(code);
        } else {
            throw new BizException("xn702000", "删除银行不存在！");
        }
        return true;
    }

    /**
     * @see com.xnjr.mall.ao.IBKBankAO#editBKBank(com.xnjr.mall.domain.BKBank)
     */
    @Override
    public boolean editBKBank(BKBank data) {
        if (data != null && bkBankBO.isBKBankExist(data.getCode())) {
            bkBankBO.refreshBkBank(data);
        } else {
            throw new BizException("li01007", "银行编号不存在！");
        }
        return true;
    }

    /**
     * @see com.xnjr.mall.ao.IBKBankAO#queryBKBankPage(int, int, com.xnjr.mall.domain.BKBank)
     */
    @Override
    public Paginable<BKBank> queryBKBankPage(int start, int limit,
            BKBank condition) {
        return bkBankBO.getPaginable(start, limit, condition);
    }

    /**
     * @see com.xnjr.mall.ao.IBKBankAO#queryBKBankList(com.xnjr.mall.domain.BKBank)
     */
    @Override
    public List<BKBank> queryBKBankList(BKBank condition) {
        return bkBankBO.queryBKBankList(condition);
    }

    /**
     * @see com.xnjr.mall.ao.IBKBankAO#getBKBank(java.lang.String)
     */
    public BKBank getBKBank(String code) {
        return bkBankBO.getBKBank(code);
    }
}
