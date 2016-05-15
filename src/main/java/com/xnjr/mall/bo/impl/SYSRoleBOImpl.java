package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ISYSRoleBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.ISYSRoleDAO;
import com.xnjr.mall.domain.SYSRole;

@Component
public class SYSRoleBOImpl extends PaginableBOImpl<SYSRole> implements
        ISYSRoleBO {

    @Autowired
    private ISYSRoleDAO sysRoleDAO;

    /**
     * @see com.xnjr.mall.bo.ISYSRoleBO#isSYSRoleExist(java.lang.String)
     */
    @Override
    public boolean isSYSRoleExist(String code) {
        SYSRole role = new SYSRole();
        role.setCode(code);
        if (sysRoleDAO.selectTotalCount(role) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @see com.xnjr.mall.bo.ISYSRoleBO#saveSYSRole(com.xnjr.mall.domain.SYSRole)
     */
    @Override
    public int saveSYSRole(SYSRole data) {
        int count = 0;
        if (data != null) {
            data.setCode(OrderNoGenerater.generateM("SR"));
            data.setUpdateDatetime(new Date());
            count = sysRoleDAO.insert(data);
        }
        return count;
    }

    /**
     * @see com.xnjr.mall.bo.ISYSRoleBO#removeSYSRole(java.lang.String)
     */
    @Override
    public int removeSYSRole(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            SYSRole data = new SYSRole();
            data.setCode(code);
            count = sysRoleDAO.delete(data);
        }
        return count;
    }

    /**
     * @see com.xnjr.mall.bo.ISYSRoleBO#refreshSYSRole(com.xnjr.mall.domain.SYSRole)
     */
    @Override
    public int refreshSYSRole(SYSRole data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getCode())) {
            data.setUpdateDatetime(new Date());
            count = sysRoleDAO.updateSYSRole(data);
        }
        return count;
    }

    /**
     * @see com.xnjr.mall.bo.ISYSRoleBO#getSYSRole(java.lang.String)
     */
    @Override
    public SYSRole getSYSRole(String code) {
        SYSRole data = null;
        if (StringUtils.isNotBlank(code)) {
            SYSRole condition = new SYSRole();
            condition.setCode(code);
            data = sysRoleDAO.select(condition);
        }
        return data;
    }

    /**
     * @see com.xnjr.mall.bo.ISYSRoleBO#querySYSRoleList(com.xnjr.mall.domain.SYSRole)
     */
    @Override
    public List<SYSRole> querySYSRoleList(SYSRole data) {
        return sysRoleDAO.selectList(data);
    }
}
