package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISYSUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.dto.req.XNlh0007Req;
import com.xnjr.mall.dto.res.XNlh0005Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 系统用户-修改交易密码
 * @author: xieyj 
 * @since: 2016年4月17日 上午8:26:30 
 * @history:
 */
public class XNlh0007 extends AProcessor {
    private ISYSUserAO sysUserAO = SpringContextHolder
        .getBean(ISYSUserAO.class);

    private XNlh0007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSUser data = new SYSUser();
        data.setUserId(req.getUserId());
        data.setOldTradePwd(req.getOldTradePwd());
        data.setTradePwd(req.getNewTradePwd());
        data.setTradePwdStrength(req.getNewTradePwdStrength());

        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        sysUserAO.doEditSYSUserTradePwd(data);
        return new XNlh0005Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh0007Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getOldTradePwd(),
            req.getNewTradePwd(), req.getNewTradePwdStrength(),
            req.getUpdater());
    }
}
