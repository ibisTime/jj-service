package com.xnjr.mall.bo;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.GSAccountJour;

public interface IGSAJourBO extends IPaginableBO<GSAccountJour> {

    public GSAccountJour getAccountJour(String accountNumber);
}
