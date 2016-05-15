package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Project;

public interface IProjectDAO extends IBaseDAO<Project> {
    String NAMESPACE = IProjectDAO.class.getName().concat(".");

    public int updateLoanedAmount(Project data);

    public int refreshStatus(Project project);

    public int reapplyProject(Project data);

    public int checkUnpass(Project data);

    public int checkPass(Project data);

    public int forbidProject(Project data);

}
