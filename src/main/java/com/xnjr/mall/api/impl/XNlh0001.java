package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.dto.req.XNlh0001Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统用户-列表查询用户
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh0001 extends AProcessor {
    private ISYSUserAO sysUserAO = SpringContextHolder
        .getBean(ISYSUserAO.class);

    private XNlh0001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSUser condition = new SYSUser();
        condition.setKind(req.getKind());
        condition.setRoleCode(req.getRoleCode());
        condition.setLoginName(req.getLoginName());
        condition.setRealName(req.getRealName());
        condition.setUserReferee(req.getUserReferee());

        condition.setStatus(req.getStatus());
        condition.setContact(req.getContact());
        condition.setUpdater(req.getUpdater());
        return sysUserAO.querySYSUserList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh0001Req.class);
    }
}
