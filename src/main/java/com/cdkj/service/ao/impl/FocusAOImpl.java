package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.service.ao.IFocusAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IFocusBO;
import com.cdkj.service.bo.IGroupBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Company;
import com.cdkj.service.domain.Focus;
import com.cdkj.service.domain.Group;
import com.cdkj.service.exception.BizException;

@Service
public class FocusAOImpl implements IFocusAO {

    @Autowired
    private IFocusBO focusBO;

    @Autowired
    private IGroupBO groupBO;

    @Autowired
    private ICompanyBO companyBO;

    @Override
    @Transactional
    public String addFocus(String companyCode, String groupCode, String userId) {
        Company company = companyBO.getCompany(companyCode);
        Group group = groupBO.getGroup(groupCode);
        groupBO.refreshFocusNum(group, group.getFocusNum() + 1);
        companyBO.xgGzNum(company, company.getGzNum() + 1);
        return focusBO.saveFocus(companyCode, groupCode, userId);
    }

    @Override
    @Transactional
    public void editFocus(String code, String groupCode) {
        Focus focus = focusBO.getFocus(code);
        if (groupCode.equals(focus.getGroupCode())) {
            throw new BizException("xn0000", "您没有对该公司进行换组");
        }
        Company company = companyBO.getCompany(focus.getCompanyCode());
        Group groupOld = groupBO.getGroup(focus.getGroupCode());
        groupBO.refreshFocusNum(groupOld, groupOld.getFocusNum() - 1);
        companyBO.xgGzNum(company, company.getGzNum() - 1);
        Group groupNew = groupBO.getGroup(groupCode);
        groupBO.refreshFocusNum(groupNew, groupNew.getFocusNum() + 1);
        companyBO.xgGzNum(company, company.getGzNum() + 1);
        focusBO.refreshFocus(focus, groupCode);
    }

    @Override
    @Transactional
    public void dropFocus(String code) {
        Focus focus = focusBO.getFocus(code);
        Group group = groupBO.getGroup(focus.getGroupCode());
        Company company = companyBO.getCompany(focus.getCompanyCode());
        focusBO.removeFocus(code);
        groupBO.refreshFocusNum(group, group.getFocusNum() - 1);
        companyBO.xgGzNum(company, company.getGzNum() - 1);
    }

    @Override
    public Paginable<Focus> queryFocusPage(int start, int limit, Focus condition) {
        Paginable<Focus> page = focusBO.getPaginable(start, limit, condition);
        List<Focus> focusList = page.getList();
        for (Focus focus : focusList) {
            Company company = companyBO.getCompany(focus.getCompanyCode());
            focus.setCompany(company);
        }
        return page;
    }

    @Override
    public List<Focus> queryFocusList(Focus condition) {
        List<Focus> focusList = focusBO.queryFocusList(condition);
        for (Focus focus : focusList) {
            Company company = companyBO.getCompany(focus.getCompanyCode());
            focus.setCompany(company);
        }
        return focusList;
    }

    @Override
    public Focus getFocus(String code) {
        return focusBO.getFocus(code);
    }
}
