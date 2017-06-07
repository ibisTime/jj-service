package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ICbIntentionBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.ICbIntentionDAO;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.enums.ECbIntentionStatus;
import com.cdkj.service.exception.BizException;

@Component
public class CbIntentionBOImpl extends PaginableBOImpl<CbIntention> implements
        ICbIntentionBO {

    @Autowired
    private ICbIntentionDAO cbIntentionDAO;

    @Override
    public boolean isCbIntentionExist(String code) {
        CbIntention condition = new CbIntention();
        condition.setCode(code);
        if (cbIntentionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveCbIntention(CbIntention data) {
        cbIntentionDAO.insert(data);
    }

    @Override
    public void refreshCbIntention(CbIntention data, ECbIntentionStatus status,
            String updater, String remark) {
        data.setStatus(status.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        cbIntentionDAO.update(data);
    }

    @Override
    public List<CbIntention> queryCbIntentionList(String positionCode,
            String resumeCode, String serviceCode) {
        CbIntention condition = new CbIntention();
        condition.setPositionCode(positionCode);
        condition.setResumeCode(resumeCode);
        condition.setServiceCode(serviceCode);
        return cbIntentionDAO.selectList(condition);
    }

    @Override
    public CbIntention getCbIntention(String code) {
        CbIntention data = null;
        if (StringUtils.isNotBlank(code)) {
            CbIntention condition = new CbIntention();
            condition.setCode(code);
            data = cbIntentionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "意向编号不存在");
            }
        }
        return data;
    }

    @Override
    public void dropCbIntention(String code) {
        if (StringUtils.isNotBlank(code)) {
            CbIntention data = new CbIntention();
            data.setCode(code);
            cbIntentionDAO.delete(data);
        }
    }
}
