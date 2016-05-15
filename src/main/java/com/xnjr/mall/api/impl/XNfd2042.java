/**
 * @Title XNfd2042.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月24日 下午5:42:43 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.dto.req.XNfd2042Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * front-分页查询公司列表
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:42:43 
 * @history:
 */
public class XNfd2042 extends AProcessor {
    private IFDUserCompanyAO fdUserCompanyAO = SpringContextHolder
        .getBean(IFDUserCompanyAO.class);

    private XNfd2042Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        FDUserCompany condition = new FDUserCompany();
        condition.setUserId(req.getUserId());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fdUserCompanyAO
            .queryCompanyPageByUserId(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2042Req.class);
        StringValidater.validateBlank(req.getUserId());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
