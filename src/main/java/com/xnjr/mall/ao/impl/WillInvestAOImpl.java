package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IWillInvestAO;
import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IInvestTableBO;
import com.xnjr.mall.bo.IProjectBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.ISubjectBO;
import com.xnjr.mall.bo.IWillInvestBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.WillInvest;
import com.xnjr.mall.enums.EProjectStatus;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:57:22 
 * @history:
 */
@Service
public class WillInvestAOImpl implements IWillInvestAO {

    @Autowired
    IProjectBO projectBO;

    @Autowired
    IWillInvestBO willInvestBO;

    @Autowired
    IInvestTableBO investTableBO;

    @Autowired
    ISubjectBO subjectBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDAccountBO fdAccountBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    ISYSUserBO sysUserBO;

    @Override
    @Transactional
    public String invest(String userId, String projectCode, Long nowAmount,
            String nowNote, String tradePwd) {
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
        if (!fdUser.getServeList().contains(project.getServe())
                || !fdUser.getQuoteList().contains(project.getQuote())
                || fdUser.getLevel() < project.getLevel()) {
            throw new BizException("XN000000", "当前用户不能认购《" + projectCode
                    + "》标的");
        }
        String code = null;
        // 4.新增认购记录
        code = willInvestBO.saveInvest(fdUser, project, nowAmount, nowNote);
        // 5.发送短信
        smsOutBO.sendSmsOut(fdUser.getMobile(),
            "尊敬的" + PhoneUtil.hideMobile(fdUser.getMobile()) + "用户，您已成功认购《"
                    + project.getName() + "》，工作人员将及时与您联系。",
            ESmsBizType.WillInvest);
        return code;
    }

    @Override
    public Paginable<WillInvest> queryInvestPage(int start, int limit,
            WillInvest condition) {
        return willInvestBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<WillInvest> queryInvestList(WillInvest condition) {
        return willInvestBO.queryInvestList(condition);
    }

    public WillInvest getInvest(String investCode) {
        WillInvest invest = willInvestBO.getInvest(investCode);
        if (invest == null) {
            throw new BizException("XN000001", "认购编号不存在！");
        }
        return invest;
    }

    @Override
    public List<WillInvest> queryMyInvestList(WillInvest condition) {
        List<WillInvest> result = null;
        result = willInvestBO.queryInvestList(condition);
        for (WillInvest invest : result) {
            Project project = projectBO.getProject(invest.getProjectCode());
            Project simpleProject = getProjectSimple(project);
            invest.setProject(simpleProject);
            // 抹去投资字段
            invest.setUserId(null);
            invest.setRealName(null);
            invest.setProjectCode(null);
        }
        return result;
    }

    private Project getProjectSimple(Project project) {
        Project result = null;
        if (project != null) {
            result = new Project();
            result.setCode(project.getCode());
            result.setName(project.getName());
            result.setType(project.getType());
            result.setStatus(project.getStatus());
            result.setServe(project.getServe());
            result.setQuote(project.getQuote());
            result.setQuoteValue1(project.getQuoteValue1());
            result.setQuoteValue2(project.getQuoteValue2());
            result.setLevel(project.getLevel());
            result.setTrader(project.getTrader());
            result.setTraderName(project.getTraderName());
        }
        return result;
    }
}
