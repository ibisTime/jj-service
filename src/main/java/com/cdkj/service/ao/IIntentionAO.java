package com.cdkj.service.ao;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Intention;

public interface IIntentionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addIntention(String fromUser, String toCode);

    public int dropIntention(String code);

    // 更新感兴趣关系的状态
    public int editXQIntentionStatus(String code, String dealer);

    // 分页查询感兴趣关系
    public Paginable<Intention> queryXQIntentionPage(int start, int limit,
            Intention condition);
}
