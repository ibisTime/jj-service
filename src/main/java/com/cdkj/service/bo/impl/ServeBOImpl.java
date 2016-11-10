package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServeBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IServeDAO;
import com.cdkj.service.domain.Serve;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Component
public class ServeBOImpl extends PaginableBOImpl<Serve> implements IServeBO {

    @Autowired
    private IServeDAO serveDAO;

    @Override
    public boolean isServeExist(String code) {
        Serve condition = new Serve();
        condition.setCode(code);
        if (serveDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServe(Serve data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.FW.getCode());
            data.setCode(code);
            data.setStatus(EBoolean.YES.getCode());
            data.setIsHot(EBoolean.NO.getCode());
            data.setPublishDatetime(new Date());
            serveDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServe(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Serve data = new Serve();
            data.setCode(code);
            count = serveDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServe(Serve data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setPublishDatetime(new Date());
            count = serveDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Serve> queryServeList(Serve condition) {
        return serveDAO.selectList(condition);
    }

    @Override
    public Serve getServe(String code) {
        Serve data = null;
        if (StringUtils.isNotBlank(code)) {
            Serve condition = new Serve();
            condition.setCode(code);
            data = serveDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }

    @Override
    public int refreshServeStatus(String code, String dealer, String dealNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Serve data = new Serve();
            data.setCode(code);
            data.setStatus(EBoolean.NO.getCode());
            data.setDealer(dealer);
            data.setDealNote(dealNote);
            data.setDealDatetime(new Date());
            count = serveDAO.updateStatus(data);
        }
        return count;
    }

    @Override
    public int refreshServeHot(Serve data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            data.setDealDatetime(new Date());
            count = serveDAO.updateHot(data);
        }
        return count;
    }
}
