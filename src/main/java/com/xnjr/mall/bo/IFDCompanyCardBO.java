package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDCompanyCard;

public interface IFDCompanyCardBO extends IPaginableBO<FDCompanyCard> {

    public int saveCompanyCard(FDCompanyCard data);

    public int refreshCompanyCard(FDCompanyCard data);

    public int removeCompanyCard(Long id);

    public FDCompanyCard getCompanyCard(Long id);

    public boolean isCompanyCardExist(String cardNo);

    public List<FDCompanyCard> queryCompanyCardList(FDCompanyCard data);
}
