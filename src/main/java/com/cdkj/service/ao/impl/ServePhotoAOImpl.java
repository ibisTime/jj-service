package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServePhotoAO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServePhotoBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServePhoto;
import com.cdkj.service.exception.BizException;

@Service
public class ServePhotoAOImpl implements IServePhotoAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServePhotoBO servePhotoBO;

    @Transactional
    @Override
    public String addServePhoto(ServePhoto data) {
        String code = serveBO.saveServe(data.getServe());
        data.setServeCode(code);
        servePhotoBO.saveServePhoto(data);
        return code;
    }

    @Transactional
    @Override
    public int editServePhoto(ServePhoto data) {
        if (!servePhotoBO.isServePhotoExist(data.getServeCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveBO.refreshServe(data.getServe());
        return servePhotoBO.refreshServePhoto(data);
    }

    @Override
    public int dropServePhoto(String code) {
        if (!servePhotoBO.isServePhotoExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return servePhotoBO.removeServePhoto(code);
    }

    @Override
    public Paginable<ServePhoto> queryServePhotoPage(int start, int limit,
            ServePhoto condition) {
        return servePhotoBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ServePhoto> queryServePhotoList(ServePhoto condition) {
        return servePhotoBO.queryServePhotoList(condition);
    }

    @Override
    public ServePhoto getServePhoto(String code) {
        return servePhotoBO.getServePhoto(code);
    }
}
