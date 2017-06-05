package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
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
    public void refreshQualify(String code, String type, String name,
            String description, String updater, String remark) {
        Qualify data = new Qualify();
        data.setCode(code);
        data.setType(type);
        data.setName(name);
        data.setDescription(description);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        qualifyDAO.update(data);
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
