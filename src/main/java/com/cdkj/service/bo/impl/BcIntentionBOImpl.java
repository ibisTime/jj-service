package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IBcIntentionBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IBcIntentionDAO;
import com.cdkj.service.domain.BcIntention;
import com.cdkj.service.exception.BizException;

@Component
public class BcIntentionBOImpl extends PaginableBOImpl<BcIntention> implements
        IBcIntentionBO {

    @Autowired
    private IBcIntentionDAO bcIntentionDAO;

    @Override
    public boolean isBcIntentionExist(String code) {
        BcIntention condition = new BcIntention();
        condition.setCode(code);
        if (bcIntentionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveBcIntention(BcIntention data) {
        bcIntentionDAO.insert(data);
    }

    @Override
    public void removeBcIntention(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BcIntention data = new BcIntention();
            data.setCode(code);
            count = bcIntentionDAO.delete(data);
        }
    }

    @Override
    public void refreshBcIntention(BcIntention data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bcIntentionDAO.update(data);
        }
    }

    @Override
    public List<BcIntention> queryBcIntentionList(BcIntention condition) {
        return bcIntentionDAO.selectList(condition);
    }

    @Override
    public BcIntention getBcIntention(String code) {
        BcIntention data = null;
        if (StringUtils.isNotBlank(code)) {
            BcIntention condition = new BcIntention();
            condition.setCode(code);
            data = bcIntentionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
