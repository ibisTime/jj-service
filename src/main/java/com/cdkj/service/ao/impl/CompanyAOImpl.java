package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Company;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class CompanyAOImpl implements ICompanyAO {

	@Autowired
	private ICompanyBO companyBO;

	@Override
	public String addCompany(Company data) {
		return companyBO.saveCompany(data);
	}

	@Override
	public int editCompany(Company data) {
		if (!companyBO.isCompanyExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return companyBO.refreshCompany(data);
	}

	@Override
	public int dropCompany(String code) {
		if (!companyBO.isCompanyExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return companyBO.removeCompany(code);
	}

	@Override
	public Paginable<Company> queryCompanyPage(int start, int limit,
			Company condition) {
		return companyBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<Company> queryCompanyList(Company condition) {
		return companyBO.queryCompanyList(condition);
	}

	@Override
	public Company getCompany(String code) {
		return companyBO.getCompany(code);
	}
}