package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IPhotoDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Photo;

@Repository("photoDAOImpl")
public class PhotoDAOImpl extends AMybatisTemplate implements IPhotoDAO {

    @Override
    public int insert(Photo data) {
        return super.insert(NAMESPACE.concat("insert_photo"), data);
    }

    @Override
    public int delete(Photo data) {
        return super.delete(NAMESPACE.concat("delete_photo"), data);
    }

    @Override
    public Photo select(Photo condition) {
        return super.select(NAMESPACE.concat("select_photo"), condition,
            Photo.class);
    }

    @Override
    public Long selectTotalCount(Photo condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_photo_count"),
            condition);
    }

    @Override
    public List<Photo> selectList(Photo condition) {
        return super.selectList(NAMESPACE.concat("select_photo"), condition,
            Photo.class);
    }

    @Override
    public List<Photo> selectList(Photo condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_photo"), start, count,
            condition, Photo.class);
    }

    @Override
    public int update(Photo data) {
        return super.update(NAMESPACE.concat("update_photo"), data);
    }

    @Override
    public int wgclPhoto(Photo data) {
        return super.update(NAMESPACE.concat("update_photo_wg"), data);
    }

    @Override
    public int updateLocation(Photo data) {
        return super.update(NAMESPACE.concat("update_location"), data);
    }

}
