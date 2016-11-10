package com.cdkj.service.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IResumeAO;
import com.cdkj.service.bo.IResumeBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.dto.res.XN805901Res;
import com.cdkj.service.exception.BizException;

@Service
public class ResumeAOImpl implements IResumeAO {

    @Autowired
    private IResumeBO resumeBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Override
    public String addResume(Resume data) {
        return resumeBO.saveResume(data);
    }

    @Override
    public int editResume(Resume data) {
        if (!resumeBO.isResumeExist(data.getCode())) {
            throw new BizException("xn0000", "简历不存在");
        }
        return resumeBO.refreshResume(data);
    }

    @Override
    public int dropResume(String code) {
        if (!resumeBO.isResumeExist(code)) {
            throw new BizException("xn0000", "简历不存在");
        }
        return resumeBO.removeResume(code);
    }

    @Override
    public Paginable<Resume> queryResumePage(int start, int limit,
            Resume condition) {
        String expPosition = condition.getExpPosition();
        if (StringUtils.isNotBlank(expPosition)) {
            List<String> expPositionList = new ArrayList<String>();
            for (int i = 0; i < expPosition.length(); i++) {
                expPositionList.add(expPosition.substring(i, i + 1));
            }
            condition.setExpPositionList(expPositionList);
        }
        return resumeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Resume> queryResumeList(Resume condition) {
        return resumeBO.queryResumeList(condition);
    }

    @Override
    public Resume getResume(String code) {
        Resume resume = resumeBO.getResume(code);
        XN805901Res res = userBO.getRemoteUser(resume.getPublisher(),
            resume.getPublisher());
        resume.setUser(res);
        return resume;
    }

    @Override
    public int editResumeStatus(String code, String dealer, String dealNote) {
        Resume resume = resumeBO.getResume(code);
        String publisher = resume.getPublisher();
        smsOutBO.sentContent(publisher, publisher,
            "尊敬的用户，您所发布的简历[" + resume.getName() + "]已做违规处理，违规原因[" + dealNote
                    + "]。");
        return resumeBO.refreshResumeStatus(code, dealer, dealNote);
    }
}
