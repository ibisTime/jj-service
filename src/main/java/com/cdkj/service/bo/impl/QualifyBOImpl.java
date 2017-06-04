package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IQualifyDAO;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.exception.BizException;

@Component
public class QualifyBOImpl extends PaginableBOImpl<Qualify> implements
        IQualifyBO {

    @Autowired
    private IQualifyDAO qualifyDAO;

    @Override
    public boolean isQualifyExist(String code) {
        Qualify condition = new Qualify();
        condition.setCode(code);
        if (qualifyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveQualify(Qualify data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generateM(EGeneratePrefix.QUALIFY.getCode());
            data.setCode(code);
            qualifyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeQualify(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Qualify data = new Qualify();
            data.setCode(code);
            count = qualifyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshQualify(Qualify data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = qualifyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Qualify> queryQualifyList(Qualify condition) {
        return qualifyDAO.selectList(condition);
    }

    @Override
    public Qualify getQualify(String code) {
        Qualify data = null;
        if (StringUtils.isNotBlank(code)) {
            Qualify condition = new Qualify();
            condition.setCode(code);
            data = qualifyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
