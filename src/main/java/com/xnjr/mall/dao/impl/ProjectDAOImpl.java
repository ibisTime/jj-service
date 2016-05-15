package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IProjectDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Project;

@Repository("projectDAOImpl")
public class ProjectDAOImpl extends AMybatisTemplate implements IProjectDAO {

    @Override
    public int insert(Project data) {
        return super.insert("insert_project", data);
    }

    @Override
    public int delete(Project data) {
        return 0;
    }

    @Override
    public Project select(Project condition) {
        return super.select("select_project", condition, Project.class);
    }

    @Override
    public Long selectTotalCount(Project condition) {
        return super.selectTotalCount("select_project_count", condition);
    }

    @Override
    public List<Project> selectList(Project condition) {
        return super.selectList("select_project", condition, Project.class);
    }

    @Override
    public List<Project> selectList(Project condition, int start, int count) {
        return super.selectList("select_project", start, count, condition,
            Project.class);
    }

    @Override
    public int updateLoanedAmount(Project data) {
        return super.update(NAMESPACE.concat("update_loanedAmountProject"),
            data);
    }

    @Override
    public int refreshStatus(Project project) {
        return super.update("update_statusProject", project);
    }

    @Override
    public int reapplyProject(Project data) {
        return super.update("update_reapplyProject", data);
    }

    public int checkUnpass(Project data) {
        return super.update("update_checkUnpassProject", data);
    }

    @Override
    public int checkPass(Project data) {
        return super.update("update_checkPassProject", data);
    }

    @Override
    public int forbidProject(Project data) {
        return super.update("update_forbidProject", data);
    }
}
