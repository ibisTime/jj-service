package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.CbIntention;

public interface ICbIntentionBO extends IPaginableBO<CbIntention> {

    public boolean isCbIntentionExist(String code);

    public String saveCbIntention(CbIntention data);

    public int removeCbIntention(String code);

    public int refreshCbIntention(CbIntention data);

    public List<CbIntention> queryCbIntentionList(CbIntention condition);

    public CbIntention getCbIntention(String code);

}
