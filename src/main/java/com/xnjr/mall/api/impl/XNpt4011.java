package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.dto.req.XNpt4011Req;
import com.xnjr.mall.enums.ENormalStatus;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * @author: xieyj 
 * @since: 2016年3月11日 上午8:35:26 
 * @history:
 */
public class XNpt4011 extends AProcessor {
    private IPTCompanyCardAO ptCompanyCardAO = SpringContextHolder
        .getBean(IPTCompanyCardAO.class);

    private XNpt4011Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyCard condition = new PTCompanyCard();
        condition.setCode(req.getCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setBankName(req.getBankName());
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
        condition.setOrder(column, req.getOrderDir());
        return ptCompanyCardAO.queryDetailPTCompanyCardList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt4011Req.class);
    }
}
