/**
 * @Title XNfd2041.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月24日 下午5:42:43 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2041Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * oss-查询公司账户详情
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:42:43 
 * @history:
 */
public class XNfd2041 extends AProcessor {

    private IFDCompanyAccountAO fdCompanyAccountAO = SpringContextHolder
        .getBean(IFDCompanyAccountAO.class);

    private XNfd2041Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return fdCompanyAccountAO.getAccountByCompanyCode(req.getCompanyCode());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2041Req.class);
        StringValidater.validateBlank(req.getCompanyCode());
    }
}
