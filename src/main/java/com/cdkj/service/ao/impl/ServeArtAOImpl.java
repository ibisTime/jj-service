package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeArtAO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.IServeArtBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.dto.req.XN612120Req;
import com.cdkj.service.dto.req.XN612121Req;
import com.cdkj.service.exception.BizException;

@Service
public class ServeArtAOImpl implements IServeArtAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeArtBO serveArtBO;

    @Autowired
    private IGsQualifyBO gsQualifyBO;

    @Autowired
    private IQualifyBO qualifyBO;

    @Transactional
    @Override
    public String addServeArt(XN612120Req req) {
        GsQualify gsQualify = gsQualifyBO.getGsQualify(req.getQualityCode());
        Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
        String code = serveBO.saveServe(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(),
            StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getQualityCode(),
            req.getDescription(), req.getPublisher(), qualify.getCode());
        ServeArt data = new ServeArt();
        data.setServeCode(code);
        data.setSclm(req.getSclm());
        data.setHomeDays(StringValidater.toInteger(req.getHomeDays()));
        data.setHomePrice(StringValidater.toLong(req.getHomePrice()));
        data.setDetailDays(StringValidater.toInteger(req.getDetailDays()));

        data.setDetailPrice(StringValidater.toLong(req.getDetailPrice()));
        data.setBannerDays(StringValidater.toInteger(req.getBannerDays()));
        data.setBannerPrice(StringValidater.toLong(req.getBannerPrice()));
        data.setAllDays(StringValidater.toInteger(req.getAllDays()));
        data.setAllPrice(StringValidater.toLong(req.getAllPrice()));

        data.setWorks(req.getWorks());
        data.setDesignNum(StringValidater.toInteger(req.getDesignNum()));
        serveArtBO.saveServeArt(data);
        return code;
    }

    @Transactional
    @Override
    public int editServeArt(XN612121Req req) {
        Serve serve = serveBO.getServe(req.getCode());
        serveBO.refreshServe(serve, req.getName(), req.getPic(),
            req.getAdvPic(), StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getDescription(),
            req.getPublisher());
        ServeArt data = serveArtBO.getServeArt(req.getCode());
        data.setDesignNum(StringValidater.toInteger(req.getDesignNum()));
        data.setSclm(req.getSclm());
        data.setHomeDays(StringValidater.toInteger(req.getHomeDays()));
        data.setHomePrice(StringValidater.toLong(req.getHomePrice()));

        data.setDetailDays(StringValidater.toInteger(req.getDetailDays()));
        data.setDetailPrice(StringValidater.toLong(req.getDetailPrice()));
        data.setBannerDays(StringValidater.toInteger(req.getBannerDays()));
        data.setBannerPrice(StringValidater.toLong(req.getBannerPrice()));
        data.setAllDays(StringValidater.toInteger(req.getAllDays()));

        data.setAllPrice(StringValidater.toLong(req.getAllPrice()));
        data.setWorks(req.getWorks());
        return serveArtBO.refreshServeArt(data);
    }

    @Override
    public int dropServeArt(String code) {
        if (!serveArtBO.isServeArtExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveArtBO.removeServeArt(code);
    }

    @Override
    public Paginable<ServeArt> queryServeArtPage(int start, int limit,
            ServeArt condition) {
        return serveArtBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ServeArt> queryServeArtList(ServeArt condition) {
        return serveArtBO.queryServeArtList(condition);
    }

    @Override
    public ServeArt getServeArt(String code) {
        return serveArtBO.getServeArt(code);
    }
}
