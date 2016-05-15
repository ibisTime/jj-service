package com.xnjr.mall.api.impl;

import java.util.List;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.dto.req.XNyw4028Req;
import com.xnjr.mall.dto.res.XNyw4028Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-查询认购列表详情
 * @author: myb858 
 * @since: 2016年1月17日 下午4:16:06 
 * @history:
 */
public class XNyw4028 extends AProcessor {
    private IInvestAO investAO = SpringContextHolder.getBean(IInvestAO.class);

    private IInvestTableAO investTableAO = SpringContextHolder
        .getBean(IInvestTableAO.class);

    XNyw4028Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        XNyw4028Res res = new XNyw4028Res();
        Invest invest = investAO.getInvest(req.getInvestCode());
        List<InvestTable> investTableList = investTableAO
            .queryInvestTableList(req.getInvestCode());
        res.setInvest(invest);
        res.setInvestTableList(investTableList);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4028Req.class);
        StringValidater.validateBlank(req.getInvestCode());
    }
}
