/**
 * @Title RepayDetailAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月29日 下午10:48:47 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IRepayDetailAO;
import com.xnjr.mall.bo.IBusinessBO;
import com.xnjr.mall.bo.IFDAJourBO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.IGSAccountBO;
import com.xnjr.mall.bo.IRepayDetailBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISubjectBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDCompanyAccount;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.domain.RepayDetail;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.EBizType;
import com.xnjr.mall.enums.EGjsBizType;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.enums.EQuote;
import com.xnjr.mall.enums.ERepayDetailStatus;
import com.xnjr.mall.enums.ERepayDetailType;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月29日 下午10:48:47 
 * @history:
 */
@Service
public class RepayDetailAOImpl implements IRepayDetailAO {
    @Autowired
    IRepayDetailBO repayDetailBO;

    @Autowired
    ISubjectBO subjectBO;

    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    IBusinessBO businessBO;

    @Autowired
    IGSAccountBO gsAccountBO;

    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    @Autowired
    IFDUserAccountBO fdUserAccountBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDAJourBO fdAJourBO;

    /** 
     * @see com.xnjr.mall.ao.IRepayDetailAO#repayShi(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void repayShi(String repayCode, String remark, String tradePwd) {
        RepayDetail repayDetail = getRepayDetail(repayCode);
        if (!ERepayDetailStatus.todoRepay.getCode().equalsIgnoreCase(
            repayDetail.getStatus())) {
            throw new BizException("XN000000", "《" + repayCode + "》不在待还款状态");
        }
        // 检查操盘手的验证码
        String subjectCode = repayDetail.getSubjectCode();
        Subject subject = subjectBO.getSubject(subjectCode);
        sysUserBO.checkTradePwd(subject.getTrader(), tradePwd);
        // 还款
        repayDetailBO.repayDetail(repayDetail, remark,
            ERepayDetailStatus.offlineRepayed);
        // ----------算钱部分------------------------
        // 泛海账户
        if (!ERepayDetailType.BJ.getCode().equals(repayDetail.getType())) { // 本金不需要记录系统账户
            Long repayProfit = repayDetail.getAmount();// 客户收益
            if (repayDetailBO.isMinusKHProfit(repayDetail)) { // 判断是否需要加上业务金额
                Long gjsProfit = 0L; // 泛海收益
                if (EQuote.FC.getCode().equals(subject.getQuote())
                        || EQuote.BDFC.getCode().equals(subject.getQuote())) {
                    // 统计项目分成或保底分成的业务总收益
                    List<Business> businessList = businessBO
                        .queryCheckedBusinessList(subjectCode);
                    Long businessProfit = 0L;
                    for (Business business : businessList) {
                        businessProfit = businessProfit + business.getProfit();
                    }
                    gjsProfit = businessProfit - repayProfit;
                } else {
                    // 年化
                    gjsProfit = repayDetail.getBusinessProfit() - repayProfit;
                }
                // 泛海账户：收益记录
                gsAccountBO
                    .refreshAmount(gjsProfit, EGjsBizType.ZYW, repayCode);
            } else {
                gsAccountBO.refreshAmount(-repayProfit, EGjsBizType.ZYW,
                    repayCode);
            }
        }

        Long amount = repayDetail.getAmount();
        // 判断本次还款是本金还是利息
        String amountType = null;
        if (ERepayDetailType.BJ.getCode().equalsIgnoreCase(
            repayDetail.getType())) {
            amountType = ERepayDetailType.BJ.getValue();
        } else if (ERepayDetailType.LX.getCode().equalsIgnoreCase(
            repayDetail.getType())) {
            amountType = ERepayDetailType.LX.getValue();
        }
        if (repayDetail.getTowho().startsWith(EPrefixOrderNo.company.getCode())) {
            FDCompanyAccount fdCompanyAccount = fdCompanyAccountBO
                .getAccountByCompanyCode(repayDetail.getTowho());
            // fdCompanyAccountBO.refreshAmount(fdCompanyAccount, amount,
            // EBizType.AJ_XSHK.getCode(), code, "还款：线上确认" + amountType);
            // fdCompanyAccountBO.refreshAmount(fdCompanyAccount, -amount,
            // EBizType.AJ_XXJS.getCode(), code, "还款：线下偿还" + amountType);

            // 还款：线上确认
            Long preAmount1 = new Long(fdCompanyAccount.getAmount());
            fdCompanyAccountBO.refreshAmountWithdrawJour(fdCompanyAccount,
                amount);
            fdAJourBO.addJour(fdCompanyAccount.getAccountNumber(), preAmount1,
                amount, EBizType.AJ_XSHK.getCode(), repayCode, "还款：线上确认"
                        + amountType);

            // 还款：线下还款
            Long preAmount2 = new Long(fdCompanyAccount.getAmount());
            fdCompanyAccountBO.refreshAmountWithdrawJour(fdCompanyAccount,
                -amount);
            fdAJourBO.addJour(fdCompanyAccount.getAccountNumber(), preAmount2,
                -amount, EBizType.AJ_XXJS.getCode(), repayCode, "还款：线下偿还"
                        + amountType);
        } else if (repayDetail.getTowho().startsWith(
            EPrefixOrderNo.user.getCode())) {
            FDUserAccount fdUserAccount = fdUserAccountBO
                .getAccountByUserId(repayDetail.getTowho());
            // 还款：线上确认
            Long preAmount1 = new Long(fdUserAccount.getAmount());
            fdUserAccountBO.refreshAmountWithdrawJour(fdUserAccount, amount);
            fdAJourBO.addJour(fdUserAccount.getAccountNumber(), preAmount1,
                amount, EBizType.AJ_XSHK.getCode(), repayCode, "还款：线上确认"
                        + amountType);

            // 还款：线下还款
            Long preAmount2 = new Long(fdUserAccount.getAmount());
            fdUserAccountBO.refreshAmountWithdrawJour(fdUserAccount, -amount);
            fdAJourBO.addJour(fdUserAccount.getAccountNumber(), preAmount2,
                -amount, EBizType.AJ_XXJS.getCode(), repayCode, "还款：线下偿还"
                        + amountType);
        }
    }

    /** 
     * @see com.xnjr.mall.ao.IRepayDetailAO#repayKong(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void repayKong(String repayCode, String remark, String tradePwd) {
        RepayDetail repayDetail = getRepayDetail(repayCode);
        if (!ERepayDetailStatus.todoRepay.getCode().equalsIgnoreCase(
            repayDetail.getStatus())) {
            throw new BizException("XN000000", "《" + repayCode + "》不在待还款状态");
        }
        // 检查操盘手的验证码
        String subjectCode = repayDetail.getSubjectCode();
        Subject subject = subjectBO.getSubject(subjectCode);
        sysUserBO.checkTradePwd(subject.getTrader(), tradePwd);
        // 还款
        repayDetailBO.repayDetail(repayDetail, remark,
            ERepayDetailStatus.onlineRepayed);
        // ----------算钱部分------------------------
        // 泛海账户
        if (!ERepayDetailType.BJ.getCode().equals(repayDetail.getType())) { // 本金不需要记录系统账户
            Long repayProfit = repayDetail.getAmount();// 客户收益
            if (repayDetailBO.isMinusKHProfit(repayDetail)) { // 判断是否需要加上业务金额
                Long gjsProfit = 0L; // 泛海收益
                if (EQuote.FC.getCode().equals(subject.getQuote())
                        || EQuote.BDFC.getCode().equals(subject.getQuote())) {
                    // 统计项目分成或保底分成的业务总收益
                    List<Business> businessList = businessBO
                        .queryCheckedBusinessList(subjectCode);
                    Long businessProfit = 0L;
                    for (Business business : businessList) {
                        businessProfit = businessProfit + business.getProfit();
                    }
                    gjsProfit = businessProfit - repayProfit;
                } else {
                    // 年化
                    gjsProfit = repayDetail.getBusinessProfit() - repayProfit;
                }
                // 泛海账户：收益记录
                gsAccountBO
                    .refreshAmount(gjsProfit, EGjsBizType.ZYW, repayCode);
            } else {
                gsAccountBO.refreshAmount(-repayProfit, EGjsBizType.ZYW,
                    repayCode);
            }
        }
        // 本次还款总金额
        Long amount = repayDetail.getAmount();
        // 判断本次还款是本金还是利息
        String amountType = null;
        if (ERepayDetailType.BJ.getCode().equalsIgnoreCase(
            repayDetail.getType())) {
            amountType = ERepayDetailType.BJ.getValue();
        } else if (ERepayDetailType.LX.getCode().equalsIgnoreCase(
            repayDetail.getType())) {
            amountType = ERepayDetailType.LX.getValue();
        }
        // 判断还款到企业账户还是个人账户
        if (repayDetail.getTowho().startsWith(EPrefixOrderNo.company.getCode())) {
            FDCompanyAccount fdCompanyAccount = fdCompanyAccountBO
                .getAccountByCompanyCode(repayDetail.getTowho());
            // 还款：线上确认
            Long preAmount1 = new Long(fdCompanyAccount.getAmount());
            fdCompanyAccountBO.refreshAmountWithdrawJour(fdCompanyAccount,
                amount);
            fdAJourBO.addJour(fdCompanyAccount.getAccountNumber(), preAmount1,
                amount, EBizType.AJ_XSHK.getCode(), repayCode, "还款：线上确认"
                        + amountType);
        } else if (repayDetail.getTowho().startsWith(
            EPrefixOrderNo.user.getCode())) {
            FDUserAccount fdUserAccount = fdUserAccountBO
                .getAccountByUserId(repayDetail.getTowho());
            // 还款：线上确认
            Long preAmount1 = new Long(fdUserAccount.getAmount());
            fdUserAccountBO.refreshAmountWithdrawJour(fdUserAccount, amount);
            fdAJourBO.addJour(fdUserAccount.getAccountNumber(), preAmount1,
                amount, EBizType.AJ_XSHK.getCode(), repayCode, "还款：线上确认"
                        + amountType);
        }
    }

    /** 
     * @see com.xnjr.mall.ao.IRepayDetailAO#queryRepayDetailPage(int, int, com.xnjr.mall.domain.RepayDetail)
     */
    @Override
    public Paginable<RepayDetail> queryRepayDetailPage(int start, int limit,
            RepayDetail condition) {
        return repayDetailBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IRepayDetailAO#getRepayDetail(java.lang.String)
     */
    @Override
    public RepayDetail getRepayDetail(String code) {
        RepayDetail repayDetail = repayDetailBO.getRepayDetail(code);
        if (repayDetail == null) {
            throw new BizException("XN000000", "《" + code + "》还款计划不存在");
        }
        return repayDetail;
    }

    /**
     * @see com.xnjr.mall.ao.IRepayDetailAO#getTotalInvest(java.lang.String)
     */
    @Override
    public Long getTotalInvest(String userId) {
        List<String> towhoList = new ArrayList<String>();
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        towhoList.add(fdUser.getUserId());
        List<FDCompany> companyList = fdUserCompanyBO
            .queryConfirmCompanyByUserId(userId);
        for (FDCompany fdCompany : companyList) {
            towhoList.add(fdCompany.getCode());
        }
        return repayDetailBO.getTotalInvest(towhoList);
    }

    /**
     * @see com.xnjr.mall.ao.IRepayDetailAO#getTotalProfit(java.lang.String)
     */
    @Override
    public Long getTotalProfit(String userId) {
        List<String> towhoList = new ArrayList<String>();
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        towhoList.add(fdUser.getUserId());
        List<FDCompany> companyList = fdUserCompanyBO
            .queryConfirmCompanyByUserId(userId);
        for (FDCompany fdCompany : companyList) {
            towhoList.add(fdCompany.getCode());
        }
        return repayDetailBO.getTotalProfit(towhoList);
    }
}
