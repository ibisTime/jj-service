/**
 * @Title XNfd2000.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午8:57:53 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2002Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 个体户账户详情
 * @author: xieyj 
 * @since: 2016年4月22日 下午8:57:53 
 * @history:
 */
public class XNfd2002 extends AProcessor {
    private IFDUserAccountAO fdUserAccountAO = SpringContextHolder
        .getBean(IFDUserAccountAO.class);

    private XNfd2002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdUserAccountAO.getAccount(req.getAccountNumber());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2002Req.class);
        StringValidater.validateBlank(req.getAccountNumber());
    }
}
