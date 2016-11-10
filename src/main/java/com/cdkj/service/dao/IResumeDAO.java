package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Resume;

public interface IResumeDAO extends IBaseDAO<Resume> {
    String NAMESPACE = IResumeDAO.class.getName().concat(".");

    public int updateStatus(Resume data);

    public int updateUseTime(Resume data);
}
