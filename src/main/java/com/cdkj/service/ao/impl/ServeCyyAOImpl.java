package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeCyyAO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeCyyBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeCyy;
import com.cdkj.service.exception.BizException;

@Service
public class ServeCyyAOImpl implements IServeCyyAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeCyyBO serveCyyBO;

    @Transactional
    @Override
    public String addServeCyy(ServeCyy data) {
        String code = serveBO.saveServe(data.getServe());
        data.setServeCode(code);
        serveCyyBO.saveServeCyy(data);
        return code;
    }

    @Transactional
    @Override
    public int editServeCyy(ServeCyy data) {
        if (!serveCyyBO.isServeCyyExist(data.getServeCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveBO.refreshServe(data.getServe());
        return serveCyyBO.refreshServeCyy(data);
    }

    @Override
    public int dropServeCyy(String code) {
        if (!serveCyyBO.isServeCyyExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveCyyBO.removeServeCyy(code);
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
