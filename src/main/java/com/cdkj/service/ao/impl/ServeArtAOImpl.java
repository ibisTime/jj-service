package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeArtAO;
import com.cdkj.service.bo.IServeArtBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.exception.BizException;

@Service
public class ServeArtAOImpl implements IServeArtAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeArtBO serveArtBO;

    @Transactional
    @Override
    public String addServeArt(ServeArt data) {
        String code = serveBO.saveServe(data.getServe());
        data.setServeCode(code);
        serveArtBO.saveServeArt(data);
        return code;
    }

    @Transactional
    @Override
    public int editServeArt(ServeArt data) {
        if (!serveArtBO.isServeArtExist(data.getServeCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveBO.refreshServe(data.getServe());
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
