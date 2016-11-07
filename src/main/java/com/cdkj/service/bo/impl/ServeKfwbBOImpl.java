package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServeKfwbBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IServeKfwbDAO;
import com.cdkj.service.domain.ServeKfwb;

@Component
public class ServeKfwbBOImpl extends PaginableBOImpl<ServeKfwb> implements
        IServeKfwbBO {

    @Autowired
    private IServeKfwbDAO serveKfwbDAO;

    @Override
    public boolean isServeKfwbExist(String code) {
        ServeKfwb condition = new ServeKfwb();
        condition.setServeCode(code);
        if (serveKfwbDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServeKfwb(ServeKfwb data) {
        String code = null;
        if (data != null) {
            serveKfwbDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServeKfwb(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ServeKfwb data = new ServeKfwb();
            data.setServeCode(code);
            count = serveKfwbDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServeKfwb(ServeKfwb data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getServeCode())) {
            count = serveKfwbDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ServeKfwb> queryServeKfwbList(ServeKfwb condition) {
        return serveKfwbDAO.selectList(condition);
    }

    @Override
    public ServeKfwb getServeKfwb(String code) {
        ServeKfwb data = null;
        if (StringUtils.isNotBlank(code)) {
            ServeKfwb condition = new ServeKfwb();
            condition.setServeCode(code);
            data = serveKfwbDAO.select(condition);
            // if (data == null) {
            // throw new BizException("xn0000", "该编号不存在");
            // }
        }
        return data;
    }
}
