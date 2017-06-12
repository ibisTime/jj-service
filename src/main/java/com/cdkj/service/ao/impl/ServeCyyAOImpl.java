package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeCyyAO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeCyyBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.dto.req.XN612128Req;
import com.cdkj.service.dto.req.XN612129Req;
import com.cdkj.service.exception.BizException;

@Service
public class ServeCyyAOImpl implements IServeCyyAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeCyyBO serveCyyBO;

    @Autowired
    private IQualifyBO qualifyBO;

    @Autowired
    private IGsQualifyBO gsQualifyBO;

    @Transactional
    @Override
    public String addServeCyy(XN612128Req req) {
        GsQualify gsQualify = gsQualifyBO.getGsQualify(req.getQualityCode());
        Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
        String code = serveBO.saveServe(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(),
            StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getQualityCode(),
            req.getDescription(), req.getPublisher(), qualify.getCode());

        ServeCyy data = new ServeCyy();
        data.setServeCode(code);
        data.setBgArea(StringValidater.toLong(req.getBgArea()));
        data.setAvailBgArea(StringValidater.toLong(req.getAvailBgArea()));
        data.setCcArea(StringValidater.toLong(req.getCcArea()));
        data.setAvailCcArea(StringValidater.toLong(req.getAvailCcArea()));

        data.setZzfw(req.getZzfw());
        data.setIntroduce(req.getIntroduce());
        data.setYhPolicy(req.getYhPolicy());
        data.setPic1(req.getPic1());
        data.setPic2(req.getPic2());
        serveCyyBO.saveServeCyy(data);
        return code;
    }

    @Transactional
    @Override
    public void editServeCyy(XN612129Req req) {
        Serve serve = serveBO.getServe(req.getCode());
        serveBO.refreshServe(serve, req.getName(), req.getPic(),
            req.getAdvPic(), StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getDescription(),
            req.getPublisher());
        ServeCyy data = new ServeCyy();
        data.setServeCode(req.getCode());
        data.setBgArea(StringValidater.toLong(req.getBgArea()));
        data.setAvailBgArea(StringValidater.toLong(req.getAvailBgArea()));
        data.setCcArea(StringValidater.toLong(req.getCcArea()));
        data.setAvailCcArea(StringValidater.toLong(req.getAvailCcArea()));
        data.setZzfw(req.getZzfw());
        data.setIntroduce(req.getIntroduce());
        data.setYhPolicy(req.getYhPolicy());
        data.setPic1(req.getPic1());
        data.setPic2(req.getPic2());
        serveCyyBO.refreshServeCyy(data);
    }

    @Override
    public void dropServeCyy(String code) {
        if (!serveCyyBO.isServeCyyExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveCyyBO.removeServeCyy(code);
    }

    @Override
    public Paginable<ServeCyy> queryServeCyyPage(int start, int limit,
            ServeCyy condition) {
        return serveCyyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ServeCyy> queryServeCyyList(ServeCyy condition) {
        return serveCyyBO.queryServeCyyList(condition);
    }

    @Override
    public ServeCyy getServeCyy(String code) {
        return serveCyyBO.getServeCyy(code);
    }
}
