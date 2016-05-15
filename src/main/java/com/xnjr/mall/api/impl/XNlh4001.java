package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSMenuAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.dto.req.XNlh4001Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 菜单-列表查询
 * @author: Gejin 
 * @since: 2016年4月16日 下午8:13:46 
 * @history:
 */
public class XNlh4001 extends AProcessor {
    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XNlh4001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenu condition = new SYSMenu();
        condition.setKind(req.getKind());
        condition.setName(req.getName());
        condition.setUrl(req.getUrl());
        condition.setParentCode(req.getParentCode());

        condition.setType(req.getType());
        condition.setUpdater(req.getUpdater());
        return sysMenuAO.querySYSMenuList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4001Req.class);
    }
}
