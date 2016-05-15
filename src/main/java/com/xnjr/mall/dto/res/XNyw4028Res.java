package com.xnjr.mall.dto.res;

import java.util.List;

import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.InvestTable;

public class XNyw4028Res {

    private Invest invest;

    private List<InvestTable> investTableList;

    public Invest getInvest() {
        return invest;
    }

    public void setInvest(Invest invest) {
        this.invest = invest;
    }

    public List<InvestTable> getInvestTableList() {
        return investTableList;
    }

    public void setInvestTableList(List<InvestTable> investTableList) {
        this.investTableList = investTableList;
    }
}
