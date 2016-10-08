package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IPositionDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Position;

@Repository("positionDAOImpl")
public class PositionDAOImpl extends AMybatisTemplate implements IPositionDAO {

    @Override
    public int insert(Position data) {
        return super.insert(NAMESPACE.concat("insert_position"), data);
    }

    @Override
    public int delete(Position data) {
        return super.delete(NAMESPACE.concat("delete_position"), data);
    }

    @Override
    public Position select(Position condition) {
        return super.select(NAMESPACE.concat("select_position"), condition,
            Position.class);
    }

    @Override
    public Long selectTotalCount(Position condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_position_count"), condition);
    }

    @Override
    public List<Position> selectList(Position condition) {
        return super.selectList(NAMESPACE.concat("select_position"), condition,
            Position.class);
    }

    @Override
    public List<Position> selectList(Position condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_position"), start,
            count, condition, Position.class);
    }

    @Override
    public int update(Position data) {
        return super.update(NAMESPACE.concat("update_position"), data);
    }

    @Override
    public int updateStatus(Position data) {
        return super.update(NAMESPACE.concat("update_position_status"), data);
    }

    @Override
    public int updateHot(Position data) {
        return super.update(NAMESPACE.concat("update_position_hot"), data);
    }
}
