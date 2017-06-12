package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeCpAO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeCpBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.dto.req.XN612124Req;
import com.cdkj.service.dto.req.XN612125Req;
import com.cdkj.service.exception.BizException;

@Service
public class ServeCpAOImpl implements IServeCpAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IGsQualifyBO gsQualifyBO;

    @Autowired
    private IQualifyBO qualifyBO;

    @Autowired
    private IServeCpBO serveCpBO;

    @Transactional
    @Override
    public String addServeCp(XN612124Req req) {
        GsQualify gsQualify = gsQualifyBO.getGsQualify(req.getQualityCode());
        Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
        String code = serveBO.saveServe(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(),
            StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getQualityCode(),
            req.getDescription(), req.getPublisher(), qualify.getCode());

        ServeCp data = new ServeCp();
        data.setServeCode(code);
        data.setCkNum(StringValidater.toInteger(req.getCkNum()));
        data.setCkArea(req.getCkArea());
        data.setGoodsKind(req.getGoodsKind());
        data.setDsendNum(StringValidater.toInteger(req.getDsendNum()));
        serveCpBO.saveServeCp(data);
        return code;
    }

    @Transactional
    @Override
    public void editServeCp(XN612125Req req) {
        Serve serve = serveBO.getServe(req.getCode());
        serveBO.refreshServe(serve, req.getName(), req.getPic(),
            req.getAdvPic(), StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getDescription(),
            req.getPublisher());
        ServeCp data = serveCpBO.getServeCp(req.getCode());
        data.setCkNum(StringValidater.toInteger(req.getCkNum()));
        data.setCkArea(req.getCkArea());
        data.setGoodsKind(req.getGoodsKind());
        data.setDsendNum(StringValidater.toInteger(req.getDsendNum()));
        serveCpBO.refreshServeCp(data);
    }

    @Override
    public void dropServeCp(String code) {
        if (!serveCpBO.isServeCpExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveCpBO.removeServeCp(code);
    }

    @Override
    public Paginable<ServeCp> queryServeCpPage(int start, int limit,
            ServeCp condition) {
        return serveCpBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ServeCp> queryServeCpList(ServeCp condition) {
        return serveCpBO.queryServeCpList(condition);
    }

    @Override
    public ServeCp getServeCp(String code) {
        return serveCpBO.getServeCp(code);
    }
}
