package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Photo;
import com.cdkj.service.dto.req.XN612080Req;
import com.cdkj.service.dto.req.XN612082Req;

@Component
public interface IPhotoAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addPhoto(XN612080Req req);

    public void dropPhoto(String code);

    public void editPhoto(XN612082Req req);

    public Paginable<Photo> queryPhotoPage(int start, int limit, Photo condition);

    public List<Photo> queryPhotoList(Photo condition);

    public Photo getPhoto(String code);

    public void wgclPhoto(String code, String dealer, String dealNote);

    public void editLocation(String code, String location, String orderNo,
            String dealer);

}
