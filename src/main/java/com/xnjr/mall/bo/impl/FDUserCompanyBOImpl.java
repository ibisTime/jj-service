package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.base.Page;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IFDUserCompanyDAO;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.exception.BizException;

/**
 * 用户企业关联表
 * @author: xieyj 
 * @since: 2016年4月19日 下午4:09:28 
 * @history:
 */
@Component
public class FDUserCompanyBOImpl extends PaginableBOImpl<FDUserCompany>
        implements IFDUserCompanyBO {

    @Autowired
    private IFDUserCompanyDAO fdUserCompanyDAO;

    @Override
    public boolean isUserCompanyExist(String userId, String companyCode) {
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(companyCode)) {
            FDUserCompany condition = new FDUserCompany();
            condition.setUserId(userId);
            condition.setCompanyCode(companyCode);
            FDUserCompany data = fdUserCompanyDAO.select(condition);
            if (data != null) {
                if (EKYCStatus.KYC_YES.getCode().equals(data.getStatus())) {
                    throw new BizException("fd0000", "该企业和用户已经建立关系,无需再次申请");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isUserCompanyBind(String userId, String companyCode) {
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(companyCode)) {
            FDUserCompany condition = new FDUserCompany();
            condition.setUserId(userId);
            condition.setCompanyCode(companyCode);
            condition.setStatus(EKYCStatus.KYC_YES.getCode());
            if (fdUserCompanyDAO.selectTotalCount(condition) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void saveUserCompany(String userId, String companyCode,
            String status, String sqghPicture, String remark) {
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(companyCode)) {
            FDUserCompany data = new FDUserCompany();
            data.setUserId(userId);
            data.setCompanyCode(companyCode);
            data.setStatus(status);
            data.setSqghPicture(sqghPicture);
            data.setRemark(remark);
            fdUserCompanyDAO.insert(data);
        }
    }

    @Override
    public int removeUserCompany(String userId, String companyCode) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(companyCode)) {
            FDUserCompany data = new FDUserCompany();
            data.setUserId(userId);
            data.setCompanyCode(companyCode);
            count = fdUserCompanyDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshUserCompany(String userId, String companyCode,
            String sqghPicture, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(companyCode)) {
            FDUserCompany data = new FDUserCompany();
            data.setUserId(userId);
            data.setCompanyCode(companyCode);
            data.setSqghPicture(sqghPicture);
            data.setStatus(EKYCStatus.TODO_KYC.getCode());
            data.setRemark(remark);
            count = fdUserCompanyDAO.updateUserCompany(data);
        }
        return count;
    }

    @Override
    public int refreshKycUserCompany(String userId, String companyCode,
            String kycUser, String status, String kycNote) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(companyCode)) {
            FDUserCompany data = new FDUserCompany();
            data.setUserId(userId);
            data.setCompanyCode(companyCode);
            data.setStatus(status);
            data.setKycUser(kycUser);
            data.setKycDatetime(new Date());
            data.setKycNote(kycNote);
            count = fdUserCompanyDAO.updateKYCUserCompany(data);
        }
        return count;
    }

    @Override
    public List<FDCompany> queryCompanyList(FDUserCompany condition) {
        List<FDCompany> list = null;
        if (condition != null) {
            list = fdUserCompanyDAO.selectCompanyList(condition);
        }
        return list;
    }

    @Override
    public List<FDCompany> queryConfirmCompanyByUserId(String userId) {
        List<FDCompany> list = null;
        if (StringUtils.isNotBlank(userId)) {
            FDUserCompany condition = new FDUserCompany();
            condition.setUserId(userId);
            condition.setStatus(EKYCStatus.KYC_YES.getCode());
            list = fdUserCompanyDAO.selectCompanyList(condition);
        }
        return list;
    }

    @Override
    public Paginable<FDCompany> getCompanyPage(int start, int pageSize,
            FDUserCompany condition) {
        long totalCount = fdUserCompanyDAO.selectCompanyTotalCount(condition);
        Paginable<FDCompany> page = new Page<FDCompany>(start, pageSize,
            totalCount);
        List<FDCompany> dataList = fdUserCompanyDAO.selectCompanyList(
            page.getStart(), page.getPageSize(), condition);
        page.setList(dataList);
        return page;
    }

    @Override
    public boolean isContainCompany(String userId, String companyCode) {
        boolean result = false;
        List<FDCompany> list = null;
        if (StringUtils.isNotBlank(userId)) {
            FDUserCompany condition = new FDUserCompany();
            condition.setUserId(userId);
            condition.setStatus(EKYCStatus.KYC_YES.getCode());
            list = fdUserCompanyDAO.selectCompanyList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                for (FDCompany fdCompany : list) {
                    if (fdCompany.getCode().equals(companyCode)) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<FDUser> queryUserList(FDUserCompany condition) {
        List<FDUser> list = null;
        if (condition != null) {
            list = fdUserCompanyDAO.selectUserList(condition);
        }
        return list;
    }

    @Override
    public FDUserCompany getUserCompany(Long id) {
        FDUserCompany data = null;
        if (id != null) {
            FDUserCompany condition = new FDUserCompany();
            condition.setId(id);
            data = fdUserCompanyDAO.select(condition);
        }
        return data;
    }

    @Override
    public FDUserCompany getUserCompany(String userId, String companyCode) {
        FDUserCompany data = null;
        if (StringUtils.isNotBlank(userId)
                && StringUtils.isNotBlank(companyCode)) {
            FDUserCompany condition = new FDUserCompany();
            condition.setUserId(userId);
            condition.setCompanyCode(companyCode);
            data = fdUserCompanyDAO.select(condition);
        }
        return data;
    }
}
