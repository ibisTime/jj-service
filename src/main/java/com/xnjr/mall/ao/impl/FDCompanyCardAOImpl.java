package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDCompanyCardAO;
import com.xnjr.mall.bo.IBKBankBO;
import com.xnjr.mall.bo.IFDCompanyBO;
import com.xnjr.mall.bo.IFDCompanyCardBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.exception.BizException;

/**
 * 资金方-企业账号
 * @author: duanjiewen 
 * @since: 2016年4月18日 下午7:07:54 
 * @history:
 */
@Service
public class FDCompanyCardAOImpl implements IFDCompanyCardAO {
    @Autowired
    IFDCompanyCardBO fdCompanyCardBO;

    @Autowired
    IFDCompanyBO fdCompanyBO;

    @Autowired
    IBKBankBO bkBankBO;

    @Override
    public Long addCompanyCard(FDCompanyCard data) {
        Long id = null;
        if (data != null
                && !fdCompanyCardBO.isCompanyCardExist(data.getCardNo())) {
            FDCompany fdCompany = fdCompanyBO.getCompany(data.getCompanyCode());
            if (fdCompany == null) {
                throw new BizException("XNfd0000", "企业编号不存在");
            }
            data.setCompanyName(fdCompany.getName());
            BKBank bkBank = bkBankBO.getBKBank(data.getBankCode());
            if (bkBank == null) {
                throw new BizException("XNfd0000", "银行编号不存在");
            }
            data.setBankName(bkBank.getName());
            fdCompanyCardBO.saveCompanyCard(data);
            id = data.getId();
        } else {
            throw new BizException("XNfd0000", "企业银行账号已存在");
        }
        return id;
    }

    /** 
     * @see com.xnjr.mall.ao.IFDCompanyCardAO#dropCompanyCard(java.lang.Long)
     */
    @Override
    public int dropCompanyCard(Long id) {
        return fdCompanyCardBO.removeCompanyCard(id);
    }

    @Override
    public int editCompanyCard(FDCompanyCard data) {
        int count = 0;
        if (data != null) {
            BKBank bkBank = bkBankBO.getBKBank(data.getBankCode());
            if (bkBank == null) {
                throw new BizException("XNfd0000", "银行编号不存在");
            }
            data.setBankName(bkBank.getName());

            FDCompanyCard condition = new FDCompanyCard();
            condition.setCardNo(data.getCardNo());
            List<FDCompanyCard> companyCardList = fdCompanyCardBO
                .queryCompanyCardList(condition);
            if (CollectionUtils.isNotEmpty(companyCardList)) {
                for (FDCompanyCard fdCompanyCard : companyCardList) {
                    if (!fdCompanyCard.getId().equals(data.getId())
                            && fdCompanyCard.getCardNo().equals(
                                data.getCardNo())) {
                        throw new BizException("XNfd0000", "企业银行账号已存在");
                    }
                }
            }
            count = fdCompanyCardBO.refreshCompanyCard(data);
        } else {
            throw new BizException("lh5031", "企业银行账号已存在");
        }
        return count;
    }

    @Override
    public FDCompanyCard getCompanyCard(Long id) {
        return fdCompanyCardBO.getCompanyCard(id);
    }

    @Override
    public List<FDCompanyCard> queryCompanyCardList(FDCompanyCard data) {
        return fdCompanyCardBO.queryCompanyCardList(data);
    }

    @Override
    public Paginable<FDCompanyCard> queryCompanyCardPage(int start, int limit,
            FDCompanyCard condition) {
        return fdCompanyCardBO.getPaginable(start, limit, condition);
    }
}
