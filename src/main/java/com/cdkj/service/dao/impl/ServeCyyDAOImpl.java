package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServeCyyDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.ServeCyy;

@Repository("serveCyyDAOImpl")
public class ServeCyyDAOImpl extends AMybatisTemplate implements IServeCyyDAO {

    @Override
    public int insert(ServeCyy data) {
        return super.insert(NAMESPACE.concat("insert_serveCyy"), data);
    }

    @Override
    public int delete(ServeCyy data) {
        return super.delete(NAMESPACE.concat("delete_serveCyy"), data);
    }

    @Override
    public ServeCyy select(ServeCyy condition) {
        return super.select(NAMESPACE.concat("select_serveCyy"), condition,
            ServeCyy.class);
    }

    @Override
    public Long selectTotalCount(ServeCyy condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_serveCyy_count"), condition);
    }

    @Override
    public List<ServeCyy> selectList(ServeCyy condition) {
        return super.selectList(NAMESPACE.concat("select_serveCyy"), condition,
            ServeCyy.class);
    }

    @Override
    public List<ServeCyy> selectList(ServeCyy condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_serveCyy"), start,
            count, condition, ServeCyy.class);
    }

    @Override
    public int update(ServeCyy data) {
        return super.update(NAMESPACE.concat("update_serveCyy"), data);
    }
}
