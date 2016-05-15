package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.spring.ServiceModule;

/**
 * 
 * @author: duanjiewen
 * @since: 2016年4月18日 下午5:48:25 
 * @history:
 */
@ServiceModule
public interface IFDCompanyCardAO {

    String DEFAULT_ORDER_COLUMN = "id";

    public Long addCompanyCard(FDCompanyCard data);

    public int dropCompanyCard(Long id);

    public int editCompanyCard(FDCompanyCard data);

    public FDCompanyCard getCompanyCard(Long id);

    public List<FDCompanyCard> queryCompanyCardList(FDCompanyCard data);

    public Paginable<FDCompanyCard> queryCompanyCardPage(int start, int limit,
            FDCompanyCard condition);

}
