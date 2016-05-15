package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.dto.req.XNgs0007Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 操盘手-列表查询
 * @author: myb858 
 * @since: 2016年1月13日 下午1:24:53 
 * @history:
 */
public class XNgs0007 extends AProcessor {
    private IGSTraderAO gsTraderAO = SpringContextHolder
        .getBean(IGSTraderAO.class);

    XNgs0007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSTrader condition = new GSTrader();
        condition.setMobile(req.getMobile());
        condition.setRealName(req.getRealName());
        condition.setLevel(req.getLevel());
        return gsTraderAO.queryGSTraderList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0007Req.class);

    }

}
