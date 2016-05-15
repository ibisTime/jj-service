/**
 * @Title XNbk2015.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午5:02:42 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IBKSubbranchAO;
import com.xnjr.mall.ao.IPTCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.BKSubbranch;
import com.xnjr.mall.dto.req.XNbk2015Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 按条件分页查询支行列表
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午5:02:42 
 * @history:
 */
public class XNbk2015 extends AProcessor {
    private IBKSubbranchAO bkSubbranchAO = SpringContextHolder
        .getBean(IBKSubbranchAO.class);

    private XNbk2015Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BKSubbranch condition = new BKSubbranch();
        condition.setName(req.getName());
        condition.setStatus(req.getStatus());
        condition.setBankCode(req.getBankCode());
        condition.setRegion(req.getRegion());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPTCompanyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return bkSubbranchAO.queryBKSubbranchPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2015Req.class);
    }
}
