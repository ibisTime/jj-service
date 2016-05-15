package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSMenuRoleAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh4022Req;
import com.xnjr.mall.dto.res.XNlh4022Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 菜单角色-删除菜单
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh4022 extends AProcessor {
    private ISYSMenuRoleAO sysMenuRoleAO = SpringContextHolder
        .getBean(ISYSMenuRoleAO.class);

    private XNlh4022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        sysMenuRoleAO.dropSYSMenuList(req.getRoleCode());
        return new XNlh4022Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4022Req.class);
        StringValidater.validateBlank(req.getRoleCode());
    }
}
