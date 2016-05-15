package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSMenuAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.dto.req.XNlh4000Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 菜单-分页查询
 * @author: Gejin 
 * @since: 2016年4月16日 下午8:06:13 
 * @history:
 */
public class XNlh4000 extends AProcessor {
    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XNlh4000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenu condition = new SYSMenu();
        condition.setKind(req.getKind());
        condition.setName(req.getName());
        condition.setParentCode(req.getParentCode());
        condition.setType(req.getType());

        condition.setUpdater(req.getUpdater());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysMenuAO.querySYSMenuPage(start, limit, condition);

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4000Req.class);
    }
}
