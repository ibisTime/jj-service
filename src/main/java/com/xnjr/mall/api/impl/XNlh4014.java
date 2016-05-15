package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSRoleAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSRole;
import com.xnjr.mall.dto.req.XNlh4014Req;
import com.xnjr.mall.dto.res.XNlh4014Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 角色-修改
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh4014 extends AProcessor {
    private ISYSRoleAO sysRoleAO = SpringContextHolder
        .getBean(ISYSRoleAO.class);

    private XNlh4014Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSRole data = new SYSRole();
        data.setCode(req.getCode());
        data.setKind(req.getKind());
        data.setName(req.getName());
        data.setLevel(req.getLevel());

        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNlh4014Res(sysRoleAO.editSYSRole(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh4014Req.class);
        StringValidater.validateBlank(req.getCode(), req.getKind(),
            req.getName(), req.getLevel(), req.getUpdater());
    }
}
