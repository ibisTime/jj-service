package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.ServePhoto;

public interface IServePhotoBO extends IPaginableBO<ServePhoto> {

    public boolean isServePhotoExist(String code);

    public String saveServePhoto(ServePhoto data);

    public int removeServePhoto(String code);

    public int refreshServePhoto(ServePhoto data);

    public List<ServePhoto> queryServePhotoList(ServePhoto condition);

    public ServePhoto getServePhoto(String code);

}
