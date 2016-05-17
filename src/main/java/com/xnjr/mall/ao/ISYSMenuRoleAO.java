package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.domain.SYSMenuRole;

/**
 * @author: Gejin 
 * @since: 2016年4月16日 下午10:37:44 
 * @history:
 */
public interface ISYSMenuRoleAO {

    public int addSYSMenuRole(SYSMenuRole data);

    public int dropSYSMenuList(String roleCode);

    public List<SYSMenu> querySYSMenuList(SYSMenuRole data);

    public List<SYSMenu> querySYSMenuListByTopCode(String roleCode,
            String parentCode, String type);

}
