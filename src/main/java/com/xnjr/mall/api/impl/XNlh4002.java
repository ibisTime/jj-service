package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSMenuAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSMenu;
import com.xnjr.mall.dto.req.XNlh4002Req;
import com.xnjr.mall.dto.res.XNlh4002Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 菜单-增加
 * @author: Gejin 
 * @since: 2016年4月16日 下午8:23:23 
 * @history:
 */
public class XNlh4002 extends AProcessor {

    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XNlh4002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSMenu data = new SYSMenu();
        data.setKind(req.getKind());
        data.setName(req.getName());
        data.setUrl(req.getUrl());
        data.setParentCode(req.getParentCode());
        data.setType(req.getType());

        data.setOrderNo(req.getOrderNo());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNlh4002Res(sysMenuAO.addSYSMenu(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4002Req.class);
        StringValidater.validateBlank(req.getKind(), req.getName(),
            req.getUrl(), req.getParentCode(), req.getType(), req.getOrderNo(),
            req.getUpdater());
        StringValidater.validateNumber(req.getOrderNo());
    }
}
