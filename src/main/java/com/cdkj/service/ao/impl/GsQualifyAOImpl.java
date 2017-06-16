package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IGsQualifyAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.IQualifyBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Company;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ECompanyStatus;
import com.cdkj.service.exception.BizException;

@Service
public class GsQualifyAOImpl implements IGsQualifyAO {

    @Autowired
    private IGsQualifyBO gsQualifyBO;

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private IQualifyBO qualifyBO;

    @Override
    public String addGsQualify(String companyCode, String qualifyCode,
            String slogan, String priceRange, String applyUser) {
        Company company = companyBO.getCompany(companyCode);
        companyBO.priceRange(company, priceRange);
        return gsQualifyBO.saveGsQualify(companyCode, qualifyCode, slogan,
            applyUser);
    }

    @Override
    public void editGsQualify(String code, String qualifyCode, String slogan,
            String priceRange, String applyUser) {
        GsQualify gsQualify = gsQualifyBO.getGsQualify(code);
        if (!ECompanyStatus.PASS_NO.getCode().equals(gsQualify.getStatus())) {
            throw new BizException("xn0000", "正在申请中,不可修改");
        }
        Company company = companyBO.getCompany(gsQualify.getCompanyCode());
        companyBO.priceRange(company, priceRange);
        gsQualifyBO.refreshGsQualify(gsQualify, qualifyCode, slogan, applyUser);
    }

    @Override
    public void approvel(String code, String approveUser, String approveResult,
            String approveNote) {
        GsQualify gsQualify = gsQualifyBO.getGsQualify(code);
        ECompanyStatus status = ECompanyStatus.PASS_YES;
        if (!ECompanyStatus.APPLY.getCode().equals(gsQualify.getStatus())) {
            throw new BizException("xn0000", "该公司资质不在可审核的状态");
        }
        if (EBoolean.NO.getCode().equals(approveResult)) {
            status = ECompanyStatus.PASS_NO;
        }
        Company company = companyBO.getCompany(gsQualify.getCompanyCode());
        companyBO.approvel(company, status, approveUser, approveNote);
        gsQualifyBO.approvel(gsQualify, status, approveUser, approveNote);
    }

    @Override
    public Paginable<GsQualify> queryGsQualifyPage(int start, int limit,
            GsQualify condition) {
        Paginable<GsQualify> page = gsQualifyBO.getPaginable(start, limit,
            condition);
        List<GsQualify> list = page.getList();
        for (GsQualify gsQualify : list) {
            Company company = companyBO.getCompany(gsQualify.getCompanyCode());
            gsQualify.setCompany(company);
            Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
            gsQualify.setQualifyName(qualify.getName());
        }
        return page;
    }

    @Override
    public List<GsQualify> queryGsQualifyList(GsQualify condition) {
        List<GsQualify> list = gsQualifyBO.queryGsQualifyList(condition);
        for (GsQualify gsQualify : list) {
            Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
            gsQualify.setQualifyName(qualify.getName());
        }
        return list;
    }

    @Override
    public GsQualify getGsQualify(String code) {
        GsQualify gsQualify = gsQualifyBO.getGsQualify(code);
        Company company = companyBO.getCompany(gsQualify.getCompanyCode());
        gsQualify.setCompany(company);
        Qualify qualify = qualifyBO.getQualify(gsQualify.getQualifyCode());
        gsQualify.setQualify(qualify);
        return gsQualify;
    }

}
