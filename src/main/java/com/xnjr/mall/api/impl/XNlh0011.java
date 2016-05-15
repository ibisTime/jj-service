package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.dto.req.XNlh0011Req;
import com.xnjr.mall.dto.res.XNlh0011Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统用户-登录
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh0011 extends AProcessor {
    private ISYSUserAO sysUserAO = SpringContextHolder
        .getBean(ISYSUserAO.class);

    private XNlh0011Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSUser data = new SYSUser();
        data.setLoginName(req.getLoginName());
        data.setLoginPwd(req.getLoginPwd());
        data.setLoginIp(req.getLoginIp());
        return new XNlh0011Res(sysUserAO.doLoginSYSUser(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh0011Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getLoginPwd(),
            req.getLoginIp());
    }
}
