package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Company;

public interface ICompanyBO extends IPaginableBO<Company> {

    public boolean isCompanyExist(String code);

    public String saveCompany(String type, String name, String gsyyzzh,
            String corporation, String idNo, String mobile, String userId);

    public int removeCompany(String code);

    public int refreshCompany(Company data);

    public List<Company> queryCompanyList(Company condition);

    public List<Company> queryCompanyList(String orderNo);

    public Company getCompany(String code);

}
