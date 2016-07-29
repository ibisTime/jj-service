package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xnjr.mall.ao.ISaleGuideAO;
import com.xnjr.mall.bo.ISaleGuideBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.SaleGuide;

public class SaleGuideAOImpl implements ISaleGuideAO {

    @Autowired
    ISaleGuideBO saleGuideBO;

    @Override
    public int doRefreshSaleGuide(SaleGuide data) {
        return saleGuideBO.refreshSaleGuide(data);
    }

    @Override
    public Paginable<SaleGuide> querySaleGuidePage(int start, int limit,
            SaleGuide condition) {
        return saleGuideBO.getPaginable(start, limit, condition);
    }

    @Override
    public SaleGuide getSaleGuide(String code) {
        return saleGuideBO.getSaleGuide(code);
    }

}
