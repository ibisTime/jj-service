/**
 * @Title XNfd0030.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月23日 下午4:55:07 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0030Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * front-获取账户详情
 * @author: xieyj 
 * @since: 2016年4月23日 下午4:55:07 
 * @history:
 */
public class XNfd0030 extends AProcessor {
    private IFDAccountAO fdAccountAO = SpringContextHolder
        .getBean(IFDAccountAO.class);

    private XNfd0030Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return fdAccountAO.getAccount(req.getUserId());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0030Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}
