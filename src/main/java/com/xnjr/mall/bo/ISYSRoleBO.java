package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.SYSRole;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月16日 下午9:32:33 
 * @history:
 */
public interface ISYSRoleBO extends IPaginableBO<SYSRole> {
    public boolean isSYSRoleExist(String code);

    public int saveSYSRole(SYSRole data);

    public int removeSYSRole(String code);

    public int refreshSYSRole(SYSRole data);

    public SYSRole getSYSRole(String code);

    public List<SYSRole> querySYSRoleList(SYSRole data);
}
