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
    public String saveServe(String name, String pic, String advPic,
            String companyCode, Long quoteMin, Long quoteMax,
            String qualityCode, String description, String publisher) {
        Serve data = new Serve();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.FW.getCode());
        data.setCode(code);
        data.setName(name);
        data.setPic(pic);
        data.setAdvPic(advPic);
        data.setCompanyCode(companyCode);

        data.setQuoteMin(quoteMin);
        data.setQuoteMax(quoteMax);
        data.setQualityCode(qualityCode);
        data.setLocation(EBoolean.NO.getCode());
        data.setDescription(description);

        data.setPublisher(publisher);
        data.setStatus(EBoolean.YES.getCode());
        data.setPublishDatetime(new Date());
        serveDAO.insert(data);
        return code;
    }

    @Override
    public void removeServe(String code) {
        if (StringUtils.isNotBlank(code)) {
            Serve data = new Serve();
            data.setCode(code);
            serveDAO.delete(data);
        }
    }

    @Override
    public void refreshServe(Serve serve, String name, String pic,
            String advPic, Long quoteMin, Long quoteMax, String description,
            String publisher) {
        serve.setName(name);
        serve.setPic(pic);
        serve.setAdvPic(advPic);
        serve.setQuoteMin(quoteMin);
        serve.setQuoteMax(quoteMax);

        serve.setDescription(description);
        serve.setPublisher(publisher);
        serve.setPublishDatetime(new Date());
        serveDAO.update(serve);
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
    public void refreshServeStatus(Serve serve, String dealer, String dealNote) {
        serve.setStatus(EBoolean.NO.getCode());
        serve.setDealer(dealer);
        serve.setDealNote(dealNote);
        serve.setDealDatetime(new Date());
        serveDAO.updateStatus(serve);
    }

    @Override
    public void refreshLocation(Serve data, String location, String orderNo,
            String dealer) {
        data.setLocation(location);
        data.setOrderNo(Integer.valueOf(orderNo));
        data.setDealer(dealer);
        data.setDealDatetime(new Date());
        serveDAO.updateHot(data);
    }

    @Override
    public List<Serve> queryServeList(String location, String orderNo) {
        Serve condition = new Serve();
        condition.setLocation(location);
        condition.setOrderNo(Integer.valueOf(orderNo));
        return serveDAO.selectList(condition);
    }
}
