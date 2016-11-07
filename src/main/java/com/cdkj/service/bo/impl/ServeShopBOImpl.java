package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServeShopBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IServeShopDAO;
import com.cdkj.service.domain.ServeShop;

@Component
public class ServeShopBOImpl extends PaginableBOImpl<ServeShop> implements
        IServeShopBO {

    @Autowired
    private IServeShopDAO serveShopDAO;

    @Override
    public boolean isServeShopExist(String code) {
        ServeShop condition = new ServeShop();
        condition.setServeCode(code);
        if (serveShopDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServeShop(ServeShop data) {
        String code = null;
        if (data != null) {
            serveShopDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServeShop(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ServeShop data = new ServeShop();
            data.setServeCode(code);
            count = serveShopDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServeShop(ServeShop data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getServeCode())) {
            count = serveShopDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ServeShop> queryServeShopList(ServeShop condition) {
        return serveShopDAO.selectList(condition);
    }

    @Override
    public ServeShop getServeShop(String code) {
        ServeShop data = null;
        if (StringUtils.isNotBlank(code)) {
            ServeShop condition = new ServeShop();
            condition.setServeCode(code);
            data = serveShopDAO.select(condition);
            // if (data == null) {
            // throw new BizException("xn0000", "该编号不存在");
            // }
        }
        return data;
    }
}
