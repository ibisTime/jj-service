package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Serve;

public interface IServeBO extends IPaginableBO<Serve> {

    public boolean isServeExist(String code);

    public String saveServe(String name, String pic, String advPic,
            String companyCode, Long quoteMin, Long quoteMax,
            String qualityCode, String description, String publisher);

    public void removeServe(String code);

    public void refreshServe(Serve serve, String name, String pic,
            String advPic, Long quoteMin, Long quoteMax, String description,
            String publisher);

    public int refreshServeStatus(String code, String dealer, String dealNote);

    public int refreshServeHot(Serve data);

    public List<Serve> queryServeList(Serve condition);

    public Serve getServe(String code);

}
