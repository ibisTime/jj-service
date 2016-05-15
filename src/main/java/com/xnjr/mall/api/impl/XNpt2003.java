/**
 * @Title XNpt2003.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:12:49 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IPTCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompany;
import com.xnjr.mall.dto.req.XNpt2003Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 按条件分页查询平台公司列表（可按条件排序）
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:12:49 
 * @history:
 */
public class XNpt2003 extends AProcessor {
    private IPTCompanyAO ptCompanyAO = SpringContextHolder
        .getBean(IPTCompanyAO.class);

    private XNpt2003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        PTCompany condition = new PTCompany();
        condition.setCode(req.getCode());
        condition.setZwName(req.getZwName());
        condition.setYwName(req.getYwName());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPTCompanyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return ptCompanyAO.queryPTCompanyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt2003Req.class);
    }

}
