/**
 * @Title XNfd2035.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 上午2:32:51 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.dto.req.XNfd2035Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 资金方-企业分页查询(管)
 * @author: xieyj 
 * @since: 2016年4月22日 上午2:32:51 
 * @history:
 */
public class XNfd2035 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDCompany condition = new FDCompany();
        condition.setCode(req.getCode());
        condition.setName(req.getName());
        condition.setGsyyzzNo(req.getGsyyzzNo());
        condition.setIdKind(req.getIdKind());

        condition.setIdNo(req.getIdNo());
        condition.setRealName(req.getRealName());
        condition.setStatus(req.getStatus());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return fdCompanyAO.queryCompanyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2035Req.class);
    }
}
