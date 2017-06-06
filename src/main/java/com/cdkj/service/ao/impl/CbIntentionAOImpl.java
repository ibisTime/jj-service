package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.ICbIntentionAO;
import com.cdkj.service.bo.ICbIntentionBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.exception.BizException;

@Service
public class CbIntentionAOImpl implements ICbIntentionAO {

    @Autowired
    private ICbIntentionBO cbIntentionBO;

    @Override
    public String addCbIntention(CbIntention data) {
        return cbIntentionBO.saveCbIntention(data);
    }

    @Override
    public int editCbIntention(CbIntention data) {
        if (!cbIntentionBO.isCbIntentionExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return cbIntentionBO.refreshCbIntention(data);
    }

    @Override
    public int dropCbIntention(String code) {
        if (!cbIntentionBO.isCbIntentionExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return cbIntentionBO.removeCbIntention(code);
    }

    @Override
    public Paginable<CbIntention> queryCbIntentionPage(int start, int limit,
            CbIntention condition) {
        return cbIntentionBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CbIntention> queryCbIntentionList(CbIntention condition) {
        return cbIntentionBO.queryCbIntentionList(condition);
    }

    @Override
    public CbIntention getCbIntention(String code) {
        return cbIntentionBO.getCbIntention(code);
    }
}
