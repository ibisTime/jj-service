package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.api.converter.UserConverter;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602200Req;
import com.xnjr.mall.dto.req.XN805042Req;
import com.xnjr.mall.dto.res.XN805042Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 货品商入驻
 * @author: zuixian 
 * @since: 2016年7月26日 下午4:36:56 
 * @history:
 */
public class XN602200 extends AProcessor {

    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN602200Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        XN805042Req data = UserConverter.converter(req);
        String userId = userAO.doAddHpUser(data);
        return new XN805042Res(userId);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602200Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getMobile(),
            req.getIdKind(), req.getIdNo(), req.getRealName(),
            req.getUserReferee());
    }

}
