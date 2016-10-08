package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServeCpBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IServeCpDAO;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.exception.BizException;

@Component
public class ServeCpBOImpl extends PaginableBOImpl<ServeCp> implements
        IServeCpBO {

    @Autowired
    private IServeCpDAO serveCpDAO;

    @Override
    public boolean isServeCpExist(String code) {
        ServeCp condition = new ServeCp();
        condition.setServeCode(code);
        if (serveCpDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServeCp(ServeCp data) {
        String code = null;
        if (data != null) {
            serveCpDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServeCp(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ServeCp data = new ServeCp();
            data.setServeCode(code);
            count = serveCpDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServeCp(ServeCp data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getServeCode())) {
            count = serveCpDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ServeCp> queryServeCpList(ServeCp condition) {
        return serveCpDAO.selectList(condition);
    }

    @Override
    public ServeCp getServeCp(String code) {
        ServeCp data = null;
        if (StringUtils.isNotBlank(code)) {
            ServeCp condition = new ServeCp();
            condition.setServeCode(code);
            data = serveCpDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该编号不存在");
            }
        }
        return data;
    }
}
