package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServeTrainBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IServeTrainDAO;
import com.cdkj.service.domain.ServeTrain;

@Component
public class ServeTrainBOImpl extends PaginableBOImpl<ServeTrain> implements
        IServeTrainBO {

    @Autowired
    private IServeTrainDAO serveTrainDAO;

    @Override
    public boolean isServeTrainExist(String code) {
        ServeTrain condition = new ServeTrain();
        condition.setServeCode(code);
        if (serveTrainDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServeTrain(ServeTrain data) {
        String code = null;
        if (data != null) {
            serveTrainDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServeTrain(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ServeTrain data = new ServeTrain();
            data.setServeCode(code);
            count = serveTrainDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServeTrain(ServeTrain data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getServeCode())) {
            count = serveTrainDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ServeTrain> queryServeTrainList(ServeTrain condition) {
        return serveTrainDAO.selectList(condition);
    }

    @Override
    public ServeTrain getServeTrain(String code) {
        ServeTrain data = null;
        if (StringUtils.isNotBlank(code)) {
            ServeTrain condition = new ServeTrain();
            condition.setServeCode(code);
            data = serveTrainDAO.select(condition);
            // if (data == null) {
            // throw new BizException("xn0000", "该编号不存在");
            // }
        }
        return data;
    }
}
