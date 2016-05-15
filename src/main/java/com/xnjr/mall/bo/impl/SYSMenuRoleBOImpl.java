/**
 * @Title SYSMenuRoleBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月17日 上午8:58:08 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ISYSMenuRoleBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.ISYSMenuRoleDAO;
import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.domain.SYSMenuRole;

/** 
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:58:08 
 * @history:
 */
@Component
public class SYSMenuRoleBOImpl extends PaginableBOImpl<SYSMenuRole> implements
        ISYSMenuRoleBO {

    @Autowired
    private ISYSMenuRoleDAO sysMenuRoleDAO;

    /** 
     * @see com.xnjr.mall.bo.ISYSMenuRoleBO#saveSYSMenuRole(com.xnjr.mall.domain.SYSMenuRole)
     */
    @Override
    public int saveSYSMenuRole(SYSMenuRole data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = sysMenuRoleDAO.insert(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSMenuRoleBO#removeSYSMenuList(java.lang.String)
     */
    @Override
    public int removeSYSMenuList(String roleCode) {
        int count = 0;
        if (StringUtils.isNotBlank(roleCode)) {
            SYSMenuRole condition = new SYSMenuRole();
            condition.setRoleCode(roleCode);
            count = sysMenuRoleDAO.delSYSMenuList(condition);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSMenuRoleBO#querySYSMenuList(com.xnjr.mall.domain.SYSMenuRole)
     */
    @Override
    public List<SYSMenu> querySYSMenuList(SYSMenuRole data) {
        return sysMenuRoleDAO.selectSYSMenuList(data);
    }
}
