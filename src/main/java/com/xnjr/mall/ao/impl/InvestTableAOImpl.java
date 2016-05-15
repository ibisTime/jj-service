package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.bo.IInvestTableBO;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.dto.req.XNyw4021Req;
import com.xnjr.mall.dto.req.XNyw4023Req;
import com.xnjr.mall.exception.BizException;

@Service
public class InvestTableAOImpl implements IInvestTableAO {
    @Autowired
    IInvestTableBO investTableBO;

    @Override
    @Transactional
    public String addInvestTable(XNyw4021Req req) {
        InvestTable data = new InvestTable();
        data.setAmount(StringValidater.toLong(req.getAmount()));
        data.setLxstartDatetime(DateUtil.strToDate(req.getMoneyDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setInvestCode(req.getInvestCode());
        data.setFromCompany(req.getFromCompany());
        data.setFromCompanyCard(req.getFromCompanyCard());
        data.setToCompany(req.getToCompany());
        data.setToCompanyCard(req.getToCompanyCard());
        return investTableBO.saveInvestTable(data);
    }

    @Override
    @Transactional
    public void dropInvestTable(String investTableCode) {
        if (!investTableBO.isInvestTableExist(investTableCode)) {
            throw new BizException("XN000001", "打款记录不存在");
        }
        investTableBO.removeInvestTable(investTableCode);

    }

    @Override
    @Transactional
    public void editInvestTable(XNyw4023Req req) {
        String investTableCode = req.getInvestTableCode();
        if (!investTableBO.isInvestTableExist(investTableCode)) {
            throw new BizException("XN000001", "打款记录不存在");
        }
        InvestTable data = new InvestTable();
        data.setCode(investTableCode);
        data.setAmount(StringValidater.toLong(req.getAmount()));
        data.setLxstartDatetime(DateUtil.strToDate(req.getMoneyDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        data.setInvestCode(req.getInvestCode());

        data.setInvestCode(req.getInvestCode());
        data.setFromCompany(req.getFromCompany());
        data.setFromCompanyCard(req.getFromCompanyCard());
        data.setToCompany(req.getToCompany());
        data.setToCompanyCard(req.getToCompanyCard());
        investTableBO.refreshInvestTable(data);
    }

    @Override
    public InvestTable getInvestTable(String investTableCode) {
        return investTableBO.getInvestTable(investTableCode);
    }

    @Override
    public List<InvestTable> queryInvestTableList(String investCode) {
        return investTableBO.queryInvestTableList(investCode);
    }

    /** 
     * @see com.xnjr.mall.ao.IInvestTableAO#querySubjectInvestTableList(java.lang.String)
     */
    @Override
    public List<InvestTable> querySubjectInvestTableList(String subjectCode) {
        return investTableBO.querySubjectInvestTableList(subjectCode);
    }
}
