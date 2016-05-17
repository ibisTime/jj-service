package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSMenuRoleAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh4023Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 菜单角色-根据顶级菜单查询下下级菜单列表
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh4023 extends AProcessor {
    private ISYSMenuRoleAO sysMenuRoleAO = SpringContextHolder
        .getBean(ISYSMenuRoleAO.class);

    private XNlh4023Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return sysMenuRoleAO.querySYSMenuListByTopCode(req.getRoleCode(),
            req.getTopParentCode(), req.getType());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4023Req.class);
        StringValidater.validateBlank(req.getRoleCode());
    }
}
