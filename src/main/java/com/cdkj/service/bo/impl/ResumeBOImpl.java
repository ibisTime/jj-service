package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IResumeBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IResumeDAO;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Component
public class ResumeBOImpl extends PaginableBOImpl<Resume> implements IResumeBO {

    @Autowired
    private IResumeDAO resumeDAO;

    @Override
    public boolean isResumeExist(String code) {
        Resume condition = new Resume();
        condition.setCode(code);
        if (resumeDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveResume(Resume data) {
        resumeDAO.insert(data);
    }

    @Override
    public void removeResume(String code) {
        if (StringUtils.isNotBlank(code)) {
            Resume data = new Resume();
            data.setCode(code);
            resumeDAO.delete(data);
        }
    }

    @Override
    public void refreshResume(Resume data) {
        resumeDAO.update(data);
    }

    @Override
    public void refreshResumeUseTime(String code) {
        if (StringUtils.isNotBlank(code)) {
            Resume data = new Resume();
            data.setCode(code);
            resumeDAO.updateUseTime(data);
        }
    }

    @Override
    public List<Resume> queryResumeList(String publisher, String status) {
        Resume condition = new Resume();
        condition.setPublisher(publisher);
        condition.setStatus(status);
        return resumeDAO.selectList(condition);
    }

    @Override
    public Resume getResume(String code) {
        Resume data = null;
        if (StringUtils.isNotBlank(code)) {
            Resume condition = new Resume();
            condition.setCode(code);
            data = resumeDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该简历不存在");
            }
        }
        return data;
    }

    @Override
    public void refreshResumeStatus(String code, String dealer, String dealNote) {
        Resume data = new Resume();
        data.setCode(code);
        data.setStatus(EBoolean.NO.getCode());
        data.setDealer(dealer);
        data.setDealNote(dealNote);
        data.setDealDatetime(new Date());
        resumeDAO.updateStatus(data);
    }
}
