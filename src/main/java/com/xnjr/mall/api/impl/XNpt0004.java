/**
 * @Title XNpt0004.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:44:21 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IPTCompanyPersonAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.PTCompanyPerson;
import com.xnjr.mall.dto.req.XNpt0004Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 按条件查询平台公司人员列表
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:44:21 
 * @history:
 */
public class XNpt0004 extends AProcessor {
    private IPTCompanyPersonAO ptCompanyPersonAO = SpringContextHolder
        .getBean(IPTCompanyPersonAO.class);

    private XNpt0004Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyPerson data = new PTCompanyPerson();
        data.setUserId(req.getUserId());
        data.setRealName(req.getRealName());
        data.setMobile(req.getMobile());
        data.setCompanyCode(req.getCompanyCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPTCompanyPersonAO.DEFAULT_ORDER_COLUMN;
        }
        data.setOrder(orderColumn, req.getOrderDir());
        return ptCompanyPersonAO.queryPTCompanyPersonList(data);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt0004Req.class);
    }
}
