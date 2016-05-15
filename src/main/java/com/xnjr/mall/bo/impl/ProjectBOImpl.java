package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IProjectBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dao.IProjectDAO;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4000Req;
import com.xnjr.mall.dto.req.XNyw4001Req;
import com.xnjr.mall.enums.EProjectStatus;
import com.xnjr.mall.enums.EProjectType;
import com.xnjr.mall.exception.BizException;

@Component
public class ProjectBOImpl extends PaginableBOImpl<Project> implements
        IProjectBO {
    @Autowired
    private IProjectDAO projectDAO;

    @Override
    public String applyProject(XNyw4000Req req, GSTrader trader) {
        Project data = new Project();
        String projectCode = OrderNoGenerater.generateM("P");
        data.setCode(projectCode);
        data.setName(req.getName());
        data.setStatus(EProjectStatus.todoAPPROVE.getCode());
        data.setServe(req.getServe());
        data.setQuote(req.getQuote());

        data.setQuoteValue1(StringValidater.toDouble(req.getQuoteValue1()));
        data.setQuoteValue2(StringValidater.toDouble(req.getQuoteValue2()));
        data.setLevel(StringValidater.toInteger(req.getLevel()));
        data.setTotalAmount(StringValidater.toLong(req.getTotalAmount()));
        data.setType(req.getType());

        if (EProjectType.CUSTOM.getCode().equals(req.getType())) {
            data.setTowho(req.getTowho());
        }
        Long amount = StringValidater.toLong(req.getAmount());
        data.setAmount(amount);
        data.setTrader(req.getTrader());

        data.setTraderName(trader.getRealName());
        data.setSummary(req.getSummary());
        data.setDescription(req.getDescription());
        Long minInvestAmount = StringValidater.toLong(req.getMinInvestAmount());
        Long investAmountStep = StringValidater.toLong(req
            .getInvestAmountStep());

        Long maxInvestAmount = StringValidater.toLong(req.getMaxInvestAmount());
        if (maxInvestAmount > amount) {
            throw new BizException("XN000000", "单笔最大投资金额大于募集金额");
        }
        if (minInvestAmount > maxInvestAmount) {
            throw new BizException("XN000000", "最小投资金额大于单笔最大投资金额");
        }
        if (investAmountStep > minInvestAmount) {
            throw new BizException("XN000000", "递增投资金额不能大于最小投资金额");
        }
        if (investAmountStep > (maxInvestAmount - minInvestAmount)) {
            throw new BizException("XN000000", "递增投资金额大于最大投资金额和最小投资金额之差");
        }
        data.setMinInvestAmount(minInvestAmount);
        data.setInvestAmountStep(investAmountStep);
        data.setMaxInvestAmount(maxInvestAmount);
        data.setContractTemplate(StringValidater.toLong(req
            .getContractTemplate()));

        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        data.setRemark(req.getRemark());
        projectDAO.insert(data);
        return projectCode;
    }

    @Override
    public void reapplyProject(XNyw4001Req req, GSTrader trader) {
        Project data = new Project();
        data.setCode(req.getProjectCode());
        data.setName(req.getName());
        data.setStatus(EProjectStatus.todoAPPROVE.getCode());
        data.setServe(req.getServe());
        data.setQuote(req.getQuote());

        data.setQuoteValue1(StringValidater.toDouble(req.getQuoteValue1()));
        data.setQuoteValue2(StringValidater.toDouble(req.getQuoteValue2()));
        data.setLevel(StringValidater.toInteger(req.getLevel()));
        data.setTotalAmount(StringValidater.toLong(req.getTotalAmount()));
        data.setType(req.getType());

        if (EProjectType.CUSTOM.getCode().equals(req.getType())) {
            data.setTowho(req.getTowho());
        }
        Long amount = StringValidater.toLong(req.getAmount());
        data.setAmount(amount);
        data.setTrader(req.getTrader());
        data.setTraderName(trader.getRealName());

        data.setSummary(req.getSummary());
        data.setDescription(req.getDescription());
        Long minInvestAmount = StringValidater.toLong(req.getMinInvestAmount());
        Long investAmountStep = StringValidater.toLong(req
            .getInvestAmountStep());
        Long maxInvestAmount = StringValidater.toLong(req.getMaxInvestAmount());

        if (maxInvestAmount > amount) {
            throw new BizException("XN000000", "单笔最大投资金额大于募集金额");
        }
        if (minInvestAmount > maxInvestAmount) {
            throw new BizException("XN000000", "最小投资金额大于单笔最大投资金额");
        }
        if (investAmountStep > minInvestAmount) {
            throw new BizException("XN000000", "递增投资金额不能大于最小投资金额");
        }
        if (investAmountStep > (maxInvestAmount - minInvestAmount)) {
            throw new BizException("XN000000", "递增投资金额大于最大投资金额和最小投资金额之差");
        }
        data.setMinInvestAmount(minInvestAmount);
        data.setInvestAmountStep(investAmountStep);

        data.setMaxInvestAmount(maxInvestAmount);
        data.setContractTemplate(StringValidater.toLong(req
            .getContractTemplate()));
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        data.setRemark(req.getRemark());

        projectDAO.reapplyProject(data);
    }

    @Override
    public void checkPass(String projectCode, String checkUser,
            String checkNote, Long period, String inputRepayDatetime) {
        Date now = new Date();
        Project data = new Project();
        data.setCode(projectCode);
        data.setCheckUser(checkUser);
        data.setCheckNote(checkNote);
        data.setCheckDatetime(now);
        data.setStatus(EProjectStatus.APPROVE_YES.getCode());
        data.setRemark(EProjectStatus.APPROVE_YES.getValue());

        data.setMjstartDatetime(now);
        data.setPeriod(period);
        int seconds = (int) (period * 3600);
        Date mjendDatetime = DateUtil.getRelativeDate(now, seconds);
        data.setMjendDatetime(mjendDatetime);
        data.setRepayDatetime(DateUtil.getEndDatetime(inputRepayDatetime));
        data.setLoanedAmount(0L);
        projectDAO.checkPass(data);
    }

    @Override
    public void checkUnpass(String projectCode, String checkUser,
            String checkNote) {
        Project data = new Project();
        data.setCode(projectCode);
        data.setCheckUser(checkUser);
        data.setCheckNote(checkNote);
        data.setCheckDatetime(new Date());
        data.setStatus(EProjectStatus.APPROVE_NO.getCode());
        data.setRemark(EProjectStatus.APPROVE_NO.getValue());
        projectDAO.checkUnpass(data);
    }

    @Override
    public void forbidProject(String projectCode, String recheckUser,
            String recheckNote) {
        Project data = new Project();
        data.setCode(projectCode);
        data.setCheckUser(recheckUser);
        data.setCheckNote(recheckNote);
        data.setCheckDatetime(new Date());
        data.setStatus(EProjectStatus.REN_END.getCode());

        data.setRemark(EProjectStatus.REN_END.getValue());
        data.setEndDatetime(new Date());
        projectDAO.forbidProject(data);
    }

    @Override
    public void refreshLoanedAmount(Project project, Long investAmount) {
        project.setLoanedAmount(project.getLoanedAmount() + investAmount);
        projectDAO.updateLoanedAmount(project);
    }

    @Override
    public void refreshStatus(Project project, EProjectStatus projectStatus) {
        if (project != null && StringUtils.isNotBlank(project.getCode())) {
            project.setStatus(projectStatus.getCode());
            projectDAO.refreshStatus(project);
        }
    }

    @Override
    public Project getProject(String projectCode) {
        Project project = null;
        if (StringUtils.isNotBlank(projectCode)) {
            Project condition = new Project();
            condition.setCode(projectCode);
            project = projectDAO.select(condition);
            if (project == null) {
                throw new BizException("XN000000", "编号为" + projectCode
                        + "的项目不存在");
            }
        }
        return project;
    }

    @Override
    public List<Project> queryProjectList(Project condition) {
        return projectDAO.selectList(condition);
    }
}
