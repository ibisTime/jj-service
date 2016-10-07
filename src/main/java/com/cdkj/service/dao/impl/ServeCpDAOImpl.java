package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServeCpDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.ServeCp;

@Repository("serveCpDAOImpl")
public class ServeCpDAOImpl extends AMybatisTemplate implements IServeCpDAO {

    @Override
    public int insert(ServeCp data) {
        return super.insert(NAMESPACE.concat("insert_serveCp"), data);
    }

    @Override
    public int delete(ServeCp data) {
        return super.delete(NAMESPACE.concat("delete_serveCp"), data);
    }

    @Override
    public ServeCp select(ServeCp condition) {
        return super.select(NAMESPACE.concat("select_serveCp"), condition,
            ServeCp.class);
    }

    @Override
    public Long selectTotalCount(ServeCp condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_serveCp_count"),
            condition);
    }

    @Override
    public List<ServeCp> selectList(ServeCp condition) {
        return super.selectList(NAMESPACE.concat("select_serveCp"), condition,
            ServeCp.class);
    }

    @Override
    public List<ServeCp> selectList(ServeCp condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_serveCp"), start,
            count, condition, ServeCp.class);
    }

    @Override
    public int update(ServeCp data) {
        return super.update(NAMESPACE.concat("update_serveCp"), data);
    }
}
