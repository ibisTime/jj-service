/**
 * @Title InvestAOImpl.java 
 * @Package com.xnjr.pop.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 上午11:57:22 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.ao.IWillInvestAO;
import com.xnjr.mall.bo.IBusinessBO;
import com.xnjr.mall.bo.IFDAJourBO;
import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.IInvestBO;
import com.xnjr.mall.bo.IInvestTableBO;
import com.xnjr.mall.bo.IProjectBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.ISubjectBO;
import com.xnjr.mall.bo.ITraceBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDCompanyAccount;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.domain.WillInvest;
import com.xnjr.mall.enums.EBizType;
import com.xnjr.mall.enums.EInvestStatus;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.enums.EProjectStatus;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.enums.ESubjectStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:57:22 
 * @history:
 */
@Service
public class InvestAOImpl implements IInvestAO {

    @Autowired
    IProjectBO projectBO;

    @Autowired
    IInvestBO investBO;

    @Autowired
    IWillInvestAO willInvestAO;

    @Autowired
    ITraceBO traceBO;

    @Autowired
    IBusinessBO businessBO;

    @Autowired
    IInvestTableBO investTableBO;

    @Autowired
    ISubjectBO subjectBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    @Autowired
    IFDAccountBO fdAccountBO;

    @Autowired
    IFDUserAccountBO fdUserAccountBO;

    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    IFDAJourBO fdAJourBO;

    @Override
    @Transactional
    public String invest(String userId, String projectCode, Long investAmount,
            String tradePwd) {
        // 1.验证userId的合法性
        FDUser fdUser = fdUserBO.getUser(userId);
        // 判断交易密码
        fdUserBO.checkTradePwd(userId, tradePwd);
        // 2.获取项目信息
        Project project = projectBO.getProject(projectCode);
        // 判断项目状态是否为可投资状态
        if (!EProjectStatus.APPROVE_YES.getCode().equalsIgnoreCase(
            project.getStatus())) {
            throw new BizException("XN000000", "《" + projectCode + "》标的不在募集状态");
        }
        // 判断该用户权限
        if (StringUtils.isBlank(fdUser.getServeList())
                || StringUtils.isBlank(fdUser.getQuoteList())
                || fdUser.getLevel() == null) {
            throw new BizException("XN000000", "当前用户无权限，不能认购标的");
        }
        if (!fdUser.getServeList().contains(project.getServe())
                || !fdUser.getQuoteList().contains(project.getQuote())
                || fdUser.getLevel() < project.getLevel()) {
            throw new BizException("XN000000", "当前用户不能认购《" + projectCode
                    + "》标的");
        }
        String code = null;
        // 3.判断投资金额是否大于剩余可投金额
        Long remaidAmount = project.getAmount() - project.getLoanedAmount();
        Long minInvestAmount = project.getMinInvestAmount();
        if (remaidAmount < minInvestAmount) {// 剩余可投金额<起投金额时（最后一笔）
            if (investAmount < remaidAmount) {
                throw new BizException("XN000000", "最后一笔必须一次性投资");
            }
            investAmount = remaidAmount;
        } else {
            if (investAmount > remaidAmount) {
                throw new BizException("XN000000", "投资金额不能超过剩余可投金额");
            }
            if (investAmount < minInvestAmount) {
                throw new BizException("XN000000", "投资金额不能小于最小投资金额"
                        + minInvestAmount / 1000);
            }
            Long maxInvestAmount = project.getMaxInvestAmount();
            if (investAmount > maxInvestAmount) {
                throw new BizException("XN000000", "投资金额不能大于单笔最大投资金额"
                        + maxInvestAmount / 1000);
            }
            Long investAmountStep = project.getInvestAmountStep();
            if ((investAmount - minInvestAmount) % investAmountStep != 0) {
                throw new BizException("XN000000", "请按" + investAmountStep
                        / 1000 + "的倍数进行投资");
            }
        }
        // 4.新增认购记录
        code = investBO.saveInvest(fdUser, project, investAmount);
        // 5.更改可认购金额
        projectBO.refreshLoanedAmount(project, investAmount);
        // 6.发送短信
        smsOutBO.sendSmsOut(fdUser.getMobile(),
            "尊敬的" + PhoneUtil.hideMobile(fdUser.getMobile()) + "用户，您已成功认购《"
                    + project.getName() + "》" + investAmount / 1000
                    + "元整，工作人员将及时与您联系。", ESmsBizType.Invest);
        return code;
    }

    @Override
    @Transactional
    public void confirmInvest(String investCode, Long investAmount,
            String tradePwd, String remark) {
        Invest invest = investBO.getInvest(investCode);
        if (!EInvestStatus.APPLYING.getCode().equalsIgnoreCase(
            invest.getStatus())) {
            throw new BizException("XN000000", "《" + investCode + "》认购不在申请状态");
        }
        if (invest.getInvestAmount() < investAmount) {
            throw new BizException("XN000000", "确认认购金额不能大于客户认购金额");
        }
        // 检查操盘手的验证码
        String projectCode = invest.getProjectCode();
        Project project = projectBO.getProject(projectCode);
        sysUserBO.checkTradePwd(project.getTrader(), tradePwd);
        // 投资金额检查
        investTableBO.checkInvestAmount(investCode, investAmount);
        // 标第一次投资则新建项目
        String subjectCode = null;
        Subject subject = subjectBO.getSubjectByProjectCode(projectCode);
        if (subject == null) {
            subjectCode = subjectBO.saveSubject(project);
        } else {
            subjectCode = subject.getCode();
        }
        // 认购金额以实际确认为准
        Long preInvestAmount = invest.getInvestAmount();
        invest.setInvestAmount(investAmount);
        investBO.confirmInvest(invest, investAmount, remark, subjectCode);
        // 标的进度条调整
        projectBO.refreshLoanedAmount(project, -preInvestAmount + investAmount);

        Long loanedAmount = investBO.getLoanedAmountAmount(projectCode);
        // 标满则结束标的
        if (loanedAmount >= project.getAmount()) {
            projectBO.refreshStatus(project, EProjectStatus.LI_END);
        }
        // 打款账户
        List<InvestTable> investTabelList = investTableBO
            .queryInvestTableList(investCode);
        for (InvestTable investTable : investTabelList) {
            if (investTable.getFromCompany().startsWith(
                EPrefixOrderNo.company.getCode())) {
                FDCompanyAccount fdCompanyAccount = fdCompanyAccountBO
                    .getAccountByCompanyCode(investTable.getFromCompany());
                // fdCompanyAccountBO.refreshAmount(fdCompanyAccount,
                // investTable.getAmount(), EBizType.AJ_XXDK.getCode(),
                // investTable.getCode(), EBizType.AJ_XXDK.getValue());
                // fdCompanyAccountBO.refreshAmount(fdCompanyAccount,
                // -investTable.getAmount(), EBizType.AJ_RG.getCode(),
                // investTable.getCode(), EBizType.AJ_RG.getValue());

                // 线下打款
                Long preAmount1 = new Long(fdCompanyAccount.getAmount());
                fdCompanyAccountBO.refreshAmountWithdrawJour(fdCompanyAccount,
                    investTable.getAmount());
                fdAJourBO.addJour(fdCompanyAccount.getAccountNumber(),
                    preAmount1, investTable.getAmount(),
                    EBizType.AJ_XXDK.getCode(), investTable.getCode(),
                    EBizType.AJ_XXDK.getValue());

                // 认购
                Long preAmount2 = new Long(fdCompanyAccount.getAmount());
                fdCompanyAccountBO.refreshAmountWithdrawJour(fdCompanyAccount,
                    -investTable.getAmount());
                fdAJourBO.addJour(fdCompanyAccount.getAccountNumber(),
                    preAmount2, -investTable.getAmount(),
                    EBizType.AJ_RG.getCode(), investTable.getCode(),
                    EBizType.AJ_RG.getValue());
            } else if (investTable.getFromCompany().startsWith(
                EPrefixOrderNo.user.getCode())) {
                FDUserAccount fdUserAccount = fdUserAccountBO
                    .getAccountByUserId(investTable.getFromCompany());

                // 线下打款
                Long preAmount1 = new Long(fdUserAccount.getAmount());
                fdUserAccountBO.refreshAmountWithdrawJour(fdUserAccount,
                    investTable.getAmount());
                fdAJourBO.addJour(fdUserAccount.getAccountNumber(), preAmount1,
                    investTable.getAmount(), EBizType.AJ_XXDK.getCode(),
                    investTable.getCode(), EBizType.AJ_XXDK.getValue());

                // 认购
                Long preAmount2 = new Long(fdUserAccount.getAmount());
                fdUserAccountBO.refreshAmountWithdrawJour(fdUserAccount,
                    -investTable.getAmount());
                fdAJourBO.addJour(fdUserAccount.getAccountNumber(), preAmount2,
                    -investTable.getAmount(), EBizType.AJ_RG.getCode(),
                    investTable.getCode(), EBizType.AJ_RG.getValue());
            }
        }
        // 发送短信
        sendInvestSms(invest, EInvestStatus.CONFIRMED.getCode(), investAmount,
            project.getName(), remark);
    }

    @Override
    @Transactional
    public void cancelInvest(String investCode, String tradePwd, String remark) {
        Invest invest = investBO.getInvest(investCode);
        if (!EInvestStatus.APPLYING.getCode().equalsIgnoreCase(
            invest.getStatus())) {
            throw new BizException("XN000000", "《" + investCode + "》认购不在申请状态");
        }
        // 检查操盘手的验证码
        String projectCode = invest.getProjectCode();
        Project project = projectBO.getProject(projectCode);
        sysUserBO.checkTradePwd(project.getTrader(), tradePwd);
        // 认购单子处理
        investBO.cancelInvest(investCode, remark);
        // 标的进度条回滚
        projectBO.refreshLoanedAmount(project, -invest.getInvestAmount());
        // 发送短信
        sendInvestSms(invest, EInvestStatus.CANCELLED.getCode(), null,
            project.getName(), remark);
    }

    private void sendInvestSms(Invest invest, String result, Long investAmount,
            String projectName, String remark) {
        FDUser fdUser = fdUserBO.getUser(invest.getUserId());
        if (EInvestStatus.CONFIRMED.getCode().equals(result)) {
            // 发送短信
            smsOutBO.sendSmsOut(
                fdUser.getMobile(),
                "尊敬的客户，您于"
                        + DateUtil.dateToStr(invest.getInvestDatetime(),
                            DateUtil.DATA_TIME_PATTERN_1) + "提交的《"
                        + projectName + "》认购已被确认，确认总金额为" + investAmount / 1000
                        + "元。可立即登录生意家moom.cn 跟踪管理", ESmsBizType.InvestYes);
        } else {
            // 发送短信
            smsOutBO.sendSmsOut(
                fdUser.getMobile(),
                "尊敬的客户，您于"
                        + DateUtil.dateToStr(invest.getInvestDatetime(),
                            DateUtil.DATA_TIME_PATTERN_1) + "提交的《"
                        + projectName + "》认购已被取消，取消原因：" + remark
                        + "。请及时登录生意家moom.cn跟踪管理。", ESmsBizType.InvestNo);
        }
    }

    @Override
    public Paginable<Invest> queryInvestPage(int start, int limit,
            Invest condition) {
        return investBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Invest> queryInvestList(Invest condition) {
        return investBO.queryInvestList(condition);
    }

    public Invest getInvest(String investCode) {
        Invest invest = investBO.getInvest(investCode);
        if (invest == null) {
            throw new BizException("XN000001", "认购编号不存在！");
        }
        return invest;
    }

    @Override
    public List<Invest> queryMyInvestList(Invest condition) {
        List<Invest> resultList = new ArrayList<Invest>();
        List<Invest> investList = investBO.queryInvestList(condition);
        String userId = condition.getUserId();
        List<String> fromCompanyList = new ArrayList<String>();
        // 获取当前用户所拥有的公司
        List<FDCompany> fdCompanyList = fdUserCompanyBO
            .queryConfirmCompanyByUserId(userId);
        for (FDCompany data : fdCompanyList) {
            fromCompanyList.add(data.getCode());
        }
        // 判断当前用户是否是个体户
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        if (StringUtils.isNotBlank(fdUser.getIndividualCode())) {
            fromCompanyList.add(userId);
        }
        for (Invest invest : investList) {
            if (EInvestStatus.CONFIRMED.getCode().equals(invest.getStatus())) {
                List<InvestTable> investTableList = investTableBO
                    .queryInvestTableList(invest.getCode());
                for (InvestTable investTable : investTableList) {
                    // 只要一笔打款记录关联的该用户所拥有的公司或个人，就添加认购记录
                    if (fromCompanyList.contains(investTable.getFromCompany())) {
                        getProject(invest);
                        resultList.add(invest);
                        break;
                    }
                }
            } else {
                getProject(invest);
                resultList.add(invest);
            }
        }
        return resultList;
    }

    // 将认购记录关联项目
    private void getProject(Invest invest) {
        Project project = projectBO.getProject(invest.getProjectCode());
        Project simpleProject = null;
        if (project != null) {
            simpleProject = new Project();
            simpleProject.setCode(project.getCode());
            simpleProject.setName(project.getName());
            simpleProject.setType(project.getType());
            simpleProject.setStatus(project.getStatus());
            simpleProject.setServe(project.getServe());
            simpleProject.setQuote(project.getQuote());
            simpleProject.setQuoteValue1(project.getQuoteValue1());
            simpleProject.setQuoteValue2(project.getQuoteValue2());
            simpleProject.setLevel(project.getLevel());
            simpleProject.setTrader(project.getTrader());
            simpleProject.setTraderName(project.getTraderName());
        }
        invest.setProject(simpleProject);
        // 抹去投资字段
        invest.setUserId(null);
        invest.setRealName(null);
        invest.setProjectCode(null);
    }

    @Override
    public List<Subject> queryMySubjectList(String userId, String status) {
        // 获取没业务的情况
        List<Subject> resultList = new ArrayList<Subject>();
        Invest condition = new Invest();
        condition.setUserId(userId);
        condition.setStatus(status);
        List<Subject> subjectList = investBO.queryMySubjectList(condition);
        if (CollectionUtils.isNotEmpty(subjectList)) {
            for (Subject subject : subjectList) {
                if (ESubjectStatus.todoStart.getCode().equals(
                    subject.getStatus())
                        || ESubjectStatus.Unstart.getCode().equals(
                            subject.getStatus())) {
                    resultList.add(subject);
                } else if (ESubjectStatus.Started.getCode().equals(
                    subject.getStatus())
                        || ESubjectStatus.END.getCode().equals(
                            subject.getStatus())) {
                    List<Business> businessList = businessBO
                        .queryCheckedBusinessList(subject.getCode());
                    // 该项目没有确认业务,需显示;
                    if (CollectionUtils.isEmpty(businessList)) {
                        resultList.add(subject);
                    }
                }
            }
        }

        // 获取有业务的情况(获取从个人公司，业务到项目的列表)
        Subject subCondition = new Subject();
        subCondition.setUserId(userId);
        subCondition.setStatus(status);
        List<Subject> subList = subjectBO.queryMySubjectList(subCondition);
        if (CollectionUtils.isNotEmpty(subList)) {
            resultList.addAll(subList);
        }
        return resultList;
    }

    @Override
    public List<Object> queryMyInvestSubjectList(String userId) {
        List<Object> returnList = new ArrayList<Object>();
        // 获取真实认购中已确认的项目列表
        Invest condition = new Invest();
        condition.setUserId(userId);
        returnList.addAll(queryMySubjectList(userId, null));
        // 获取真实认购(待认购和已取消)
        // condition.setStatus("02");
        // 获取真实认购
        returnList.addAll(queryMyInvestList(condition));
        // 获取意向认购
        WillInvest willCondition = new WillInvest();
        willCondition.setUserId(userId);
        returnList.addAll(willInvestAO.queryMyInvestList(willCondition));
        return returnList;
    }
}
