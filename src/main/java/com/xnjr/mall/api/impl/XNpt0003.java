/**
 * @Title XNpt0003.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:47:44 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IPTCompanyPersonAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyPerson;
import com.xnjr.mall.dto.req.XNpt0003Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 公司平台人员分页查询
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:47:44 
 * @history:
 */
public class XNpt0003 extends AProcessor {
    private IPTCompanyPersonAO ptCompanyPersonAO = SpringContextHolder
        .getBean(IPTCompanyPersonAO.class);

    private XNpt0003Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyPerson condition = new PTCompanyPerson();
        condition.setUserId(req.getUserId());
        condition.setRealName(req.getRealName());
        condition.setMobile(req.getMobile());
        condition.setCompanyCode(req.getCompanyCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPTCompanyPersonAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return ptCompanyPersonAO.queryPTCompanyPersonPage(start, limit,
            condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt0003Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}
