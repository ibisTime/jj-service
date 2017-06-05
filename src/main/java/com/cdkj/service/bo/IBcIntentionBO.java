package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.BcIntention;

public interface IBcIntentionBO extends IPaginableBO<BcIntention> {

    public boolean isBcIntentionExist(String code);

    public void saveBcIntention(BcIntention data);

    public void removeBcIntention(String code);

    public void refreshBcIntention(BcIntention data);

    public List<BcIntention> queryBcIntentionList(BcIntention condition);

    public BcIntention getBcIntention(String code);

}
