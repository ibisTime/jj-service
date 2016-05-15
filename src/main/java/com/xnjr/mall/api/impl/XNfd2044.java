package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2044Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * oss-查询公司账户列表详情
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:42:43 
 * @history:
 */
public class XNfd2044 extends AProcessor {
    private IFDCompanyAccountAO fdCompanyAccountAO = SpringContextHolder
        .getBean(IFDCompanyAccountAO.class);

    private XNfd2044Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return fdCompanyAccountAO.getAccount(req.getAccountNumber());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2044Req.class);
        StringValidater.validateBlank(req.getAccountNumber());
    }
}
