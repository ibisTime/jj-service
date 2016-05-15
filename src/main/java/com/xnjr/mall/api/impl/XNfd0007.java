package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0007Req;
import com.xnjr.mall.dto.res.XNfd0007Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户Front-找回登录密码
 * @author: Gejin 
 * @since: 2016年4月17日 下午2:20:51 
 * @history:
 */
public class XNfd0007 extends AProcessor {
    private IFDUserAO userAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNfd0007Res(userAO.doFindLoginPwd(req.getMobile(),
            req.getNewLoginPwd(), req.getNewLoginPwdStrength(),
            req.getSmsCaptcha()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0007Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getNewLoginPwd(),
            req.getNewLoginPwdStrength(), req.getSmsCaptcha());
    }

}
