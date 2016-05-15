package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDCompanyCardBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IFDCompanyCardDAO;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.enums.ECompanyCardStatus;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月18日 下午5:14:40 
 * @history:
 */
@Component
public class FDCompanyCardBOImpl extends PaginableBOImpl<FDCompanyCard>
        implements IFDCompanyCardBO {
    @Autowired
    private IFDCompanyCardDAO fdCompanyCardDAO;

    @Override
    public int saveCompanyCard(FDCompanyCard data) {
        int count = 0;
        if (data != null) {
            data.setCreateDatetime(new Date());
            data.setStatus(ECompanyCardStatus.TOCONFIRM.getCode());
            count = fdCompanyCardDAO.insert(data);
        }
        return count;
    }

    @Override
    public int refreshCompanyCard(FDCompanyCard data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = fdCompanyCardDAO.update(data);
        }
        return count;
    }

    @Override
    public int removeCompanyCard(Long id) {
        int count = 0;
        if (id != null) {
            FDCompanyCard data = new FDCompanyCard();
            data.setId(id);
            count = fdCompanyCardDAO.delete(data);
        }
        return count;
    }

    @Override
    public FDCompanyCard getCompanyCard(Long id) {
        FDCompanyCard data = null;
        if (id != null) {
            FDCompanyCard condition = new FDCompanyCard();
            condition.setId(id);
            data = fdCompanyCardDAO.select(condition);
        }
        return data;
    }

    @Override
    public boolean isCompanyCardExist(String cardNo) {
        if (StringUtils.isNotBlank(cardNo)) {
            FDCompanyCard companyCard = new FDCompanyCard();
            companyCard.setCardNo(cardNo);
            if (fdCompanyCardDAO.selectTotalCount(companyCard) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<FDCompanyCard> queryCompanyCardList(FDCompanyCard data) {
        return fdCompanyCardDAO.selectList(data);
    }

}
