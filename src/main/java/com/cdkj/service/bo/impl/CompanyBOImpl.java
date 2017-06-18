package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.ICompanyDAO;
import com.cdkj.service.domain.Company;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ECompanyStatus;
import com.cdkj.service.exception.BizException;

@Component
public class CompanyBOImpl extends PaginableBOImpl<Company> implements
        ICompanyBO {

    @Autowired
    private ICompanyDAO companyDAO;

    @Override
    public boolean isCompanyExist(String code) {
        Company condition = new Company();
        condition.setCode(code);
        if (companyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCompany(String type, String name, String gsyyzzh,
            String corporation, String idNo, String mobile, String userId) {
        Company data = new Company();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.COMPANY
            .getCode());
        data.setCode(code);
        data.setType(type);
        data.setName(name);
        data.setGsyyzzh(gsyyzzh);
        data.setCorporation(corporation);
        data.setIdNo(idNo);
        data.setMobile(mobile);
        data.setLocation(EBoolean.NO.getCode());
        data.setOrderNo(EBoolean.NO.getCode());
        data.setUpdater(userId);
        data.setUpdateDatetime(new Date());
        data.setStatus(ECompanyStatus.APPLY.getCode());
        data.setUserId(userId);
        data.setGzNum(0);
        companyDAO.insert(data);
        return code;
    }

    @Override
    public void refreshCompany(Company data) {
        companyDAO.update(data);
    }

    @Override
    public void hotLocation(Company company, String location, String orderNo,
            String updater) {
        company.setLocation(location);
        company.setOrderNo(orderNo);
        company.setUpdater(updater);
        company.setUpdateDatetime(new Date());
        companyDAO.hotLocation(company);
    }

    @Override
    public void priceRange(Company company, String priceRange) {
        company.setPriceRange(priceRange);
        companyDAO.priceRange(company);
    }

    @Override
    public List<Company> queryCompanyList(Company condition) {
        return companyDAO.selectList(condition);
    }

    @Override
    public Company getCompany(String code) {
        Company data = null;
        if (StringUtils.isNotBlank(code)) {
            Company condition = new Company();
            condition.setCode(code);
            data = companyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "公司编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<Company> queryCompanyList(String status, String location,
            String orderNo, String name) {
        Company condition = new Company();
        condition.setStatus(status);
        condition.setLocation(location);
        condition.setOrderNo(orderNo);
        condition.setName(name);
        return companyDAO.selectList(condition);
    }

    @Override
    public Company byUserId(String userId) {
        Company data = null;
        if (StringUtils.isNotBlank(userId)) {
            Company condition = new Company();
            condition.setUserId(userId);
            data = companyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该用户没有注册企业");
            }
        }
        return data;
    }

    @Override
    public void approvel(Company company, ECompanyStatus status,
            String approveUser, String approveNote) {
        company.setStatus(status.getCode());
        company.setUpdater(approveUser);
        company.setRemark(approveNote);
        company.setUpdateDatetime(new Date());
        companyDAO.approvel(company);
    }

    @Override
    public void xgGzNum(Company company, Integer gzNum) {
        company.setGzNum(gzNum);
        companyDAO.updateGzNum(company);
    }

}
