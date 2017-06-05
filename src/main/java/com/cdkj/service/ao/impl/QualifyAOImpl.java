package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IQualifyAO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Qualify;

@Service
public class QualifyAOImpl implements IQualifyAO {

    @Autowired
    private IQualifyBO qualifyBO;

    @Override
    public void editQualify(String code, String type, String name,
            String description, String updater, String remark) {
        qualifyBO.getQualify(code);
        qualifyBO
            .refreshQualify(code, type, name, description, updater, remark);
    }

    @Override
    public Paginable<Qualify> queryQualifyPage(int start, int limit,
            Qualify condition) {
        return qualifyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Qualify> queryQualifyList(Qualify condition) {
        return qualifyBO.queryQualifyList(condition);
    }

    @Override
    public Qualify getQualify(String code) {
        return qualifyBO.getQualify(code);
    }
}
