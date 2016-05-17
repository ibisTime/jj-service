package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ISYSMenuRoleAO;
import com.xnjr.mall.bo.ISYSMenuBO;
import com.xnjr.mall.bo.ISYSMenuRoleBO;
import com.xnjr.mall.bo.ISYSRoleBO;
import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.domain.SYSMenuRole;
import com.xnjr.mall.exception.BizException;

@Service
public class SYSMenuRoleAOImpl implements ISYSMenuRoleAO {

    @Autowired
    ISYSMenuRoleBO sysMenuRoleBO;

    @Autowired
    ISYSMenuBO sysMenuBO;

    @Autowired
    ISYSRoleBO sysRoleBO;

    /** 
     * @see com.xnjr.mall.ao.ISYSMenuRoleAO#addSYSMenuRole(com.xnjr.mall.domain.SYSMenuRole)
     */
    @Override
    @Transactional
    public int addSYSMenuRole(SYSMenuRole data) {
        int count = 0;
        if (!sysRoleBO.isSYSRoleExist(data.getRoleCode())) {
            throw new BizException("lh0000", "角色编号不存在！");
        }
        // 删除角色所关联的菜单
        sysMenuRoleBO.removeSYSMenuList(data.getRoleCode());
        // 重新分配角色菜单
        if (CollectionUtils.isNotEmpty(data.getMenuCodeList())) {
            for (String sysMenuCode : data.getMenuCodeList()) {
                if (!sysMenuBO.isSYSMenuExist(sysMenuCode)) {
                    throw new BizException("lh0000", "菜单编号不存在！");
                }
                SYSMenuRole sysMenuRole = new SYSMenuRole();
                sysMenuRole.setMenuCode(sysMenuCode);
                sysMenuRole.setRoleCode(data.getRoleCode());
                sysMenuRole.setUpdater(data.getUpdater());
                sysMenuRole.setUpdateDatetime(new Date());
                sysMenuRole.setRemark(data.getRemark());
                count += sysMenuRoleBO.saveSYSMenuRole(sysMenuRole);
            }
        }
        return count;
    }

    /**
     * @see com.xnjr.mall.ao.ISYSMenuRoleAO#dropSYSMenuList(java.lang.String)
     */
    @Override
    public int dropSYSMenuList(String roleCode) {
        if (!sysRoleBO.isSYSRoleExist(roleCode)) {
            throw new BizException("lh0000", "角色编号不存在！");
        }
        return sysMenuRoleBO.removeSYSMenuList(roleCode);
    }

    /**
     * @see com.xnjr.mall.ao.ISYSMenuRoleAO#querySYSMenuList(com.xnjr.mall.domain.SYSMenuRole)
     */
    @Override
    public List<SYSMenu> querySYSMenuList(SYSMenuRole data) {
        return sysMenuRoleBO.querySYSMenuList(data);
    }

    /** 
     * @see com.xnjr.moom.ao.ISYSMenuRoleAO#querySYSMenuListByTopCode(java.lang.String, java.lang.String)
     */
    @Override
    public List<SYSMenu> querySYSMenuListByTopCode(String roleCode,
            String parentCode, String type) {
        List<SYSMenu> resultList = new ArrayList<SYSMenu>();
        SYSMenuRole condition = new SYSMenuRole();
        condition.setRoleCode(roleCode);
        condition.setParentCode(parentCode);
        condition.setType(type);
        List<SYSMenu> list = sysMenuRoleBO.querySYSMenuList(condition);
        for (SYSMenu sysMenu : list) {
            SYSMenuRole childMenuRole = new SYSMenuRole();
            childMenuRole.setRoleCode(roleCode);
            childMenuRole.setParentCode(sysMenu.getCode());
            childMenuRole.setType(type);
            resultList.addAll(sysMenuRoleBO.querySYSMenuList(childMenuRole));
        }
        return resultList;
    }
}
