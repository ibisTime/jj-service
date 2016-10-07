package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServeArtDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.ServeArt;

@Repository("serveArtDAOImpl")
public class ServeArtDAOImpl extends AMybatisTemplate implements IServeArtDAO {

    @Override
    public int insert(ServeArt data) {
        return super.insert(NAMESPACE.concat("insert_serveArt"), data);
    }

    @Override
    public int delete(ServeArt data) {
        return super.delete(NAMESPACE.concat("delete_serveArt"), data);
    }

    @Override
    public ServeArt select(ServeArt condition) {
        return super.select(NAMESPACE.concat("select_serveArt"), condition,
            ServeArt.class);
    }

    @Override
    public Long selectTotalCount(ServeArt condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_serveArt_count"), condition);
    }

    @Override
    public List<ServeArt> selectList(ServeArt condition) {
        return super.selectList(NAMESPACE.concat("select_serveArt"), condition,
            ServeArt.class);
    }

    @Override
    public List<ServeArt> selectList(ServeArt condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_serveArt"), start,
            count, condition, ServeArt.class);
    }

    @Override
    public int update(ServeArt data) {
        return super.update(NAMESPACE.concat("update_serveArt"), data);
    }
}
