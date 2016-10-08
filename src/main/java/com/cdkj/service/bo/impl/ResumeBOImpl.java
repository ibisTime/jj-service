package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IResumeBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
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
    public String saveResume(Resume data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.JL.getCode());
            data.setCode(code);
            data.setStatus(EBoolean.YES.getCode());
            data.setPublishDatetime(new Date());
            data.setUseTimes(0);
            resumeDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeResume(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Resume data = new Resume();
            data.setCode(code);
            count = resumeDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshResume(Resume data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setPublishDatetime(new Date());
            count = resumeDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Resume> queryResumeList(Resume condition) {
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
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }

    @Override
    public int refreshResumeStatus(String code, String dealer, String dealNote) {
        Resume data = new Resume();
        data.setCode(code);
        data.setStatus(EBoolean.NO.getCode());
        data.setDealer(dealer);
        data.setDealNote(dealNote);
        data.setDealDatetime(new Date());
        return resumeDAO.updateStatus(data);
    }
}
