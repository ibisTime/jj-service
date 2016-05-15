package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh0008Req;
import com.xnjr.mall.dto.res.XNlh0008Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统用户-重置交易密码
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh0008 extends AProcessor {
    private ISYSUserAO sysUserAO = SpringContextHolder
        .getBean(ISYSUserAO.class);

    private XNlh0008Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        sysUserAO.doResetSYSUserTradePwdByAdmin(req.getAdminId(),
            req.getAdminTradePwd(), req.getUserId());
        return new XNlh0008Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh0008Req.class);
        StringValidater.validateBlank(req.getAdminId(), req.getAdminTradePwd(),
            req.getUserId());
    }
}
