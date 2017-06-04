package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IQualifyDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Qualify;

@Repository("qualifyDAOImpl")
public class QualifyDAOImpl extends AMybatisTemplate implements IQualifyDAO {

    @Override
    public int insert(Qualify data) {
        return super.insert(NAMESPACE.concat("insert_qualify"), data);
    }

    @Override
    public int delete(Qualify data) {
        return super.delete(NAMESPACE.concat("delete_qualify"), data);
    }

    @Override
    public Qualify select(Qualify condition) {
        return super.select(NAMESPACE.concat("select_qualify"), condition,
            Qualify.class);
    }

    @Override
    public Long selectTotalCount(Qualify condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_qualify_count"),
            condition);
    }

    @Override
    public List<Qualify> selectList(Qualify condition) {
        return super.selectList(NAMESPACE.concat("select_qualify"), condition,
            Qualify.class);
    }

    @Override
    public List<Qualify> selectList(Qualify condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_qualify"), start,
            count, condition, Qualify.class);
    }

    @Override
    public int update(Qualify data) {
        return super.update(NAMESPACE.concat("update_qualify"), data);
    }

}
