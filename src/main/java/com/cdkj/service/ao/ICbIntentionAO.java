package com.cdkj.service.ao;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.dto.req.XN612170Req;
import com.cdkj.service.dto.res.XN612176Res;

@Component
public interface ICbIntentionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCbIntention(XN612170Req req);

    public void dealCbIntention(String code, String dealResult, String updater,
            String remark);

    public Paginable<CbIntention> queryCbIntentionPage(int start, int limit,
            CbIntention condition);

    public XN612176Res getCbIntention(String code);

}
