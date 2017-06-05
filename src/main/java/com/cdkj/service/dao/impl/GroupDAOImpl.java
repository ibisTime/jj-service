package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IGroupDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Group;

@Repository("groupDAOImpl")
public class GroupDAOImpl extends AMybatisTemplate implements IGroupDAO {

    @Override
    public int insert(Group data) {
        return super.insert(NAMESPACE.concat("insert_group"), data);
    }

    @Override
    public int delete(Group data) {
        return super.delete(NAMESPACE.concat("delete_group"), data);
    }

    @Override
    public Group select(Group condition) {
        return super.select(NAMESPACE.concat("select_group"), condition,
            Group.class);
    }

    @Override
    public Long selectTotalCount(Group condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_group_count"),
            condition);
    }

    @Override
    public List<Group> selectList(Group condition) {
        return super.selectList(NAMESPACE.concat("select_group"), condition,
            Group.class);
    }

    @Override
    public List<Group> selectList(Group condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_group"), start, count,
            condition, Group.class);
    }

    @Override
    public int update(Group data) {
        return super.update(NAMESPACE.concat("update_group"), data);
    }

    @Override
    public int updateFocusNum(Group data) {
        return super.update(NAMESPACE.concat("update_focus_num"), data);
    }

}
