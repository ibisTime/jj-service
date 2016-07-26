/**
 * @Title XN602600.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:30:34 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.api.converter.JfUserConverter;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602600Req;
import com.xnjr.mall.dto.req.XN805042Req;
import com.xnjr.mall.dto.res.XN805042Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 积分商入驻
 * @author: xieyj 
 * @since: 2016年7月26日 下午12:30:34 
 * @history:
 */
public class XN602600 extends AProcessor {
    private IUserAO userAO = SpringContextHolder.getBean(IUserAO.class);

    private XN602600Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        XN805042Req data = JfUserConverter.converter(req);
        String userId = userAO.doAddJfUser(data);
        return new XN805042Res(userId);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602600Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getMobile(),
            req.getIdKind(), req.getIdNo(), req.getRealName(),
            req.getUserReferee());

    }

}
