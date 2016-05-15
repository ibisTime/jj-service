package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.bo.IBKBankBO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.IFDCompanyBO;
import com.xnjr.mall.bo.IFDCompanyCardBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.enums.EUserKind;
import com.xnjr.mall.exception.BizException;

/**
 * 资金方-企业AO
 * @author: xieyj 
 * @since: 2016年4月21日 下午12:20:32 
 * @history:
 */
@Service
public class FDCompanyAOImpl implements IFDCompanyAO {

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDCompanyBO fdCompanyBO;

    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    @Autowired
    IFDCompanyCardBO fdCompanyCardBO;

    @Autowired
    IBKBankBO bkBankBO;

    /**
     * 新增企业逻辑:
     * 判断逻辑
     * 1、判断申请人是否存在(是否实名认证，设置交易密码暂不判断)
     * 2、检查在通过的企业中，企业名称和营业执照号是否存在重复
     * 3、判断
     * 保存逻辑
     * 1、建立用户企业关联关系，kyc状态为草稿
     * 2、保存企业基本信息
     * @see com.xnjr.mall.ao.IFDCompanyAO#addCompany(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String addCompany(String name, String gsyyzzNo, String idKind,
            String idNo, String realName, String currency, Long capital,
            String province, String city, String address, String applyUser) {
        // 1、判断申请人是否存在
        FDUser user = fdUserBO.getUser(applyUser);
        if (user == null) {
            throw new BizException("XNfd0000", "申请人不存在");
        }
        // 用户类型验证，注册时赋值admin，待删除
        if (!EUserKind.Admin.getCode().equalsIgnoreCase(user.getUserKind())) {
            throw new BizException("XNfd0000", "当前用户不是admin,不能KYC");
        }
        // 2、检查通过的企业中是否存在重复企业名称或工商营业执照号
        fdCompanyBO.isCompanyExist(name, gsyyzzNo);
        String code = OrderNoGenerater.generateM(EPrefixOrderNo.company
            .getCode());
        fdUserCompanyBO.saveUserCompany(applyUser, code,
            EKYCStatus.DRAFT.getCode(), null, "申请企业KYC时建立隶属关系申请");
        return fdCompanyBO.saveCompany(code, name, gsyyzzNo, idKind, idNo,
            realName, currency, capital, province, city, address);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDCompanyAO#addCompanyAndCard(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public String addCompanyAndCard(String name, String gsyyzzNo,
            String idKind, String idNo, String realName, String currency,
            Long capital, String province, String city, String address,
            String applyUser, String bankCode, String subbranch, String cardNo) {
        // 保存企业
        String companyCode = this.addCompany(name, gsyyzzNo, idKind, idNo,
            realName, currency, capital, province, city, address, applyUser);

        // 保存企业账户
        FDCompanyCard companyCard = new FDCompanyCard();
        companyCard.setCompanyCode(companyCode);
        companyCard.setCompanyName(name);
        BKBank bkBank = bkBankBO.getBKBank(bankCode);
        if (bkBank == null) {
            throw new BizException("XNfd0000", "银行编号不存在");
        }
        companyCard.setBankCode(bankCode);
        companyCard.setBankName(bkBank.getName());
        companyCard.setSubbranch(subbranch);
        companyCard.setCardNo(cardNo);
        fdCompanyCardBO.saveCompanyCard(companyCard);
        return companyCode;
    }

    @Override
    public void editPicture(String code, String gsyyzzPicture,
            String zzjgdmzPicture, String swdjzPicture, String dzzPicture,
            String frPicture, String otherPicture) {
        if (!fdCompanyBO.isCompanyExist(code)) {
            throw new BizException("XNfd0000", "申请企业不存在");
        }
        fdCompanyBO.refreshPicture(code, gsyyzzPicture, zzjgdmzPicture,
            swdjzPicture, dzzPicture, frPicture, otherPicture);
    }

    @Override
    public void editCompany(String companyCode, String companyName,
            String gsyyzzNo, String idKind, String idNo, String realName,
            String currency, Long capital, String province, String city,
            String address) {
        FDCompany company = fdCompanyBO.getCompany(companyCode);
        fdCompanyBO.refreshCompany(companyCode, companyName, gsyyzzNo, idKind,
            idNo, realName, currency, capital, province, city, address,
            company.getStatus());
    }

    /**
     * @see com.xnjr.mall.ao.IFDCompanyAO#doKYC(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer)
     */
    @Override
    @Transactional
    public void doKYC(String companyCode, String kycUser, String kycResult,
            String kycNote, String serveList, String quoteList, Integer level) {
        FDCompany fdCompany = fdCompanyBO.getCompany(companyCode);
        if (!EKYCStatus.TODO_KYC.getCode().equalsIgnoreCase(
            fdCompany.getStatus())) {
            throw new BizException("xn000001", "当前企业不处于待KYC阶段");
        }
        fdCompanyBO.doKYC(companyCode, kycUser, kycResult, kycNote, serveList,
            quoteList, level);
        // 审核通过创建企业账户,否则连带申请单也不通过
        if (EBoolean.YES.getCode().equalsIgnoreCase(kycResult)) {
            fdCompanyAccountBO.distributeAccount(companyCode,
                fdCompany.getName(), fdCompany.getCurrency());
        } else {
            FDUserCompany condition = new FDUserCompany();
            condition.setCompanyCode(companyCode);
            condition.setStatus(EKYCStatus.TODO_KYC.getCode());
            List<FDUser> fdUserList = fdUserCompanyBO.queryUserList(condition);
            for (FDUser fdUser : fdUserList) {
                fdUserCompanyBO.refreshKycUserCompany(fdUser.getUserId(),
                    companyCode, kycUser, EKYCStatus.KYC_NO.getCode(), kycNote);
            }
        }
    }

    @Override
    public Paginable<FDCompany> queryCompanyPage(int start, int limit,
            FDCompany condition) {
        return fdCompanyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<FDCompany> queryCompanyList(FDCompany condition) {
        return fdCompanyBO.queryCompanyList(condition);
    }

    @Override
    public FDCompany doGetCompany(String code) {
        FDCompany company = fdCompanyBO.getCompany(code);
        if (company != null) {
            FDCompanyCard condition = new FDCompanyCard();
            condition.setCompanyCode(code);
            List<FDCompanyCard> fdCompanyCardList = fdCompanyCardBO
                .queryCompanyCardList(condition);
            company.setFdCompanyCardList(fdCompanyCardList);
        }
        return company;
    }

    @Override
    public String getCompanyCodeByCondition(String name, String gsyyzzNo) {
        String companyCode = null;
        if (StringUtils.isNotBlank(name)) {
            FDCompany condition = new FDCompany();
            condition.setName(name);
            condition.setStatus(EKYCStatus.KYC_YES.getCode());
            List<FDCompany> companyList = fdCompanyBO
                .queryCompanyList(condition);
            if (CollectionUtils.isNotEmpty(companyList)) {
                FDCompany data = companyList.get(0);
                if (!gsyyzzNo.equals(data.getGsyyzzNo())) {
                    throw new BizException("XNfd0000",
                        "企业名称已存在，但其工商营业执照号和现输入的不符，请检查");
                }
                companyCode = data.getCode();
            }
        }
        if (StringUtils.isNotBlank(gsyyzzNo)) {
            FDCompany condition = new FDCompany();
            condition.setGsyyzzNo(gsyyzzNo);
            condition.setStatus(EKYCStatus.KYC_YES.getCode());
            List<FDCompany> companyList = fdCompanyBO
                .queryCompanyList(condition);
            if (CollectionUtils.isNotEmpty(companyList)) {
                FDCompany data = companyList.get(0);
                if (!name.equals(data.getName())) {
                    throw new BizException("XNfd0000",
                        "工商营业执照号已存在，但其企业名称和现输入的不符，请检查");
                }
                companyCode = data.getCode();
            }
        }
        return companyCode;
    }
}
