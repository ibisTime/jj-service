package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeKfwbAO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeKfwbBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.dto.req.XN612122Req;
import com.cdkj.service.dto.req.XN612123Req;
import com.cdkj.service.exception.BizException;

@Service
public class ServeKfwbAOImpl implements IServeKfwbAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeKfwbBO serveKfwbBO;

    @Transactional
    @Override
    public String addServeKfwb(XN612122Req req) {
        String code = serveBO.saveServe(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(),
            StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getQualityCode(),
            req.getDescription(), req.getPublisher());

        ServeKfwb data = new ServeKfwb();
        data.setServeCode(code);
        data.setKfNum(StringValidater.toInteger(req.getKfNum()));
        data.setMtradeAmount(req.getMtradeAmount());
        data.setBusiness(req.getBusiness());
        data.setFeeMode(req.getFeeMode());
        serveKfwbBO.saveServeKfwb(data);
        return code;
    }

    @Transactional
    @Override
    public void editServeKfwb(XN612123Req req) {
        Serve serve = serveBO.getServe(req.getCode());
        serveBO.refreshServe(serve, req.getName(), req.getPic(),
            req.getAdvPic(), StringValidater.toLong(req.getQuoteMin()),
            StringValidater.toLong(req.getQuoteMax()), req.getDescription(),
            req.getPublisher());
        ServeKfwb data = serveKfwbBO.getServeKfwb(req.getCode());
        data.setKfNum(StringValidater.toInteger(req.getKfNum()));
        data.setMtradeAmount(req.getMtradeAmount());
        data.setBusiness(req.getBusiness());
        data.setFeeMode(req.getFeeMode());
        serveKfwbBO.refreshServeKfwb(data);
    }

    @Override
    public void dropServeKfwb(String code) {
        if (!serveKfwbBO.isServeKfwbExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveKfwbBO.removeServeKfwb(code);
    }

    @Override
    public Paginable<ServeKfwb> queryServeKfwbPage(int start, int limit,
            ServeKfwb condition) {
        return serveKfwbBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ServeKfwb> queryServeKfwbList(ServeKfwb condition) {
        return serveKfwbBO.queryServeKfwbList(condition);
    }

    @Override
    public ServeKfwb getServeKfwb(String code) {
        return serveKfwbBO.getServeKfwb(code);
    }
}
