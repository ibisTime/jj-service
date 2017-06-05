package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.BcIntention;

@Component
public interface IBcIntentionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBcIntention(String type, String companyCode,
            String demandCode, String resumeCode, String submitter);

    public void editBcIntention(BcIntention data);

    public Paginable<BcIntention> queryBcIntentionPage(int start, int limit,
            BcIntention condition);

    public List<BcIntention> queryBcIntentionList(BcIntention condition);

    public BcIntention getBcIntention(String code);

}
