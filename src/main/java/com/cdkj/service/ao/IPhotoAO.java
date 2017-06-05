package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Photo;

@Component
public interface IPhotoAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addPhoto(Photo data);

    public int dropPhoto(String code);

    public int editPhoto(Photo data);

    public Paginable<Photo> queryPhotoPage(int start, int limit, Photo condition);

    public List<Photo> queryPhotoList(Photo condition);

    public Photo getPhoto(String code);

}
