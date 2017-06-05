package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Company;

@Component
public interface ICompanyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCompany(Company data);

    public int dropCompany(String code);

    public int editCompany(Company data);

    public Paginable<Company> queryCompanyPage(int start, int limit,
            Company condition);

    public List<Company> queryCompanyList(Company condition);

    public Company getCompany(String code);

}
