package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IBKBankAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.dto.req.XNbk2004Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 银行-列表查询
 * @author: myb858 
 * @since: 2015年9月18日 下午2:12:16 
 * @history:
 */
public class XNbk2004 extends AProcessor {
    private IBKBankAO bkBankAO = SpringContextHolder.getBean(IBKBankAO.class);

    private XNbk2004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BKBank condition = new BKBank();
        condition.setCode(req.getCode());
        condition.setName(req.getName());
        condition.setStatus(req.getStatus());
        condition.setType(req.getType());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IBKBankAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        return bkBankAO.queryBKBankList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2004Req.class);

    }

}
