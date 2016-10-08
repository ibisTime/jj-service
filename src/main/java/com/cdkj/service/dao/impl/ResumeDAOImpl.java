package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IResumeDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Resume;

@Repository("resumeDAOImpl")
public class ResumeDAOImpl extends AMybatisTemplate implements IResumeDAO {

    @Override
    public int insert(Resume data) {
        return super.insert(NAMESPACE.concat("insert_resume"), data);
    }

    @Override
    public int delete(Resume data) {
        return super.delete(NAMESPACE.concat("delete_resume"), data);
    }

    @Override
    public Resume select(Resume condition) {
        return super.select(NAMESPACE.concat("select_resume"), condition,
            Resume.class);
    }

    @Override
    public Long selectTotalCount(Resume condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_resume_count"),
            condition);
    }

    @Override
    public List<Resume> selectList(Resume condition) {
        return super.selectList(NAMESPACE.concat("select_resume"), condition,
            Resume.class);
    }

    @Override
    public List<Resume> selectList(Resume condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_resume"), start,
            count, condition, Resume.class);
    }

    @Override
    public int update(Resume data) {
        return super.update(NAMESPACE.concat("update_resume"), data);
    }

    @Override
    public int updateStatus(Resume data) {
        return super.update(NAMESPACE.concat("update_resume_status"), data);
    }
}
