package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSMenuAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.dto.req.XNlh4004Req;
import com.xnjr.mall.dto.res.XNlh4004Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 菜单-修改
 * @author: Gejin 
 * @since: 2016年4月16日 下午8:32:01 
 * @history:
 */
public class XNlh4004 extends AProcessor {
    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XNlh4004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenu condition = new SYSMenu();
        condition.setCode(req.getCode());
        condition.setKind(req.getKind());
        condition.setName(req.getName());
        condition.setUrl(req.getUrl());
        condition.setParentCode(req.getParentCode());
        condition.setType(req.getType());
        condition.setOrderNo(req.getOrderNo());
        condition.setUpdater(req.getUpdater());
        condition.setRemark(req.getRemark());
        return new XNlh4004Res(sysMenuAO.editSYSMenu(condition));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4004Req.class);
        StringValidater.validateBlank(req.getCode(), req.getKind(),
            req.getName(), req.getUrl(), req.getType(), req.getOrderNo(),
            req.getUpdater());
        StringValidater.validateNumber(req.getOrderNo());

    }

}
