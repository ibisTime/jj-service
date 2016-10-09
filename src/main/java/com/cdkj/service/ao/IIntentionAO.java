package com.cdkj.service.ao;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Intention;

public interface IIntentionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 对服务/需求/简历感兴趣
    public String addIntention(String fromUser, String toCode, String type);

    // 个人对公司职位感兴趣，投递简历
    public String addZWIntention(String userId, String resumeCode,
            String positionCode);

    public int dropIntention(String code);

    // 处理意向，状态更改为已完成(简单查看)
    public int editIntentionStatus(String code, String dealNote, String dealer);

    // 分页查询感兴趣服务
    public Paginable<Intention> queryFWIntentionPage(int start, int limit,
            Intention condition);

    // 分页查询感兴趣需求
    public Paginable<Intention> queryXQIntentionPage(int start, int limit,
            Intention condition);

    // 分页查询感兴趣简历
    public Paginable<Intention> queryJLIntentionPage(int start, int limit,
            Intention condition);

    // 分页查询申请的职位
    public Paginable<Intention> queryZWIntentionPage(int start, int limit,
            Intention condition);
}
