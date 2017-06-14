package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IGsQualifyBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.IGsQualifyDAO;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.enums.ECompanyStatus;
import com.cdkj.service.exception.BizException;

@Component
public class GsQualifyBOImpl extends PaginableBOImpl<GsQualify> implements
        IGsQualifyBO {

    @Autowired
    private IGsQualifyDAO gsQualifyDAO;

    @Override
    public boolean isGsQualifyExist(String code) {
        GsQualify condition = new GsQualify();
        condition.setCode(code);
        if (gsQualifyDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveGsQualify(String companyCode, String qualifyCode,
            String slogan, String applyUser) {
        GsQualify data = new GsQualify();
        String code = OrderNoGenerater.generateM(EGeneratePrefix.GSQUALIFY
            .getCode());
        data.setCode(code);
        data.setCompanyCode(companyCode);
        data.setQualifyCode(qualifyCode);
        data.setSlogan(slogan);
        data.setStatus(ECompanyStatus.APPLY.getCode());
        data.setApplyUser(applyUser);
        data.setApplyDatetime(new Date());
        gsQualifyDAO.insert(data);
        return code;
    }

    @Override
    public void removeGsQualify(String code) {
        if (StringUtils.isNotBlank(code)) {
            GsQualify data = new GsQualify();
            data.setCode(code);
            gsQualifyDAO.delete(data);
        }
    }

    @Override
    public void refreshGsQualify(GsQualify data, String qualifyCode,
            String slogan, String applyUser) {
        data.setQualifyCode(qualifyCode);
        data.setSlogan(slogan);
        data.setApplyUser(applyUser);
        data.setApplyDatetime(new Date());
        data.setStatus(ECompanyStatus.APPLY.getCode());
        gsQualifyDAO.update(data);
    }

    @Override
    public List<GsQualify> queryGsQualifyList(GsQualify condition) {
        return gsQualifyDAO.selectList(condition);
    }

    @Override
    public GsQualify getGsQualify(String code) {
        GsQualify data = null;
        if (StringUtils.isNotBlank(code)) {
            GsQualify condition = new GsQualify();
            condition.setCode(code);
            data = gsQualifyDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "不存在该编号");
            }
        }
        return data;
    }

    @Override
    public void approvel(GsQualify gsQualify, ECompanyStatus status,
            String approveUser, String approveNote) {
        gsQualify.setStatus(status.getCode());
        gsQualify.setApprover(approveUser);
        gsQualify.setApproveNote(approveNote);
        gsQualify.setApproveDatetime(new Date());
        gsQualifyDAO.approvel(gsQualify);
    }

    @Override
    public GsQualify queryGsQualifyList(String companyCode) {
        GsQualify data = null;
        GsQualify condition = new GsQualify();
        condition.setCompanyCode(companyCode);
        data = gsQualifyDAO.select(condition);
        if (data == null) {
            throw new BizException("xn0000", "该公司还没有申请资质");
        }
        return data;
    }
}
