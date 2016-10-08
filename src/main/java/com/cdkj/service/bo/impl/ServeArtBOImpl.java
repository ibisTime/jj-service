package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServeArtBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IServeArtDAO;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.exception.BizException;

@Component
public class ServeArtBOImpl extends PaginableBOImpl<ServeArt> implements
        IServeArtBO {

    @Autowired
    private IServeArtDAO serveArtDAO;

    @Override
    public boolean isServeArtExist(String code) {
        ServeArt condition = new ServeArt();
        condition.setServeCode(code);
        if (serveArtDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServeArt(ServeArt data) {
        String code = null;
        if (data != null) {
            serveArtDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServeArt(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ServeArt data = new ServeArt();
            data.setServeCode(code);
            count = serveArtDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServeArt(ServeArt data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getServeCode())) {
            count = serveArtDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ServeArt> queryServeArtList(ServeArt condition) {
        return serveArtDAO.selectList(condition);
    }

    @Override
    public ServeArt getServeArt(String code) {
        ServeArt data = null;
        if (StringUtils.isNotBlank(code)) {
            ServeArt condition = new ServeArt();
            condition.setServeCode(code);
            data = serveArtDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }
}
