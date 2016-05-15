package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.dto.req.XNpt4007Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 按条件分页查询开户信息
 * @author: xieyj 
 * @since: 2016年3月6日 上午11:00:29 
 * @history:
 */
public class XNpt4007 extends AProcessor {
    private IPTCompanyCardAO platAccount = SpringContextHolder
        .getBean(IPTCompanyCardAO.class);

    private XNpt4007Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyCard condition = new PTCompanyCard();
        condition.setCode(req.getCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSubbranchCode(req.getSubbranchCode());
        condition.setKhPerson(req.getKhPerson());
        condition.setKhDatetimeStart(DateUtil.getFrontDate(
            req.getKhDatetimeStart(), false));
        condition.setKhDatetimeEnd(DateUtil.getFrontDate(
            req.getKhDatetimeEnd(), true));
        condition.setStatus(req.getStatus());
        condition.setIsAccept(req.getIsAccept());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IPTCompanyCardAO.DEFAULT_ORDER_COLUMN;
        }
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        condition.setOrder(column, req.getOrderDir());
        return platAccount.queryPTCompanyCardPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt4007Req.class);
    }
}
