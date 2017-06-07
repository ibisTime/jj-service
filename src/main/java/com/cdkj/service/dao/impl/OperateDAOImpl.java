package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IOperateDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Operate;

@Repository("operateDAOImpl")
public class OperateDAOImpl extends AMybatisTemplate implements IOperateDAO {

    @Override
    public int insert(Operate data) {
        return super.insert(NAMESPACE.concat("insert_operate"), data);
    }

    @Override
    public int delete(Operate data) {
        return super.delete(NAMESPACE.concat("delete_operate"), data);
    }

    @Override
    public Operate select(Operate condition) {
        return super.select(NAMESPACE.concat("select_operate"), condition,
            Operate.class);
    }

    @Override
    public Long selectTotalCount(Operate condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_operate_count"),
            condition);
    }

    @Override
    public List<Operate> selectList(Operate condition) {
        return super.selectList(NAMESPACE.concat("select_operate"), condition,
            Operate.class);
    }

    @Override
    public List<Operate> selectList(Operate condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_operate"), start,
            count, condition, Operate.class);
    }

    @Override
    public int update(Operate data) {
        return super.update(NAMESPACE.concat("update_operate"), data);
    }

    @Override
    public int wgclOperate(Operate data) {
        return super.update(NAMESPACE.concat("update_wg"), data);
    }

    @Override
    public int updateLocation(Operate data) {
        return super.update(NAMESPACE.concat("update_location"), data);
    }

}
