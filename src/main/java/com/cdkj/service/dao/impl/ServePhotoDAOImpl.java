package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IServePhotoDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.ServePhoto;

@Repository("servePhotoDAOImpl")
public class ServePhotoDAOImpl extends AMybatisTemplate implements
        IServePhotoDAO {

    @Override
    public int insert(ServePhoto data) {
        return super.insert(NAMESPACE.concat("insert_servePhoto"), data);
    }

    @Override
    public int delete(ServePhoto data) {
        return super.delete(NAMESPACE.concat("delete_servePhoto"), data);
    }

    @Override
    public ServePhoto select(ServePhoto condition) {
        return super.select(NAMESPACE.concat("select_servePhoto"), condition,
            ServePhoto.class);
    }

    @Override
    public Long selectTotalCount(ServePhoto condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_servePhoto_count"), condition);
    }

    @Override
    public List<ServePhoto> selectList(ServePhoto condition) {
        return super.selectList(NAMESPACE.concat("select_servePhoto"),
            condition, ServePhoto.class);
    }

    @Override
    public List<ServePhoto> selectList(ServePhoto condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_servePhoto"), start,
            count, condition, ServePhoto.class);
    }

    @Override
    public int update(ServePhoto data) {
        return super.update(NAMESPACE.concat("update_servePhoto"), data);
    }
}
