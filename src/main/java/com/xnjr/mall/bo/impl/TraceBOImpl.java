package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ITraceBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IProjectDAO;
import com.xnjr.mall.dao.ITraceDAO;
import com.xnjr.mall.domain.Trace;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:07:32 
 * @history:
 */
@Component
public class TraceBOImpl extends PaginableBOImpl<Trace> implements ITraceBO {

    @Autowired
    private ITraceDAO traceDAO;

    @Autowired
    private IProjectDAO projectDAO;

    @Override
    public Trace getTrace(String code) {
        Trace trace = null;
        if (StringUtils.isNotBlank(code)) {
            Trace condition = new Trace();
            condition.setCode(code);
            trace = traceDAO.select(condition);
        }
        return trace;
    }

    @Override
    public String saveTrace(String companyCode, String businessCode, String type) {
        Trace data = new Trace();
        String code = OrderNoGenerater.generateME("YT");
        data.setCode(code);
        data.setCompanyCode(companyCode);
        data.setBusinessCode(businessCode);
        data.setType(type);
        traceDAO.insert(data);
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.ITraceBO#queryTraceList(com.xnjr.mall.domain.Trace)
     */
    @Override
    public List<Trace> queryTraceList(Trace condition) {
        return traceDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.ITraceBO#getTotalCountByBussinessAndUser(java.lang.String, java.lang.String)
     */
    @Override
    public Long getTotalCountByBussinessAndUser(String userId,
            String businessCode) {
        Long count = 0L;
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(businessCode)) {
            Trace condition = new Trace();
            condition.setUserId(userId);
            condition.setBusinessCode(businessCode);
            count = traceDAO.selectTotalCountByBussinessAndUser(condition);
        }
        return count;
    }
}
