package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.ServeArt;

public interface IServeArtBO extends IPaginableBO<ServeArt> {

    public boolean isServeArtExist(String code);

    public String saveServeArt(ServeArt data);

    public int removeServeArt(String code);

    public int refreshServeArt(ServeArt data);

    public List<ServeArt> queryServeArtList(ServeArt condition);

    public ServeArt getServeArt(String code);

}
