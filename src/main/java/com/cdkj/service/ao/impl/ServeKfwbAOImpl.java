package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IServeKfwbAO;
import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.IServeKfwbBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeKfwb;
import com.cdkj.service.exception.BizException;

@Service
public class ServeKfwbAOImpl implements IServeKfwbAO {

    @Autowired
    private IServeBO serveBO;

    @Autowired
    private IServeKfwbBO serveKfwbBO;

    @Transactional
    @Override
    public String addServeKfwb(ServeKfwb data) {
        String code = serveBO.saveServe(data.getServe());
        data.setServeCode(code);
        serveKfwbBO.saveServeKfwb(data);
        return code;
    }

    @Transactional
    @Override
    public int editServeKfwb(ServeKfwb data) {
        if (!serveKfwbBO.isServeKfwbExist(data.getServeCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        serveBO.refreshServe(data.getServe());
        return serveKfwbBO.refreshServeKfwb(data);
    }

    @Override
    public int dropServeKfwb(String code) {
        if (!serveKfwbBO.isServeKfwbExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveKfwbBO.removeServeKfwb(code);
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
