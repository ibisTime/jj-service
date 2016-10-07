package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServeKfwbDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.ServeKfwb;

@Repository("serveKfwbDAOImpl")
public class ServeKfwbDAOImpl extends AMybatisTemplate implements IServeKfwbDAO {

    @Override
    public int insert(ServeKfwb data) {
        return super.insert(NAMESPACE.concat("insert_serveKfwb"), data);
    }

    @Override
    public int delete(ServeKfwb data) {
        return super.delete(NAMESPACE.concat("delete_serveKfwb"), data);
    }

    @Override
    public ServeKfwb select(ServeKfwb condition) {
        return super.select(NAMESPACE.concat("select_serveKfwb"), condition,
            ServeKfwb.class);
    }

    @Override
    public Long selectTotalCount(ServeKfwb condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_serveKfwb_count"), condition);
    }

    @Override
    public List<ServeKfwb> selectList(ServeKfwb condition) {
        return super.selectList(NAMESPACE.concat("select_serveKfwb"),
            condition, ServeKfwb.class);
    }

    @Override
    public List<ServeKfwb> selectList(ServeKfwb condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_serveKfwb"), start,
            count, condition, ServeKfwb.class);
    }

    @Override
    public int update(ServeKfwb data) {
        return super.update(NAMESPACE.concat("update_serveKfwb"), data);
    }
}
