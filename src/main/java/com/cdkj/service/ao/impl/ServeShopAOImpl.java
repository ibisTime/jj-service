package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IServeShopAO;
import com.cdkj.service.bo.IServeShopBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.ServeShop;
import com.cdkj.service.exception.BizException;

@Service
public class ServeShopAOImpl implements IServeShopAO {

    @Autowired
    private IServeShopBO serveShopBO;

    @Override
    public String addServeShop(ServeShop data) {
        return serveShopBO.saveServeShop(data);
    }

    @Override
    public int editServeShop(ServeShop data) {
        if (!serveShopBO.isServeShopExist(data.getServeCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveShopBO.refreshServeShop(data);
    }

    @Override
    public int dropServeShop(String code) {
        if (!serveShopBO.isServeShopExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return serveShopBO.removeServeShop(code);
    }

    @Override
    public Paginable<ServeShop> queryServeShopPage(int start, int limit,
            ServeShop condition) {
        return serveShopBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<ServeShop> queryServeShopList(ServeShop condition) {
        return serveShopBO.queryServeShopList(condition);
    }

    @Override
    public ServeShop getServeShop(String code) {
        return serveShopBO.getServeShop(code);
    }
}
