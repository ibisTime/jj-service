package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Photo;

public interface IPhotoBO extends IPaginableBO<Photo> {

    public boolean isPhotoExist(String code);

    public void savePhoto(Photo data);

    public void removePhoto(String code);

    public void refreshPhoto(Photo data);

    public List<Photo> queryPhotoList(Photo condition);

    public Photo getPhoto(String code);

    public void wgclPhoto(Photo photo, String dealer, String dealNote);

    public List<Photo> queryPhotoList(String status, String location,
            String orderNo);

    public void refreshLocation(Photo photo, String location, String orderNo,
            String dealer);

}
