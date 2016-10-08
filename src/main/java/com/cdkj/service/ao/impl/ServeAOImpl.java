package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.bo.IServeArtBO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeCpBO;
import com.cdkj.service.bo.IServeCyyBO;
import com.cdkj.service.bo.IServeKfwbBO;
import com.cdkj.service.bo.IServePhotoBO;
import com.cdkj.service.bo.IServeShopBO;
import com.cdkj.service.bo.IServeTrainBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.exception.BizException;

@Service
public class ServeAOImpl implements IServeAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeArtBO serveArtBO;

    @Autowired
    private IServeCpBO serveCpBO;

    @Autowired
    private IServeCyyBO serveCyyBO;

    @Autowired
    private IServeKfwbBO serveKfwbBO;

    @Autowired
    private IServePhotoBO servePhotoBO;

    @Autowired
    private IServeShopBO serveShopBO;

    @Autowired
    private IServeTrainBO serveTrainBO;

    @Override
    public String addServe(Serve data) {
        return serveBO.saveServe(data);
    }

    @Override
    public int editServe(Serve data) {
        if (!serveBO.isServeExist(data.getCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveBO.refreshServe(data);
    }

    @Transactional
    @Override
    public int dropServe(String code) {
        int count = 0;
        if (!serveBO.isServeExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        count = serveBO.removeServe(code);
        // 扫描各子表，若存在该服务则删除
        if (serveArtBO.isServeArtExist(code)) {
            serveArtBO.removeServeArt(code);
        } else if (serveCpBO.isServeCpExist(code)) {
            serveCpBO.removeServeCp(code);
        } else if (serveCyyBO.isServeCyyExist(code)) {
            serveCyyBO.removeServeCyy(code);
        } else if (serveKfwbBO.isServeKfwbExist(code)) {
            serveKfwbBO.removeServeKfwb(code);
        } else if (servePhotoBO.isServePhotoExist(code)) {
            servePhotoBO.removeServePhoto(code);
        } else if (serveShopBO.isServeShopExist(code)) {
            serveShopBO.removeServeShop(code);
        } else if (serveTrainBO.isServeTrainExist(code)) {
            serveTrainBO.removeServeTrain(code);
        }
        return count;
    }

    @Override
    public Paginable<Serve> queryServePage(int start, int limit, Serve condition) {
        return serveBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Serve> queryServeList(Serve condition) {
        return serveBO.queryServeList(condition);
    }

    @Override
    public Serve getServe(String code) {
        return serveBO.getServe(code);
    }
}
