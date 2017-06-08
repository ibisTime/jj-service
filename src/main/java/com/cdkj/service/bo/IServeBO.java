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

    public void refreshServeStatus(Serve serve, String dealer, String dealNote);

    public void refreshLocation(Serve data, String location, String orderNo,
            String dealer);

    public List<Serve> queryServeList(Serve condition);

    public Serve getServe(String code);

    public List<Serve> queryServeList(String status, String location,
            String orderNo);

}
