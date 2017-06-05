package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ICbIntentionBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.ICbIntentionDAO;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.exception.BizException;

@Component
public class CbIntentionBOImpl extends PaginableBOImpl<CbIntention> implements
        ICbIntentionBO {

    @Autowired
    private ICbIntentionDAO CbIntentionDAO;

    @Override
    public boolean isCbIntentionExist(String code) {
        CbIntention condition = new CbIntention();
        condition.setCode(code);
        if (CbIntentionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCbIntention(CbIntention data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.CBYX.getCode());
            data.setCode(code);
            CbIntentionDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeCbIntention(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            CbIntention data = new CbIntention();
            data.setCode(code);
            count = CbIntentionDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCbIntention(CbIntention data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = CbIntentionDAO.update(data);
        }
        return count;
    }

    @Override
    public List<CbIntention> queryCbIntentionList(CbIntention condition) {
        return CbIntentionDAO.selectList(condition);
    }

    @Override
    public CbIntention getCbIntention(String code) {
        CbIntention data = null;
        if (StringUtils.isNotBlank(code)) {
            CbIntention condition = new CbIntention();
            condition.setCode(code);
            data = CbIntentionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
