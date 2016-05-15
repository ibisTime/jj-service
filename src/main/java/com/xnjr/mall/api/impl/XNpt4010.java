/**
 * @Title XN803761.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年3月6日 上午11:00:29 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.dto.req.XNpt4010Req;
import com.xnjr.mall.enums.ENormalStatus;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 按条件分页查询开户信息
 * @author: xieyj 
 * @since: 2016年3月6日 上午11:00:29 
 * @history:
 */
public class XNpt4010 extends AProcessor {
    private IPTCompanyCardAO ptCompanyCardAO = SpringContextHolder
        .getBean(IPTCompanyCardAO.class);

    private XNpt4010Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyCard condition = new PTCompanyCard();
        condition.setCode(req.getCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSubbranchCode(req.getSubbranchCode());
        condition.setKind(req.getKind());
        condition.setCurrency(req.getCurrency());
        condition.setCardNo(req.getCardNo());
        condition.setIsAccept(req.getIsAccept());
        // 通过的账户
        condition.setStatus(ENormalStatus.PASS.getCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IPTCompanyCardAO.DEFAULT_ORDER_COLUMN;
        }
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        condition.setOrder(column, req.getOrderDir());
        return ptCompanyCardAO.queryDetailPTCompanyCardPage(start, limit,
            condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt4010Req.class);
    }
}
