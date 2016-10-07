package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServePhoto;

public interface IServePhotoAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addServePhoto(ServePhoto data);

    public int dropServePhoto(String code);

    public int editServePhoto(ServePhoto data);

    public Paginable<ServePhoto> queryServePhotoPage(int start, int limit,
            ServePhoto condition);

    public List<ServePhoto> queryServePhotoList(ServePhoto condition);

    public ServePhoto getServePhoto(String code);

}
