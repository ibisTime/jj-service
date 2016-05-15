package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.dto.req.XNlh0002Req;
import com.xnjr.mall.dto.res.XNlh0002Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统用户-新增用户
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh0002 extends AProcessor {
    private ISYSUserAO sysUserAO = SpringContextHolder
        .getBean(ISYSUserAO.class);

    private XNlh0002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSUser data = new SYSUser();
        data.setLoginName(req.getLoginName());
        data.setUserReferee(req.getUserReferee());
        data.setIdKind(req.getIdKind());
        data.setIdNo(req.getIdNo());
        data.setRealName(req.getRealName());

        data.setContact(req.getContact());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        data.setKind(req.getKind());
        return new XNlh0002Res(sysUserAO.addSYSUser(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh0002Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getRealName(),
            req.getContact(), req.getUpdater(), req.getKind());
    }
}
