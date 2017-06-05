package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Company;



//CHECK ��鲢��ע�� 
public interface ICompanyBO extends IPaginableBO<Company> {


	public boolean isCompanyExist(String code);


	public String saveCompany(Company data);


	public int removeCompany(String code);


	public int refreshCompany(Company data);


	public List<Company> queryCompanyList(Company condition);


	public Company getCompany(String code);


}