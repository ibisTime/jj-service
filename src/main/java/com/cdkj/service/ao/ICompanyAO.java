package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Company;
import com.cdkj.service.dto.req.XN612052Req;
import com.cdkj.service.dto.res.XN612050Res;

@Component
public interface ICompanyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public XN612050Res addCompany(String type, String name, String gsyyzzh,
            String corporation, String idNo, String mobile, String smsCaptcha,
            String password, String pwdStrength);

    public int editCompany(XN612052Req req);

    public void hotLocation(String code, String orderNo, String updater);

    public Paginable<Company> queryCompanyPage(int start, int limit,
            Company condition);

    public List<Company> queryCompanyList(Company condition);

    public Company getCompany(String code);

}
