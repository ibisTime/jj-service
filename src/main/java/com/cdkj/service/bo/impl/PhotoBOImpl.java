package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IPhotoBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IPhotoDAO;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.exception.BizException;

@Component
public class PhotoBOImpl extends PaginableBOImpl<Photo> implements IPhotoBO {

    @Autowired
    private IPhotoDAO photoDAO;

    @Override
    public boolean isPhotoExist(String code) {
        Photo condition = new Photo();
        condition.setCode(code);
        if (photoDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void savePhoto(Photo data) {
        photoDAO.insert(data);
    }

    @Override
    public void removePhoto(String code) {
        if (StringUtils.isNotBlank(code)) {
            Photo data = new Photo();
            data.setCode(code);
            photoDAO.delete(data);
        }
    }

    @Override
    public void refreshPhoto(Photo data) {
        photoDAO.update(data);
    }

    @Override
    public List<Photo> queryPhotoList(Photo condition) {
        return photoDAO.selectList(condition);
    }

    @Override
    public Photo getPhoto(String code) {
        Photo data = null;
        if (StringUtils.isNotBlank(code)) {
            Photo condition = new Photo();
            condition.setCode(code);
            data = photoDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "不存在该服务");
            }
        }
        return data;
    }

    @Override
    public void wgclPhoto(Photo photo, String dealer, String dealNote) {
        photo.setDealer(dealer);
        photo.setDealDatetime(new Date());
        photo.setDealNote(dealNote);
        photoDAO.wgclPhoto(photo);
    }

    @Override
    public List<Photo> queryPhotoList(String status, String location,
            String orderNo) {
        Photo condition = new Photo();
        condition.setStatus(status);
        condition.setLocation(location);
        condition.setOrderNo(orderNo);
        return photoDAO.selectList(condition);
    }

    @Override
    public void refreshLocation(Photo photo, String location, String orderNo,
            String dealer) {
        photo.setLocation(location);
        photo.setOrderNo(orderNo);
        photo.setDealer(dealer);
        photo.setDealDatetime(new Date());
        photoDAO.updateLocation(photo);
    }
}
