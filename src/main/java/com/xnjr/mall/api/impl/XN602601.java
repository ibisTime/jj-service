/**
 * @Title XN602601.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:30:34 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.api.converter.UserConverter;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602601Req;
import com.xnjr.mall.dto.req.XN805042Req;
import com.xnjr.mall.dto.res.XN805042Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 终端入驻
 * @author: xieyj 
 * @since: 2016年7月26日 下午12:30:34 
 * @history:
 */
public class XN602601 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN602601Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        XN805042Req data = UserConverter.converter(req);
        String userId = userAO.doAddZdUser(data);
        return new XN805042Res(userId);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602601Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getUserReferee());
    }
}
