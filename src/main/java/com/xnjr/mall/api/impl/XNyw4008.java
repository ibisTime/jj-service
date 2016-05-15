package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4008Req;
import com.xnjr.mall.dto.res.XNyw4008Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 标的详情查询
 * @author: myb858 
 * @since: 2016年1月13日 上午10:50:39 
 * @history:
 */
public class XNyw4008 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    private IGSTraderAO traderAO = SpringContextHolder
        .getBean(IGSTraderAO.class);

    private XNyw4008Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        XNyw4008Res res = new XNyw4008Res();
        Project project = projectAO.getProject(req.getProjectCode(),
            req.getUserId());
        if (project != null) {
            res.setCode(project.getCode());
            res.setName(project.getName());
            res.setStatus(project.getStatus());
            res.setServe(project.getServe());
            res.setQuote(project.getQuote());

            res.setQuoteValue1(project.getQuoteValue1());
            res.setQuoteValue2(project.getQuoteValue2());
            res.setLevel(project.getLevel());
            res.setTotalAmount(project.getTotalAmount());
            res.setPeriod(project.getPeriod());

            res.setType(project.getType());
            res.setTowho(project.getTowho());
            res.setAmount(project.getAmount());
            res.setLoanedAmount(project.getLoanedAmount());
            res.setSummary(project.getSummary());

            res.setDescription(project.getDescription());
            res.setMjstartDatetime(project.getMjstartDatetime());
            res.setPeriod(project.getPeriod());
            res.setMjendDatetime(project.getMjendDatetime());
            res.setMinInvestAmount(project.getMinInvestAmount());

            res.setInvestAmountStep(project.getInvestAmountStep());
            res.setMaxInvestAmount(project.getMaxInvestAmount());
            res.setContractTemplate(project.getContractTemplate());
            res.setRepayDatetime(project.getRepayDatetime());
            res.setRemark(project.getRemark());

            GSTrader trader = traderAO.getGSTrader(project.getTrader());
            res.setTrader(trader);
        }
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4008Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getProjectCode());
    }

}
