package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IInvestTableBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IInvestTableDAO;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.exception.BizException;

@Component
public class InvestTableBOImpl extends PaginableBOImpl<InvestTable> implements
        IInvestTableBO {
    @Autowired
    private IInvestTableDAO investTableDAO;

    @Override
    public boolean isInvestTableExist(String investTableCode) {
        InvestTable investTable = new InvestTable();
        investTable.setCode(investTableCode);
        if (investTableDAO.selectTotalCount(investTable) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String saveInvestTable(InvestTable data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("IT");
            data.setCode(code);
            data.setCreateDatetime(new Date());
            investTableDAO.insert(data);
        }
        return code;
    }

    @Override
    public void removeInvestTable(String investTableCode) {
        if (StringUtils.isNotBlank(investTableCode)) {
            InvestTable data = new InvestTable();
            data.setCode(investTableCode);
            investTableDAO.delete(data);
        }
    }

    @Override
    public void refreshInvestTable(InvestTable data) {
        if (data != null) {
            investTableDAO.update(data);
        }
    }

    @Override
    public List<InvestTable> queryInvestTableList(String investCode) {
        List<InvestTable> list = null;
        if (StringUtils.isNotBlank(investCode)) {
            InvestTable condition = new InvestTable();
            condition.setInvestCode(investCode);
            list = investTableDAO.selectList(condition);
        }
        return list;
    }

    @Override
    public void checkInvestAmount(String investCode, Long investAmount) {
        InvestTable condition = new InvestTable();
        condition.setInvestCode(investCode);
        Long totalAmount = investTableDAO.selectSumAmount(condition);
        if (totalAmount == null
                || totalAmount.longValue() != investAmount.longValue()) {
            throw new BizException("XN000000", "打款记录总额与认购总额不相等");
        }

    }

    @Override
    public InvestTable getInvestTable(String investTableCode) {
        InvestTable data = null;
        if (StringUtils.isNotBlank(investTableCode)) {
            InvestTable condition = new InvestTable();
            condition.setCode(investTableCode);
            data = investTableDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvestTableBO#querySubjectInvestTableList(java.lang.String)
     */
    @Override
    public List<InvestTable> querySubjectInvestTableList(String subjectCode) {
        List<InvestTable> list = null;
        if (StringUtils.isNotBlank(subjectCode)) {
            InvestTable condition = new InvestTable();
            condition.setSubjectCode(subjectCode);
            list = investTableDAO.selectSubjectInvestTable(condition);
        }
        return list;
    }

    /** 
     * @see com.xnjr.mall.bo.IInvestTableBO#getInvestTotalAmount(java.lang.String)
     */
    @Override
    public Long getInvestTotalAmount(String investCode) {
        Long totalAmount = 0L;
        List<InvestTable> investTableList = this
            .queryInvestTableList(investCode);
        if (CollectionUtils.isNotEmpty(investTableList)) {
            for (InvestTable investTable : investTableList) {
                totalAmount += investTable.getAmount();
            }
        }
        return totalAmount;
    }
}
