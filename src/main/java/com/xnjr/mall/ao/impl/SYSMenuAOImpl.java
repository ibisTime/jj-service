package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.ISYSMenuAO;
import com.xnjr.mall.bo.ISYSMenuBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.exception.BizException;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月16日 下午7:44:18 
 * @history:
 */
@Service
public class SYSMenuAOImpl implements ISYSMenuAO {
    @Autowired
    ISYSMenuBO sysMenuBO;

    /**
     * @see com.xnjr.mall.ao.ISYSMenuAO#addSYSMenu(com.xnjr.mall.domain.SYSMenu)
     */
    @Override
    public String addSYSMenu(SYSMenu data) {
        if (data != null) {
            // 判断父编号是否存在
            if (!"0".equalsIgnoreCase(data.getParentCode())
                    && !sysMenuBO.isSYSMenuExist(data.getParentCode())) {
                throw new BizException("lh0000", "父节点菜单编号不存在！");
            }
            sysMenuBO.saveSYSMenu(data);
        } else {
            throw new BizException("lh0000", "菜单编号已经存在！");
        }
        return data.getCode();
    }

    /**
     * @see com.xnjr.mall.ao.ISYSMenuAO#dropSYSMenu(java.lang.String)
     */
    @Override
    public boolean dropSYSMenu(String code) {
        if (!sysMenuBO.isSYSMenuExist((code))) {
            throw new BizException("lh0000", "删除菜单不存在！");
        }
        sysMenuBO.removeSYSMenu(code);
        return true;
    }

    /**
     * @see com.xnjr.mall.ao.ISYSMenuAO#editSYSMenu(com.xnjr.mall.domain.SYSMenu)
     */
    @Override
    public boolean editSYSMenu(SYSMenu data) {
        if (data != null && sysMenuBO.isSYSMenuExist(data.getCode())) {
            sysMenuBO.refreshSYSMenu(data);
        } else {
            throw new BizException("lh0000", "菜单编号不存在！");
        }
        return true;
    }

    /**
     * @see com.xnjr.mall.ao.ISYSMenuAO#querySYSMenuList(com.xnjr.mall.domain.SYSMenu)
     */
    @Override
    public List<SYSMenu> querySYSMenuList(SYSMenu condition) {
        return sysMenuBO.querySYSMenuList(condition);
    }

    /**
     * @see com.xnjr.mall.ao.ISYSMenuAO#querySYSMenuPage(int, int, com.xnjr.mall.domain.SYSMenu)
     */
    @Override
    public Paginable<SYSMenu> querySYSMenuPage(int start, int limit,
            SYSMenu condition) {
        return sysMenuBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSMenuAO#getSYSMenuDetail(int, int, com.xnjr.mall.domain.SYSMenu)
     */
    @Override
    public SYSMenu getSYSMenuDetail(String code) {
        if (!sysMenuBO.isSYSMenuExist(code)) {
            throw new BizException("lh0000", "菜单编号不存在！");
        }
        SYSMenu condition = new SYSMenu();
        condition.setCode(code);
        return sysMenuBO.getSYSMenu(code);
    }
}
