package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.enums.ECompanyStatus;

public interface IGsQualifyBO extends IPaginableBO<GsQualify> {

    public boolean isGsQualifyExist(String code);

    public String saveGsQualify(String companyCode, String qualifyCode,
            String slogan, String applyUser);

    public void removeGsQualify(String code);

    public void refreshGsQualify(GsQualify data, String qualifyCode,
            String slogan, String applyUser);

    public List<GsQualify> queryGsQualifyList(GsQualify condition);

    public GsQualify getGsQualify(String code);

    public void approvel(GsQualify gsQualify, ECompanyStatus status,
            String approveUser, String approveNote);

    public GsQualify queryGsQualifyList(String companyCode);

}
