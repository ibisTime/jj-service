package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.bo.ICompanyBO;
import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Company;
import com.cdkj.service.dto.req.XN612052Req;
import com.cdkj.service.dto.res.XN612050Res;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ECompanyStatus;
import com.cdkj.service.exception.BizException;

@Service
public class CompanyAOImpl implements ICompanyAO {

    @Autowired
    private ICompanyBO companyBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public XN612050Res addCompany(String type, String name, String gsyyzzh,
            String corporation, String idNo, String mobile, String smsCaptcha,
            String password, String pwdStrength) {
        String userId = userBO.doRegister(mobile, password, pwdStrength,
            smsCaptcha);
        // 公司名称校验，不可相同
        List<Company> companyList = companyBO.queryCompanyList(null, name);
        if (CollectionUtils.isNotEmpty(companyList)) {
            throw new BizException("xn0000", "企业名称不可重复");
        }
        String companyCode = companyBO.saveCompany(type, name, gsyyzzh,
            corporation, idNo, mobile, userId);
        XN612050Res res = new XN612050Res();
        res.setUserId(userId);
        res.setCompanyCode(companyCode);
        return res;
    }

    @Override
    public void editCompany(XN612052Req req) {
        Company company = companyBO.getCompany(req.getCode());
        if (ECompanyStatus.PASS_YES.getCode().equals(company.getStatus())
                && StringUtils.isNotBlank(req.getName())) {
            throw new BizException("xn0000", "审核已通过,名称不可修改");
        }
        if (!ECompanyStatus.PASS_YES.getCode().equals(company.getStatus())) {
            company.setName(req.getName());
        }
        company.setLogo(req.getLogo());
        company.setProvince(req.getProvince());
        company.setCity(req.getCity());
        company.setArea(req.getArea());
        company.setAddress(req.getAddress());
        company.setLongitude(req.getLongitude());
        company.setLatitude(req.getLatitude());
        company.setMobile(req.getMobile());
        company.setScale(req.getScale());
        company.setPic(req.getPic());
        company.setAdvPic(req.getPic());
        company.setSlogan(req.getSlogan());
        company.setDescription(req.getDescription());
        company.setRegisteredCapital(req.getRegisteredCapital());
        company.setRegtime(req.getRegtime());
        company.setUpdater(req.getUpdater());
        company.setUpdateDatetime(new Date());
        companyBO.refreshCompany(company);
    }

    @Override
    public void hotLocation(String code, String orderNo, String updater) {
        Company company = companyBO.getCompany(code);
        if (EBoolean.YES.getCode().equals(company.getLocation())) {
            throw new BizException("xn0000", "企业已经设置为热门");
        }
        if (!EBoolean.NO.getCode().equals(orderNo)) {
            List<Company> companyList = companyBO.queryCompanyList(orderNo,
                null);
            if (CollectionUtils.isNotEmpty(companyList)) {
                throw new BizException("xn0000", "顺序重复,请重新设置");
            }
        }
        companyBO.hotLocation(company, orderNo, updater);
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

    @Override
    public Company byUserId(String userId) {
        return companyBO.byUserId(userId);
    }

}
