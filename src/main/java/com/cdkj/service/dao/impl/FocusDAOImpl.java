package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IFocusDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Focus;

@Repository("focusDAOImpl")
public class FocusDAOImpl extends AMybatisTemplate implements IFocusDAO {

    @Override
    public int insert(Focus data) {
        return super.insert(NAMESPACE.concat("insert_focus"), data);
    }

    @Override
    public int delete(Focus data) {
        return super.delete(NAMESPACE.concat("delete_focus"), data);
    }

    @Override
    public Focus select(Focus condition) {
        return super.select(NAMESPACE.concat("select_focus"), condition,
            Focus.class);
    }

    @Override
    public Long selectTotalCount(Focus condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_focus_count"),
            condition);
    }

    @Override
    public List<Focus> selectList(Focus condition) {
        return super.selectList(NAMESPACE.concat("select_focus"), condition,
            Focus.class);
    }

    @Override
    public List<Focus> selectList(Focus condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_focus"), start, count,
            condition, Focus.class);
    }

    @Override
    public int update(Focus data) {
        return super.update(NAMESPACE.concat("update_focus"), data);
    }

}
