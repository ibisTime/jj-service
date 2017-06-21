package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IBcIntentionAO;
import com.cdkj.service.bo.IBcIntentionBO;
import com.cdkj.service.bo.IDemandBO;
import com.cdkj.service.bo.IResumeBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.domain.BcIntention;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.enums.EBoolean;

@Service
public class BcIntentionAOImpl implements IBcIntentionAO {

    @Autowired
    private IBcIntentionBO bcIntentionBO;

    @Autowired
    private IDemandBO demandBO;

    @Autowired
    private IResumeBO resumeBO;

    @Override
    public String addBcIntention(String type, String companyCode,
            String demandCode, String resumeCode, String submitter) {
        String gsUserId = null;
        Resume resume = null;
        Demand demand = null;
        if (type.equals(EBoolean.YES.getCode())) {
            demand = demandBO.getDemand(demandCode);
            gsUserId = demand.getPublisher();
        } else {
            resume = resumeBO.getResume(resumeCode);
            gsUserId = resume.getPublisher();
        }
        BcIntention data = new BcIntention();
        String code = OrderNoGenerater
            .generateM(EGeneratePrefix.BCYX.getCode());
        data.setCode(code);
        data.setType(type);
        data.setCompanyCode(companyCode);
        data.setDemandCode(demandCode);
        data.setResumeCode(resumeCode);
        data.setSubmitter(submitter);
        data.setSubmitDatetime(new Date());
        data.setGsUserId(gsUserId);
        bcIntentionBO.saveBcIntention(data);
        return code;
    }

    @Override
    public Paginable<BcIntention> queryBcIntentionPage(int start, int limit,
            BcIntention condition) {
        Paginable<BcIntention> page = bcIntentionBO.getPaginable(start, limit,
            condition);
        List<BcIntention> listBcIntention = page.getList();
        for (BcIntention bcIntention : listBcIntention) {
            Resume resume = null;
            Demand demand = null;
            if (bcIntention.getType().equals(EBoolean.YES.getCode())) {
                demand = demandBO.getDemand(bcIntention.getDemandCode());
                bcIntention.setXqName(demand.getName());
            } else {
                resume = resumeBO.getResume(bcIntention.getResumeCode());
                bcIntention.setJlName(resume.getName());
            }
        }
        return page;
    }

    @Override
    public List<BcIntention> queryBcIntentionList(BcIntention condition) {
        return bcIntentionBO.queryBcIntentionList(condition);
    }

    @Override
    public BcIntention getBcIntention(String code) {
        BcIntention bcIntention = bcIntentionBO.getBcIntention(code);
        Resume resume = null;
        Demand demand = null;
        if (bcIntention.getType().equals(EBoolean.YES.getCode())) {
            demand = demandBO.getDemand(bcIntention.getDemandCode());
            bcIntention.setXqName(demand.getName());
        } else {
            resume = resumeBO.getResume(bcIntention.getResumeCode());
            bcIntention.setJlName(resume.getName());
        }
        return bcIntention;
    }
}
