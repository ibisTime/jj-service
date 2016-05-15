package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.dto.req.XNyw4027Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-查询认购列表
 * @author: myb858 
 * @since: 2016年1月17日 下午4:16:06 
 * @history:
 */
public class XNyw4027 extends AProcessor {
    private IInvestAO investAO = SpringContextHolder.getBean(IInvestAO.class);

    XNyw4027Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Invest condition = new Invest();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setProjectCode(req.getProjectCode());
        condition.setUserId(req.getUserId());
        condition.setRealName(req.getRealName());

        return investAO.queryInvestList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4027Req.class);
    }
}
