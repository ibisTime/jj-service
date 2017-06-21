package com.cdkj.service.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IResumeAO;
import com.cdkj.service.bo.IResumeBO;
import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.domain.User;
import com.cdkj.service.dto.req.XN612180Req;
import com.cdkj.service.dto.req.XN612182Req;
import com.cdkj.service.dto.res.XN612186Res;
import com.cdkj.service.enums.EBoolean;
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
    public String addResume(XN612180Req req) {
        Resume data = new Resume();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.JL.getCode());
        data.setCode(code);
        data.setName(req.getName());
        data.setIsWork(req.getIsWork());
        data.setPreCompName(req.getPreCompName());
        data.setPrePosName(req.getPrePosName());

        data.setPreWorkTime(req.getPreWorkTime());
        data.setPreMsalary(req.getPreMsalary());
        data.setPreDescription(req.getPreDescription());
        data.setEducation(req.getEducation());
        data.setIsTz(req.getIsTz());

        data.setStudyTime(req.getStudyTime());
        data.setSchool(req.getSchool());
        data.setProfession(req.getProfession());
        data.setType(req.getType());
        data.setExpPosition(req.getExpPosition());

        data.setExpMsalary(req.getExpMsalary());
        data.setExpProvince(req.getExpProvince());
        data.setExpCity(req.getExpCity());
        data.setWorkStatus(req.getWorkStatus());
        data.setIsOpen(req.getIsOpen());

        data.setUseTimes(0);
        data.setLocation(EBoolean.NO.getCode());
        data.setOrderNo(0);
        data.setStatus(EBoolean.YES.getCode());
        data.setPublisher(req.getPublisher());

        data.setPublishDatetime(new Date());
        resumeBO.saveResume(data);
        return code;
    }

    @Override
    public void editResume(XN612182Req req) {
        resumeBO.getResume(req.getCode());
        Resume data = new Resume();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setIsWork(req.getIsWork());
        data.setPreCompName(req.getPreCompName());
        data.setPrePosName(req.getPrePosName());

        data.setPreWorkTime(req.getPreWorkTime());
        data.setPreMsalary(req.getPreMsalary());
        data.setPreDescription(req.getPreDescription());
        data.setEducation(req.getEducation());
        data.setIsTz(req.getIsTz());

        data.setStudyTime(req.getStudyTime());
        data.setSchool(req.getSchool());
        data.setProfession(req.getProfession());
        data.setType(req.getType());
        data.setExpPosition(req.getExpPosition());

        data.setExpMsalary(req.getExpMsalary());
        data.setExpProvince(req.getExpProvince());
        data.setExpCity(req.getExpCity());
        data.setWorkStatus(req.getWorkStatus());
        data.setIsOpen(req.getIsOpen());

        data.setPublisher(req.getPublisher());
        data.setPublishDatetime(new Date());
        resumeBO.refreshResume(data);
    }

    @Override
    public void dropResume(String code) {
        if (!resumeBO.isResumeExist(code)) {
            throw new BizException("xn0000", "简历不存在");
        }
        resumeBO.removeResume(code);
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
        Paginable<Resume> page = resumeBO.getPaginable(start, limit, condition);
        List<Resume> resumeList = page.getList();
        for (Resume resume : resumeList) {
            User user = userBO.getRemoteUser(resume.getPublisher());
            resume.setRealName(user.getNickname());
        }
        return page;
    }

    @Override
    public List<Resume> queryResumeList(String publisher, String status) {
        return resumeBO.queryResumeList(publisher, status);
    }

    @Override
    public XN612186Res getResume(String code) {
        Resume resume = resumeBO.getResume(code);
        User user = userBO.getRemoteUser(resume.getPublisher());
        XN612186Res res = new XN612186Res();
        res.setResume(resume);
        res.setUser(user);
        return res;
    }

    @Override
    public void editResumeStatus(String code, String dealer, String dealNote) {
        Resume resume = resumeBO.getResume(code);
        String publisher = resume.getPublisher();
        smsOutBO.sentContent(publisher, "尊敬的用户，您所发布的简历[" + resume.getName()
                + "]已做违规处理，违规原因[" + dealNote + "]。");
        resumeBO.refreshResumeStatus(code, dealer, dealNote);
    }
}
