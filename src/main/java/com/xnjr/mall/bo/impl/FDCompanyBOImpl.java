package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDCompanyBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IFDCompanyDAO;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.exception.BizException;

/**
 * 资金方-企业
 * @author: xieyj 
 * @since: 2016年4月21日 下午7:25:37 
 * @history:
 */
@Component
public class FDCompanyBOImpl extends PaginableBOImpl<FDCompany> implements
        IFDCompanyBO {
    @Autowired
    private IFDCompanyDAO fdCompanyDAO;

    @Override
    public String saveCompany(String code, String name, String gsyyzzNo,
            String idKind, String idNo, String realName, String currency,
            Long capital, String province, String city, String address) {
        FDCompany data = new FDCompany();
        data.setCode(code);
        data.setName(name);
        data.setGsyyzzNo(gsyyzzNo);
        data.setIdKind(idKind);
        data.setIdNo(idNo);

        data.setRealName(realName);
        data.setCurrency(currency);
        data.setCapital(capital);
        data.setProvince(province);
        data.setCity(city);
        data.setAddress(address);

        data.setStatus(EKYCStatus.DRAFT.getCode());
        data.setRemark("添加基本信息");
        fdCompanyDAO.insert(data);
        return code;
    }

    @Override
    public int refreshCompany(String code, String name, String gsyyzzNo,
            String idKind, String idNo, String realName, String currency,
            Long capital, String province, String city, String address,
            String status) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            FDCompany data = new FDCompany();
            data.setCode(code);
            data.setName(name);
            data.setGsyyzzNo(gsyyzzNo);
            data.setIdKind(idKind);

            data.setIdNo(idNo);
            data.setRealName(realName);
            data.setCurrency(currency);
            data.setCapital(capital);
            data.setProvince(province);

            data.setCity(city);
            data.setAddress(address);
            data.setStatus(status);
            data.setRemark("修改基本信息");
            count = fdCompanyDAO.updateCompany(data);
        }
        return count;
    }

    @Override
    public int refreshPicture(String code, String gsyyzzPicture,
            String zzjgdmzPicture, String swdjzPicture, String dzzPicture,
            String frPicture, String otherPicture) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            FDCompany data = new FDCompany();
            data.setCode(code);
            data.setGsyyzzPicture(gsyyzzPicture);
            data.setZzjgdmzPicture(zzjgdmzPicture);
            data.setSwdjzPicture(swdjzPicture);

            data.setDzzPicture(dzzPicture);
            data.setFrPicture(frPicture);
            data.setOtherPicture(otherPicture);
            data.setStatus(EKYCStatus.TODO_KYC.getCode());
            count = fdCompanyDAO.updatePicture(data);
        }
        return count;
    }

    @Override
    public int doKYC(String code, String kycUser, String kycResult,
            String kycNote, String serveList, String quoteList, Integer level) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            FDCompany data = new FDCompany();
            data.setCode(code);
            data.setKycUser(kycUser);
            data.setKycDatetime(new Date());
            data.setKycNote(kycNote);
            if (EBoolean.YES.getCode().equalsIgnoreCase(kycResult)) {
                data.setStatus(EKYCStatus.KYC_YES.getCode());
                data.setServeList(serveList);
                data.setQuoteList(quoteList);
                data.setLevel(level);
            } else {
                data.setStatus(EKYCStatus.KYC_NO.getCode());
            }
            count = fdCompanyDAO.doKYC(data);
        }
        return count;
    }

    @Override
    public boolean isCompanyExist(String code) {
        FDCompany data = new FDCompany();
        data.setCode(code);
        if (fdCompanyDAO.selectTotalCount(data) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void isCompanyExist(String name, String gsyyzzNo) {
        if (StringUtils.isNotBlank(name)) {
            FDCompany data = new FDCompany();
            data.setName(name);
            data.setStatus(EKYCStatus.KYC_YES.getCode());
            if (fdCompanyDAO.selectTotalCount(data) > 0) {
                throw new BizException("xn702002", "企业已存在");
            }
        }
        if (StringUtils.isNotBlank(gsyyzzNo)) {
            FDCompany data = new FDCompany();
            data.setGsyyzzNo(gsyyzzNo);
            data.setStatus(EKYCStatus.KYC_YES.getCode());
            if (fdCompanyDAO.selectTotalCount(data) > 0) {
                throw new BizException("xn702002", "工商营业执照号已存在");
            }
        }
    }

    @Override
    public FDCompany getCompany(String code) {
        FDCompany data = null;
        if (code != null) {
            FDCompany condition = new FDCompany();
            condition.setCode(code);
            data = fdCompanyDAO.select(condition);
        }
        if (data != null) {
            return data;
        }
        throw new BizException("xn000001", "企业信息不存在！");
    }

    @Override
    public List<FDCompany> queryCompanyList(FDCompany condition) {
        return fdCompanyDAO.selectList(condition);
    }
}
