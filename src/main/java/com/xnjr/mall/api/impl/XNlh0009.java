package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.dto.req.XNlh0009Req;
import com.xnjr.mall.dto.res.XNlh0009Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统用户-修改联系方式
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh0009 extends AProcessor {
    private ISYSUserAO sysUserAO = SpringContextHolder
        .getBean(ISYSUserAO.class);

    private XNlh0009Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSUser data = new SYSUser();
        data.setUserId(req.getUserId());
        data.setContact(req.getContact());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        sysUserAO.doEditSYSUserContact(data);
        return new XNlh0009Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh0009Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getContact(),
            req.getUpdater());
    }
}
