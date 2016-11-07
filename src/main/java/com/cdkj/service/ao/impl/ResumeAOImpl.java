package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IResumeAO;
import com.cdkj.service.bo.IResumeBO;
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

    @Override
    public String addResume(Resume data) {
        return resumeBO.saveResume(data);
    }

    @Override
    public int editResume(Resume data) {
        if (!resumeBO.isResumeExist(data.getCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return resumeBO.refreshResume(data);
    }

    @Override
    public int dropResume(String code) {
        if (!resumeBO.isResumeExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return resumeBO.removeResume(code);
    }

    @Override
    public Paginable<Resume> queryResumePage(int start, int limit,
            Resume condition) {
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
        if (!resumeBO.isResumeExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return resumeBO.refreshResumeStatus(code, dealer, dealNote);
    }
}
