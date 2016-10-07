package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeCpAO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeCpBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.exception.BizException;

@Service
public class ServeCpAOImpl implements IServeCpAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeCpBO serveCpBO;

    @Transactional
    @Override
    public String addServeCp(ServeCp data) {
        String code = serveBO.saveServe(data.getServe());
        data.setServeCode(code);
        serveCpBO.saveServeCp(data);
        return code;
    }

    @Transactional
    @Override
    public int editServeCp(ServeCp data) {
        if (!serveCpBO.isServeCpExist(data.getServeCode())) {
            throw new BizException("xn0000", "改编号不存在");
        }
        serveBO.refreshServe(data.getServe());
        return serveCpBO.refreshServeCp(data);
    }

    @Override
    public int dropServeCp(String code) {
        if (!serveCpBO.isServeCpExist(code)) {
            throw new BizException("xn0000", "改编号不存在");
        }
        return serveCpBO.removeServeCp(code);
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
