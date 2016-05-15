package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.ISYSRoleAO;
import com.xnjr.mall.bo.ISYSRoleBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.SYSRole;
import com.xnjr.mall.exception.BizException;

@Service
public class SYSRoleAOImpl implements ISYSRoleAO {

    @Autowired
    ISYSRoleBO sysRoleBO;

    @Override
    public String addSYSRole(SYSRole data) {
        if (data != null) {
            sysRoleBO.saveSYSRole(data);
        } else {
            throw new BizException("lh4000", "角色编号已经存在！");
        }
        return data.getCode();
    }

    @Override
    public boolean editSYSRole(SYSRole data) {
        if (data != null && sysRoleBO.isSYSRoleExist(data.getCode())) {
            sysRoleBO.refreshSYSRole(data);
        } else {
            throw new BizException("lh4000", "角色编号不存在！");
        }
        return true;
    }

    @Override
    public boolean dropSYSRole(String roleCode) {
        if (!sysRoleBO.isSYSRoleExist(roleCode)) {
            throw new BizException("lh4000", "角色编号不存在！");
        }
        sysRoleBO.removeSYSRole(roleCode);
        return true;
    }

    @Override
    public List<SYSRole> querySYSRoleList(SYSRole condition) {
        return sysRoleBO.querySYSRoleList(condition);
    }

    @Override
    public Paginable<SYSRole> querySYSRolePage(int start, int limit,
            SYSRole condition) {
        return sysRoleBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSRoleAO#getSYSRoleDetail(java.lang.String)
     */
    @Override
    public SYSRole getSYSRoleDetail(String code) {
        if (!sysRoleBO.isSYSRoleExist(code)) {
            throw new BizException("lh4000", "角色编号不存在！");
        }
        return sysRoleBO.getSYSRole(code);
    }
}
