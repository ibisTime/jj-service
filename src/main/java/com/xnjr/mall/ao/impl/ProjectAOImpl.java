package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.bo.IContractBO;
import com.xnjr.mall.bo.IContractTemplateBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.IGSTraderBO;
import com.xnjr.mall.bo.IProjectBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.base.Page;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4000Req;
import com.xnjr.mall.dto.req.XNyw4001Req;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.enums.EProjectStatus;
import com.xnjr.mall.enums.EProjectType;
import com.xnjr.mall.enums.EServe;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.exception.BizException;

@Service
public class ProjectAOImpl implements IProjectAO {
    static Logger logger = Logger.getLogger(ProjectAOImpl.class);

    @Autowired
    IProjectBO projectBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IContractTemplateBO contractTemplateBO;

    @Autowired
    IContractBO contractBO;

    @Autowired
    IGSTraderBO gsTraderBO;

    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    @Override
    @Transactional
    public String applyProject(XNyw4000Req req) {
        GSTrader trader = gsTraderBO.getGSTrader(req.getTrader());
        if (trader == null) {
            throw new BizException("XN000001", "操盘手编号不存在！");
        }
        String projectCode = projectBO.applyProject(req, trader);
        return projectCode;
    }

    @Override
    @Transactional
    public void reapplyProject(XNyw4001Req req) {
        GSTrader trader = gsTraderBO.getGSTrader(req.getTrader());
        if (trader == null) {
            throw new BizException("XN000001", "操盘手编号不存在！");
        }
        projectBO.reapplyProject(req, trader);
    }

    @Override
    @Transactional
    public void checkProject(String projectCode, String checkUser,
            String checkResult, String checkNote, String tradePwd, Long period,
            String repayDatetime) {
        Project project = projectBO.getProject(projectCode);
        if (project == null) {
            throw new BizException("XN000001", "标的编号不存在！");
        }
        if (!EProjectStatus.todoAPPROVE.getCode().equals(project.getStatus())) {
            throw new BizException("XN000001", "该标的不处于待审核状态！");
        }
        String traderUser = project.getTrader();
        // 判断操盘手是否存在
        GSTrader trader = gsTraderBO.getGSTrader(traderUser);
        // 检查操盘手的交易密码
        sysUserBO.checkTradePwd(traderUser, tradePwd);
        // 处理标的
        if (EBoolean.YES.getCode().equalsIgnoreCase(checkResult)) { // 审批通过
            // 更新标的初审4字段和状态
            projectBO.checkPass(projectCode, checkUser, checkNote, period,
                repayDatetime);
            // 发送短信
            smsOutBO.sendSmsOut(trader.getMobile(),
                "您所发起的标的《" + project.getName() + "》已通过审核，开始募集。",
                ESmsBizType.MOOM_startMJ);
            // 给合适客户发送短信
            sendSmsUsers(project);
        } else {// 审核不通过
                // 更新标的初审4字段和状态
            projectBO.checkUnpass(projectCode, checkUser, checkNote);
            // 发送短信
            smsOutBO.sendSmsOut(trader.getMobile(),
                "您所发起的标的《" + project.getName() + "》因" + checkNote + "未能通过审核。",
                ESmsBizType.MOOM_reapplyProject);
        }
    }

    // 给客户发送短信
    private void sendSmsUsers(Project project) {
        List<FDUser> fdUserList = fdUserBO.queryUserList(null);
        if (CollectionUtils.isNotEmpty(fdUserList)) {
            if (EProjectType.CUSTOM.getCode().equals(project.getType())) {
                // 给所属企业的人发短信
                FDUserCompany condition = new FDUserCompany();
                condition.setCompanyCode(project.getTowho());
                condition.setStatus(EKYCStatus.KYC_YES.getCode());
                List<FDUser> fdUserCompanyList = fdUserCompanyBO
                    .queryUserList(condition);
                for (FDUser fdUser : fdUserCompanyList) {
                    // 给拥有这家公司的人发短信
                    smsOutBO.sendSmsOut(fdUser.getMobile(), "尊敬的客户，生意家平台新发布"
                            + EServe.getServeMap().get(project.getServe())
                                .getValue() + "类《" + project.getName()
                            + "》标的。可立即登录生意家moom.cn 查看标的详情",
                        ESmsBizType.MOOM_startMJ);
                }
            } else {
                for (FDUser fdUser : fdUserList) {
                    if (StringUtils.isBlank(fdUser.getServeList())
                            || StringUtils.isBlank(fdUser.getQuoteList())
                            || fdUser.getLevel() == null) {
                        continue;
                    }
                    if (fdUser.getServeList().contains(project.getServe())
                            && fdUser.getQuoteList().contains(
                                project.getQuote())
                            && fdUser.getLevel() >= project.getLevel()) {
                        // 给有权限的人发送
                        smsOutBO.sendSmsOut(
                            fdUser.getMobile(),
                            "尊敬的客户，生意家平台新发布"
                                    + EServe.getServeMap()
                                        .get(project.getServe()).getValue()
                                    + "类《" + project.getName()
                                    + "》标的。可立即登录生意家moom.cn 查看标的详情",
                            ESmsBizType.MOOM_startMJ);
                    }
                }
            }
        }
    }

    @Override
    @Transactional
    public void forbidProject(String projectCode, String checkUser,
            String checkNote, String tradePwd) {
        Project project = projectBO.getProject(projectCode);
        if (project == null) {
            throw new BizException("XN000001", "标的编号不存在！");
        }
        // 检查操盘手的交易密码
        sysUserBO.checkTradePwd(project.getTrader(), tradePwd);
        projectBO.forbidProject(projectCode, checkUser, checkNote);
    }

    @Override
    public Paginable<Project> queryProjectPage(int start, int limit,
            Project condition) {
        return projectBO.getPaginable(start, limit, condition);
    }

    @Override
    public Page<Project> queryProjectPage(int start, int limit,
            Project condition, String userId) {
        Page<Project> returnPage = null;
        List<Project> returnList = new ArrayList<Project>();
        FDUser fdUser = fdUserBO.getUser(userId);
        if (StringUtils.isBlank(fdUser.getServeList())
                || StringUtils.isBlank(fdUser.getQuoteList())
                || fdUser.getLevel() == null) {
            throw new BizException("XN000000", "当前用户无权限，无法查看标的");
        }

        List<Project> list = projectBO.queryProjectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Project ele : list) {
                // 根据客户的“服务列表”+“报价列表”+“客户等级”并集过滤
                if (fdUser.getServeList().contains(ele.getServe())
                        && fdUser.getQuoteList().contains(ele.getQuote())
                        && fdUser.getLevel() >= ele.getLevel()) {
                    if (EProjectType.CUSTOM.getCode().equals(ele.getType())) {
                        if (!fdUserCompanyBO.isContainCompany(userId,
                            ele.getTowho())) {
                            continue;
                        }
                    }
                    returnList.add(ele);
                }
            }
        }
        int totalCount = returnList.size();
        returnPage = new Page<Project>(start, limit, totalCount);
        if ((returnPage.getStart() + limit) > totalCount) {
            returnPage.setList(returnList.subList(returnPage.getStart(),
                totalCount));
        } else {
            returnPage.setList(returnList.subList(returnPage.getStart(),
                returnPage.getStart() + limit));
        }
        return returnPage;
    }

    @Override
    public List<Project> queryProjectList(Project condition, String userId) {
        List<Project> returnlist = new ArrayList<Project>();
        FDUser fdUser = fdUserBO.getUser(userId);
        if (StringUtils.isBlank(fdUser.getServeList())
                || StringUtils.isBlank(fdUser.getQuoteList())
                || fdUser.getLevel() == null) {
            throw new BizException("XN000000", "当前用户无权限，无法查看标的");
        }

        List<Project> list = projectBO.queryProjectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Project ele : list) {
                // 根据客户的“服务列表”+“报价列表”+“客户等级”并集过滤
                if (fdUser.getServeList().contains(ele.getServe())
                        && fdUser.getQuoteList().contains(ele.getQuote())
                        && fdUser.getLevel() >= ele.getLevel()) {
                    if (EProjectType.CUSTOM.getCode().equals(ele.getType())) {
                        if (!fdUserCompanyBO.isContainCompany(userId,
                            ele.getTowho())) {
                            continue;
                        }
                    }
                    returnlist.add(ele);
                }
            }
        }
        return returnlist;
    }

    @Override
    public List<Project> queryProjectList(Project condition) {
        return projectBO.queryProjectList(condition);
    }

    @Override
    public Project getProject(String projectCode) {
        return projectBO.getProject(projectCode);
    }

    @Override
    public Project getProject(String projectCode, String userId) {
        Project returnProject = null;
        Project project = projectBO.getProject(projectCode);
        if (project == null) {
            throw new BizException("XN000001", "标的编号不存在！");
        }
        // 根据客户的“服务列表”+“报价列表”+“客户等级”并集过滤
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("XN000001", "用户编号不存在！");
        }
        if (fdUser.getServeList().contains(project.getServe())
                && fdUser.getQuoteList().contains(project.getQuote())
                && fdUser.getLevel() >= project.getLevel()) {
            if (EProjectType.CUSTOM.getCode().equals(project.getType())) {
                if (fdUserCompanyBO
                    .isContainCompany(userId, project.getTowho())) {
                    returnProject = project;
                }
            } else {
                returnProject = project;
            }
        }
        return returnProject;
    }

    @Override
    public Long previewInterest(String projectCode, Long investAmount,
            Date investDatetime) {
        // Project project = projectBO.getProject(projectCode);
        // Double interestRate = project.getInterestRate();
        // Date interestStartDatetime =
        // DateUtil.getTomorrowStart(investDatetime);
        // int interestDays = DateUtil.daysBetween(interestStartDatetime,
        // project.getRepayDatetime()) + 1;
        // Long interest = (long) (investAmount * interestDays * interestRate);
        // return interest;
        return null;
    }

    @Override
    public void changeDaily() {
        logger.info("标的自动开始");
        Project condition = new Project();
        condition.setStatus(EProjectStatus.APPROVE_YES.getCode());
        condition.setMjendDatetimeEnd(new Date());
        int start = 1;
        int limit = 5;
        while (true) {
            Paginable<Project> page = projectBO.getPaginable(start, limit,
                condition);
            if (page != null && page.getList() != null) {
                List<Project> list = page.getList();
                for (Project ele : list) {
                    doForDaily(ele);
                }
                start++;
                if (list.size() < limit) {
                    break;
                }
            }
        }
        logger.info("标的自动结束");
    }

    @Transactional
    private void doForDaily(Project ele) {
        try {
            projectBO.refreshStatus(ele, EProjectStatus.LI_END);
        } catch (Exception e) {
            logger.info("标的" + ele.getCode() + "失败");
        }
    }
}
