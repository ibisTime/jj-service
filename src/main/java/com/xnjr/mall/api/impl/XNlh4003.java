package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSMenuAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh4003Req;
import com.xnjr.mall.dto.res.XNlh4003Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 菜单-删除
 * @author: Gejin 
 * @since: 2016年4月16日 下午8:32:23 
 * @history:
 */
public class XNlh4003 extends AProcessor {
    private ISYSMenuAO sysMenuAO = SpringContextHolder
        .getBean(ISYSMenuAO.class);

    private XNlh4003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNlh4003Res(sysMenuAO.dropSYSMenu(req.getCode()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4003Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}
