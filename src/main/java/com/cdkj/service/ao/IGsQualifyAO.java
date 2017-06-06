package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.GsQualify;

@Component
public interface IGsQualifyAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addGsQualify(String companyCode, String qualifyCode,
            String slogan, String priceRange, String applyUser);

    public void editGsQualify(String code, String qualifyCode, String slogan,
            String priceRange, String applyUser);

    public void approvel(String code, String approveUser, String approveResult,
            String approveNote);

    public Paginable<GsQualify> queryGsQualifyPage(int start, int limit,
            GsQualify condition);

    public List<GsQualify> queryGsQualifyList(GsQualify condition);

    public GsQualify getGsQualify(String code);

}
