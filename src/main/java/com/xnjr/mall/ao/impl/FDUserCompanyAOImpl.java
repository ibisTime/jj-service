package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IFDUserCompanyAO;
import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.IFDCompanyBO;
import com.xnjr.mall.bo.IFDIndividualBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.exception.BizException;

/**
 * 用户企业关联
 * @author: xieyj 
 * @since: 2016年4月21日 下午10:03:49 
 * @history:
 */
@Service
public class FDUserCompanyAOImpl implements IFDUserCompanyAO {
    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDAccountBO fdAccountBO;

    @Autowired
    IFDCompanyBO fdCompanyBO;

    @Autowired
    IFDIndividualBO fdIndividualBO;

    @Autowired
    ISmsOutBO smsOutBO;

    public List<FDCompany> queryCompanyListByUserId(String userId) {
        FDUserCompany condition = new FDUserCompany();
        condition.setUserId(userId);
        return fdUserCompanyBO.queryCompanyList(condition);
    }

    @Override
    public Paginable<FDCompany> queryCompanyPageByUserId(int start,
            int pageSize, FDUserCompany condition) {
        return fdUserCompanyBO.getCompanyPage(start, pageSize, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#queryCompanyList(com.xnjr.mall.domain.FDUserCompany)
     */
    @Override
    public List<FDCompany> queryCompanyList(FDUserCompany condition) {
        return fdUserCompanyBO.queryCompanyList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#queryUserList(com.xnjr.mall.domain.FDUserCompany)
     */
    @Override
    public List<FDUser> queryUserList(FDUserCompany condition) {
        return fdUserCompanyBO.queryUserList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#queryUserCompanyPage(com.xnjr.mall.domain.FDUserCompany)
     */
    @Override
    public Paginable<FDUserCompany> queryUserCompanyPage(int start, int limit,
            FDUserCompany condition) {
        return fdUserCompanyBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#doBindUserCompany(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void doBindUserCompany(String userId, String companyCode,
            String sqghPicture, String remark) {
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "该用户不存在");
        }
        if (!fdCompanyBO.isCompanyExist(companyCode)) {
            throw new BizException("fd0000", "该公司不存在");
        }

        if (fdUserCompanyBO.isUserCompanyExist(userId, companyCode)) {
            fdUserCompanyBO.refreshUserCompany(userId, companyCode,
                sqghPicture, remark);
        } else {
            fdUserCompanyBO.saveUserCompany(userId, companyCode,
                EKYCStatus.TODO_KYC.getCode(), sqghPicture, remark);
        }
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#doChangeUserCompany(java.lang.String, java.lang.String, java.lang.String,java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void doChangeUserCompany(String fromUserId, String toUserId,
            String companyCode, String sqghPicture, String remark,
            String updater) {
        FDUser fromFDUser = fdUserBO.getUser(fromUserId);
        if (fromFDUser == null) {
            throw new BizException("fd0000", "原用户不存在");
        }
        FDUser toFDUser = fdUserBO.getUser(toUserId);
        if (toFDUser == null) {
            throw new BizException("fd0000", "变更用户不存在");
        }
        FDCompany condition = new FDCompany();
        condition.setCode(companyCode);
        condition.setStatus(EKYCStatus.KYC_YES.getCode());
        if (fdCompanyBO.getTotalCount(condition) < 1) {
            throw new BizException("XNfd0000", "编号" + companyCode
                    + "的公司KYC不处于审核通过状态");
        }
        if (fdUserCompanyBO.isUserCompanyBind(fromUserId, companyCode)) {
            // 删除隶属关系，收回权限
            fdUserCompanyBO.removeUserCompany(fromUserId, companyCode);
            fdUserBO.doKYC(fromFDUser, null, null, null);
        } else {
            throw new BizException("XNfd0000", "公司绑定用户关系不存在");
        }
        if (!fdUserCompanyBO.isUserCompanyBind(toUserId, companyCode)) {
            fdUserCompanyBO.saveUserCompany(toUserId, companyCode,
                EKYCStatus.TODO_KYC.getCode(), sqghPicture, remark);
        } else {
            throw new BizException("XNfd0000", "变更用户与公司绑定关系已存在,无法变更");
        }
    }

    @Override
    @Transactional
    public void doKYC(Long id, String kycUser, String kycResult, String kycNote) {
        FDUserCompany fdUserCompany = fdUserCompanyBO.getUserCompany(id);
        if (fdUserCompany == null) {
            throw new BizException("fd0000", "编号不存在");
        }

        if (!EKYCStatus.TODO_KYC.getCode().equals(fdUserCompany.getStatus())) {
            throw new BizException("fd0000", "该记录不是待Kyc状态,无法审核");
        }
        FDUser fdUser = fdUserBO.getUser(fdUserCompany.getUserId());
        if (fdUser == null) {
            throw new BizException("fd0000", "该用户不存在");
        }
        // 判断公司是否已经kyc通过
        FDCompany fdCompany = fdCompanyBO.getCompany(fdUserCompany
            .getCompanyCode());
        if (fdCompany == null) {
            throw new BizException("fd0000", "该公司不存在");
        }
        if (!EKYCStatus.KYC_YES.getCode().equals(fdCompany.getStatus())) {
            throw new BizException("fd0000", "该公司不是KYC审核通过状态，请先对公司进行KYC审核");
        }
        String mobile = fdUser.getMobile();
        // 审核通过，用户权限变更
        if (EBoolean.YES.getCode().equals(kycResult)) {
            String theServeList = fdCompany.getServeList();
            String theQuoteList = fdCompany.getQuoteList();
            Integer theLevel = fdCompany.getLevel();
            fdUserBO.doKYC(fdUser, theServeList, theQuoteList, theLevel);
            smsOutBO.sendSmsOut(mobile,
                "尊敬的客户，您于" + DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_1)
                        + "提交的《" + fdCompany.getName()
                        + "》企业KYC已通过。可立即登录生意家moom.cn 查看最新的服务。",
                ESmsBizType.KN.getCode(), ESmsBizType.KN.getValue());
        } else {
            smsOutBO.sendSmsOut(mobile,
                "尊敬的客户，您于" + DateUtil.getToday(DateUtil.DATA_TIME_PATTERN_1)
                        + "提交的《" + fdCompany.getName() + "》企业KYC未能通过，不通过原因："
                        + kycNote + "。请及时登录生意家moom.cn 查看审核结果。",
                ESmsBizType.KN.getCode(), ESmsBizType.KN.getValue());
        }
        // 更改隶属关系KYC状态
        String kycStatus = EKYCStatus.KYC_NO.getCode();
        if (kycResult.equals(EBoolean.YES.getCode())) {
            kycStatus = EKYCStatus.KYC_YES.getCode();
        }
        fdUserCompanyBO.refreshKycUserCompany(fdUserCompany.getUserId(),
            fdUserCompany.getCompanyCode(), kycUser, kycStatus, kycNote);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#doBindUserCompany(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void doBindUserCompany(String userId, String companyCode,
            String sqghPicture, String remark, String updater) {
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "该用户不存在");
        }
        if (!fdCompanyBO.isCompanyExist(companyCode)) {
            throw new BizException("fd0000", "该公司不存在");
        }
        if (fdUserCompanyBO.isUserCompanyExist(userId, companyCode)) {
            fdUserCompanyBO.refreshUserCompany(userId, companyCode,
                sqghPicture, remark);
        } else {
            fdUserCompanyBO.saveUserCompany(userId, companyCode,
                EKYCStatus.TODO_KYC.getCode(), sqghPicture, remark);
        }
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#doUnBindUserCompany(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void doUnBindUserCompany(String userId, String companyCode,
            String updater) {
        FDUser fromFDUser = fdUserBO.getUser(userId);
        if (fromFDUser == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        FDCompany condition = new FDCompany();
        condition.setCode(companyCode);
        condition.setStatus(EKYCStatus.KYC_YES.getCode());
        if (fdCompanyBO.getTotalCount(condition) < 1) {
            throw new BizException("XNfd0000", "编号" + companyCode
                    + "的公司KYC记录不处于审核通过状态");
        }
        if (fdUserCompanyBO.isUserCompanyBind(userId, companyCode)) {
            // 删除隶属关系，收回权限
            fdUserCompanyBO.removeUserCompany(userId, companyCode);
            fdUserBO.doKYC(fromFDUser, null, null, null);
        } else {
            throw new BizException("XNfd0000", "公司绑定用户关系不存在");
        }
        // 记录操作人
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserCompanyAO#getUserCompany(java.lang.String, java.lang.String)
     */
    @Override
    public FDUserCompany getUserCompany(String userId, String companyCode) {
        return fdUserCompanyBO.getUserCompany(userId, companyCode);
    }
}
