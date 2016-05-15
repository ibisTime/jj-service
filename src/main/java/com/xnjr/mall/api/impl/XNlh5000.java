/**
 * @Title XNlh5000.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午4:08:42 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.ISYSLogAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SYSLog;
import com.xnjr.mall.dto.req.XNlh5000Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 分页查询操作日志
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午4:08:42 
 * @history:
 */
public class XNlh5000 extends AProcessor {
    private ISYSLogAO sysLogAO = SpringContextHolder.getBean(ISYSLogAO.class);

    XNlh5000Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        SYSLog condition = new SYSLog();
        condition.setToTable(req.getToTable());
        condition.setOperater(req.getOperater());
        condition.setOperateType(req.getOperateType());
        condition.setOperateDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setOperateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSLogAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysLogAO.querySYSLogPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5000Req.class);
    }

}
