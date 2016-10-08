package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServeDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Serve;

@Repository("serveDAOImpl")
public class ServeDAOImpl extends AMybatisTemplate implements IServeDAO {

    @Override
    public int insert(Serve data) {
        return super.insert(NAMESPACE.concat("insert_serve"), data);
    }

    @Override
    public int delete(Serve data) {
        return super.delete(NAMESPACE.concat("delete_serve"), data);
    }

    @Override
    public Serve select(Serve condition) {
        return super.select(NAMESPACE.concat("select_serve"), condition,
            Serve.class);
    }

    @Override
    public Long selectTotalCount(Serve condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_serve_count"),
            condition);
    }

    @Override
    public List<Serve> selectList(Serve condition) {
        return super.selectList(NAMESPACE.concat("select_serve"), condition,
            Serve.class);
    }

    @Override
    public List<Serve> selectList(Serve condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_serve"), start, count,
            condition, Serve.class);
    }

    @Override
    public int update(Serve data) {
        return super.update(NAMESPACE.concat("update_serve"), data);
    }

    @Override
    public int updateStatus(Serve data) {
        return super.update(NAMESPACE.concat("update_serve_status"), data);
    }

    @Override
    public int updateHot(Serve data) {
        return super.update(NAMESPACE.concat("update_serve_hot"), data);
    }
}
