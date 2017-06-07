package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.dto.req.XN612170Req;
import com.cdkj.service.dto.res.XN612176Res;

@Component
public interface ICbIntentionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCbIntention(XN612170Req req);

    public void editCbIntention(String code, String dealResult, String updater,
            String remark);

    public Paginable<CbIntention> queryCbIntentionPage(int start, int limit,
            CbIntention condition);

    public List<CbIntention> queryCbIntentionList(CbIntention condition);

    public XN612176Res getCbIntention(String code);

}
