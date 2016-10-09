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
    public String addIntention(String fromUser, String toCode, String type) {
        Intention data = new Intention();
        data.setFromUser(fromUser);
        data.setToCode(toCode);
        // 设置该意向的状态为申请中
        data.setStatus(EIntentStatus.APPLY.getCode());
        // 设置该意向的类型
        switch (type) {
            case "2":
                data.setType(EIntentionType.FW.getCode());
                break;
            case "3":
                data.setType(EIntentionType.XQ.getCode());
                break;
            case "4":
                data.setType(EIntentionType.JL.getCode());
                break;
        }
        return intentionBO.saveIntention(data);
    }

    @Override
    public String addZWIntention(String userId, String resumeCode,
            String positionCode) {
        Intention data = new Intention();
        data.setFromUser(userId);
        data.setToCode(positionCode);
        // 设置简历编号
        data.setFromRole(resumeCode);
        // 设置该意向的状态为申请中
        data.setStatus(EIntentStatus.APPLY.getCode());
        // 设置该意向的类型
        data.setType(EIntentionType.ZW.getCode());
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
    public int editIntentionStatus(String code, String dealNote, String dealer) {
        if (!intentionBO.isIntentionExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return intentionBO.refreshIntentionStatus(code, dealNote, dealer);
    }

    @Override
    public Paginable<Intention> queryFWIntentionPage(int start, int limit,
            Intention condition) {
        return intentionBO.getFWPaginable(start, limit, condition);
    }

    @Override
    public Paginable<Intention> queryXQIntentionPage(int start, int limit,
            Intention condition) {
        return intentionBO.getXQPaginable(start, limit, condition);
    }

    @Override
    public Paginable<Intention> queryJLIntentionPage(int start, int limit,
            Intention condition) {
        return intentionBO.getJLPaginable(start, limit, condition);
    }

    @Override
    public Paginable<Intention> queryZWIntentionPage(int start, int limit,
            Intention condition) {
        return intentionBO.getZWPaginable(start, limit, condition);
    }

}
