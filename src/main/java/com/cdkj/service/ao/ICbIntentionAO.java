package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.CbIntention;

@Component
public interface ICbIntentionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCbIntention(CbIntention data);

    public int dropCbIntention(String code);

    public int editCbIntention(CbIntention data);

    public Paginable<CbIntention> queryCbIntentionPage(int start, int limit,
            CbIntention condition);

    public List<CbIntention> queryCbIntentionList(CbIntention condition);

    public CbIntention getCbIntention(String code);

}
