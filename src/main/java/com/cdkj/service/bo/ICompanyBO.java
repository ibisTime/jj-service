package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Company;
import com.cdkj.service.enums.ECompanyStatus;

public interface ICompanyBO extends IPaginableBO<Company> {

    public boolean isCompanyExist(String code);

    public String saveCompany(String type, String name, String gsyyzzh,
            String corporation, String idNo, String mobile, String userId);

    public void editPassCompany(Company data);

    public void hotLocation(Company company, String location, String orderNo,
            String updater);

    public void priceRange(Company company, String priceRange);

    public List<Company> queryCompanyList(Company condition);

    public List<Company> queryCompanyList(String status, String location,
            String orderNo, String name);

    public Company getCompany(String code);

    public Company byUserId(String userId);

    public void approvel(Company company, ECompanyStatus status,
            String approveUser, String approveNote);

    public void xgGzNum(Company company, Integer gzNum);

}
