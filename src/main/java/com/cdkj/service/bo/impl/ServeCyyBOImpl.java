package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IServeCyyBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.IServeCyyDAO;
import com.cdkj.service.domain.ServeCyy;

@Component
public class ServeCyyBOImpl extends PaginableBOImpl<ServeCyy> implements
        IServeCyyBO {

    @Autowired
    private IServeCyyDAO serveCyyDAO;

    @Override
    public boolean isServeCyyExist(String code) {
        ServeCyy condition = new ServeCyy();
        condition.setServeCode(code);
        if (serveCyyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveServeCyy(ServeCyy data) {
        String code = null;
        if (data != null) {
            serveCyyDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeServeCyy(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            ServeCyy data = new ServeCyy();
            data.setServeCode(code);
            count = serveCyyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshServeCyy(ServeCyy data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getServeCode())) {
            count = serveCyyDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ServeCyy> queryServeCyyList(ServeCyy condition) {
        return serveCyyDAO.selectList(condition);
    }

    @Override
    public ServeCyy getServeCyy(String code) {
        ServeCyy data = null;
        if (StringUtils.isNotBlank(code)) {
            ServeCyy condition = new ServeCyy();
            condition.setServeCode(code);
            data = serveCyyDAO.select(condition);
            // if (data == null) {
            // throw new BizException("xn0000", "该编号不存在");
            // }
        }
        return data;
    }
}
