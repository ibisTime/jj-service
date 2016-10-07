package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.exception.BizException;

@Service
public class ServeAOImpl implements IServeAO {

    @Autowired
    private IServeBO serveBO;

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

    @Override
    public int dropServe(String code) {
        if (!serveBO.isServeExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveBO.removeServe(code);
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
