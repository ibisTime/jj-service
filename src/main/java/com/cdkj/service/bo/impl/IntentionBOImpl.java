package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IIntentionBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IIntentionDAO;
import com.cdkj.service.domain.Intention;
import com.cdkj.service.enums.EIntentStatus;
import com.cdkj.service.exception.BizException;

@Component
public class IntentionBOImpl extends PaginableBOImpl<Intention> implements
        IIntentionBO {

    @Autowired
    private IIntentionDAO intentionDAO;

    @Override
    public boolean isIntentionExist(String code) {
        Intention condition = new Intention();
        condition.setCode(code);
        if (intentionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveIntention(Intention data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.YX.getCode());
            data.setCode(code);
            data.setFromDatetime(new Date());
            intentionDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeIntention(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Intention data = new Intention();
            data.setCode(code);
            count = intentionDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshIntentionStatus(String code, String dealer,
            String dealNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Intention data = new Intention();
            data.setCode(code);
            data.setStatus(EIntentStatus.FINISH.getCode());
            data.setDealer(dealer);
            data.setDealNote(dealNote);
            data.setDealDatetime(new Date());
            count = intentionDAO.updateStatus(data);
        }
        return count;
    }

    @Override
    public List<Intention> queryIntentionList(Intention condition) {
        return intentionDAO.selectList(condition);
    }

    @Override
    public Intention getIntention(String code) {
        Intention data = null;
        if (StringUtils.isNotBlank(code)) {
            Intention condition = new Intention();
            condition.setCode(code);
            data = intentionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "编号不存在");
            }
        }
        return data;
    }
}
