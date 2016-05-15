/**
 * @Title XNfd0015.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午8:57:53 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0015Req;
import com.xnjr.mall.dto.res.XNfd0015Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * kyc个体户
 * @author: xieyj 
 * @since: 2016年4月22日 下午8:57:53 
 * @history:
 */
public class XNfd0015 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0015Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserAO.doKYCIndividual(req.getUserId(), req.getIndividualCode());
        return new XNfd0015Res(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0015Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIndividualCode());
    }
}
