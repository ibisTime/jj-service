package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ISubjectAO;
import com.xnjr.mall.bo.IBusinessBO;
import com.xnjr.mall.bo.IFDCompanyBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IInvestBO;
import com.xnjr.mall.bo.IInvestTableBO;
import com.xnjr.mall.bo.IProjectBO;
import com.xnjr.mall.bo.IRepayDetailBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.ISubjectBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.EProjectStatus;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.enums.ESubjectStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: wuql
 * @since: 2016年1月19日 下午1:23:03 
 * @history:
 */
@Service
public class SubjectAOImpl implements ISubjectAO {
    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    IBusinessBO businessBO;

    @Autowired
    IProjectBO projectBO;

    @Autowired
    IRepayDetailBO repayDetailBO;

    @Autowired
    IInvestBO investBO;

    @Autowired
    IInvestTableBO investTableBO;

    @Autowired
    IFDCompanyBO fdCompanyBO;

    @Autowired
    ISubjectBO subjectBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Override
    @Transactional
    public void startSubject(String subjectCode, String tradePwd, String remark) {
        Subject subject = getSubject(subjectCode);
        if (!ESubjectStatus.todoStart.getCode().equalsIgnoreCase(
            subject.getStatus())) {
            throw new BizException("XN000000", "《" + subjectCode + "》项目不在待开始状态");
        }
        // 检查操盘手的交易密码
        sysUserBO.checkTradePwd(subject.getTrader(), tradePwd);
        // 开始项目
        subjectBO.startSubject(subject, remark);
        // 发送短信
        sendStartSubjectSms(subjectCode, subject.getName());
    }

    private void sendStartSubjectSms(String subjectCode, String subjectName) {
        List<Invest> investList = investBO
            .queryConfirmedInvestList(subjectCode);
        if (CollectionUtils.isNotEmpty(investList)) {
            for (Invest invest : investList) {
                FDUser fdUser = fdUserBO.getUser(invest.getUserId());
                // 发送短信
                smsOutBO.sendSmsOut(fdUser.getMobile(), "尊敬的客户，您认购的《"
                        + subjectName + "》已经开始项目。可立即登录生意家moom.cn 跟踪管理。",
                    ESmsBizType.InvestYes);
            }
        }
    }

    @Override
    @Transactional
    public void cancelSubject(String subjectCode, String tradePwd, String remark) {
        Subject subject = getSubject(subjectCode);
        if (!ESubjectStatus.todoStart.getCode().equalsIgnoreCase(
            subject.getStatus())) {
            throw new BizException("XN000000", "《" + subjectCode + "》项目不在待开始状态");
        }
        Project project = projectBO.getProject(subject.getProjectCode());
        if (!(EProjectStatus.LI_END.getCode().equalsIgnoreCase(
            project.getStatus()) || EProjectStatus.REN_END.getCode()
            .equalsIgnoreCase(project.getStatus()))) {
            throw new BizException("XN000000", "编号为" + subject.getProjectCode()
                    + "的标没结束,请强制结束标后再操作");
        }
        List<Business> list = businessBO.queryCheckedBusinessList(subjectCode);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new BizException("XN000000", "项目已经有业务运行，请走结束项目操作");
        }

        // 检查操盘手的验证码
        sysUserBO.checkTradePwd(subject.getTrader(), tradePwd);
        // 取消项目
        subjectBO.cancelSubject(subject, remark);
        // 形成还款单子：损失利息
        List<Invest> investList = investBO
            .queryConfirmedInvestList(subjectCode);
        if (CollectionUtils.isNotEmpty(investList)) {
            for (Invest invest : investList) {
                List<InvestTable> investTableList = investTableBO
                    .queryInvestTableList(invest.getCode());
                if (CollectionUtils.isEmpty(investTableList)) {
                    throw new BizException("XN000000", "未找到打款记录，请检查确认认购逻辑");
                }
                repayDetailBO.cancelSubjectRepay(invest, investTableList,
                    subject);
            }
        }
    }

    @Override
    @Transactional
    public void stopSubject(String subjectCode, String tradePwd, String remark) {
        Subject subject = getSubject(subjectCode);
        if (!ESubjectStatus.Started.getCode().equalsIgnoreCase(
            subject.getStatus())) {
            throw new BizException("XN000000", "《" + subjectCode + "》项目不在开始状态");
        }
        Project project = projectBO.getProject(subject.getProjectCode());
        if (!(EProjectStatus.LI_END.getCode().equalsIgnoreCase(
            project.getStatus()) || EProjectStatus.REN_END.getCode()
            .equalsIgnoreCase(project.getStatus()))) {
            throw new BizException("XN000000", "《" + subject.getProjectCode()
                    + "》标的没有结束,请强制结束标的");
        }
        List<Business> businessList = businessBO
            .queryCheckedBusinessList(subjectCode);
        // remove by haiqing
        // if (CollectionUtils.isEmpty(businessList)) {
        // throw new BizException("XN000000", "项目没有业务运行，请走流项目操作");
        // }
        // 检查操盘手的交易密码
        sysUserBO.checkTradePwd(subject.getTrader(), tradePwd);
        // 结束项目
        subjectBO.stopSubject(subject, remark);
        // 形成还款单子：开始分钱
        List<Invest> investList = investBO
            .queryConfirmedInvestList(subjectCode);
        if (CollectionUtils.isNotEmpty(investList)) {
            for (Invest invest : investList) {
                List<InvestTable> investTableList = investTableBO
                    .queryInvestTableList(invest.getCode());
                if (CollectionUtils.isEmpty(investTableList)) {
                    throw new BizException("XN000000", "未找到打款记录，请检查确认认购逻辑");
                }
                repayDetailBO.stopSubjectRepay(invest, investTableList,
                    businessList, subject);
            }
        }

        // 发送短信
        sendStopSubjectSms(subjectCode, subject.getName());
    }

    private void sendStopSubjectSms(String subjectCode, String subjectName) {
        List<Invest> investList = investBO
            .queryConfirmedInvestList(subjectCode);
        if (CollectionUtils.isNotEmpty(investList)) {
            for (Invest invest : investList) {
                FDUser fdUser = fdUserBO.getUser(invest.getUserId());
                // 发送短信
                smsOutBO.sendSmsOut(fdUser.getMobile(), "尊敬的客户，您认购的《"
                        + subjectName + "》已经结束项目。可立即登录生意家moom.cn 跟踪管理。",
                    ESmsBizType.InvestYes);
            }
        }
    }

    public Paginable<Subject> querySubjectPage(int start, int limit,
            Subject condition) {
        return subjectBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Subject> querySubjectList(Subject condition) {
        return subjectBO.querySubjectList(condition);
    }

    @Override
    public Subject getSubject(String subjectCode) {
        Subject subject = subjectBO.getSubject(subjectCode);
        if (subject == null) {
            throw new BizException("XN000000", "《" + subjectCode + "》项目不存在");
        } else {
            return subject;
        }
    }

    @Override
    public Subject getSubject(String subjectCode, String userId) {
        Subject result = null;

        // 获取没业务的情况
        Invest invCondition = new Invest();
        invCondition.setUserId(userId);
        List<Subject> subjectList = investBO.queryMySubjectList(invCondition);
        if (CollectionUtils.isNotEmpty(subjectList)) {
            for (Subject subject : subjectList) {
                if (subject.getCode().equals(subjectCode)) {
                    if (ESubjectStatus.todoStart.getCode().equals(
                        subject.getStatus())
                            || ESubjectStatus.Unstart.getCode().equals(
                                subject.getStatus())) {
                        result = subject;
                        break;
                    } else if (ESubjectStatus.Started.getCode().equals(
                        subject.getStatus())
                            || ESubjectStatus.END.getCode().equals(
                                subject.getStatus())) {
                        List<Business> businessList = businessBO
                            .queryCheckedBusinessList(subject.getCode());
                        // 该项目没有确认业务,需显示;
                        if (CollectionUtils.isEmpty(businessList)) {
                            result = subject;
                            break;
                        }
                    }
                }
            }
        }

        if (result == null) {
            // 判断用户是否拥有看该项目的权限，获取从个人公司，业务到项目的列表
            Subject condition = new Subject();
            condition.setUserId(userId);
            List<Subject> subList = subjectBO.queryMySubjectList(condition);
            if (CollectionUtils.isNotEmpty(subList)) {
                for (Subject subject : subList) {
                    if (subject.getCode().equals(subjectCode)) {
                        result = getSubject(subjectCode);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
