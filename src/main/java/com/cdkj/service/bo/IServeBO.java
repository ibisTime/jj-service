package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Serve;

public interface IServeBO extends IPaginableBO<Serve> {

    public boolean isServeExist(String code);

    public String saveServe(Serve data);

    public int removeServe(String code);

    public int refreshServe(Serve data);

    public int refreshServeStatus(String code, String dealer, String dealNote);

    public int refreshServeHot(Serve data);

    public List<Serve> queryServeList(Serve condition);

    public Serve getServe(String code);

}
