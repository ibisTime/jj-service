package com.cdkj.service.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IIntentionAO;
import com.cdkj.service.bo.IIntentionBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Intention;
import com.cdkj.service.enums.EIntentStatus;
import com.cdkj.service.enums.EIntentionType;
import com.cdkj.service.exception.BizException;

@Service
public class IntentionAOImpl implements IIntentionAO {

    @Autowired
    private IIntentionBO intentionBO;

    @Override
    public String addIntention(String fromUser, String toCode) {
        Intention data = new Intention();
        data.setFromUser(fromUser);
        data.setToCode(toCode);
        // 设置该意向的状态为申请中
        data.setStatus(EIntentStatus.APPLY.getCode());
        // 设置该意向的类型为感兴趣关系
        data.setType(EIntentionType.XQ.getCode());
        return intentionBO.saveIntention(data);
    }

    @Override
    public int dropIntention(String code) {
        if (!intentionBO.isIntentionExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return intentionBO.removeIntention(code);
    }

    @Override
    public int editXQIntentionStatus(String code, String dealer) {
        if (!intentionBO.isIntentionExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return intentionBO.refreshIntentionStatus(code, dealer, "已查看");
    }

    @Override
    public Paginable<Intention> queryXQIntentionPage(int start, int limit,
            Intention condition) {
        return intentionBO.getPaginable(start, limit, condition);
    }

}
