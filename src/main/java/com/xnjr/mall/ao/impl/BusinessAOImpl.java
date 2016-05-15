package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.bo.IBusinessBO;
import com.xnjr.mall.bo.IBusinessTableBO;
import com.xnjr.mall.bo.IContractBO;
import com.xnjr.mall.bo.IContractTemplateBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IGSTraderBO;
import com.xnjr.mall.bo.IInvestBO;
import com.xnjr.mall.bo.IInvestTableBO;
import com.xnjr.mall.bo.IProjectBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.ISubjectBO;
import com.xnjr.mall.bo.ITraceBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.BusinessTable;
import com.xnjr.mall.domain.ContractTemplate;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EBusinessStatus;
import com.xnjr.mall.enums.EBusinessVisual;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.enums.EQuote;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.enums.ESubjectStatus;
import com.xnjr.mall.enums.ETraceType;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: wuql
 * @since: 2016年1月19日 下午2:02:37 
 * @history:
 */
@Service
public class BusinessAOImpl implements IBusinessAO {
    @Autowired
    IGSTraderBO gsTraderBO;

    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    IProjectBO projectBO;

    @Autowired
    ISubjectBO subjectBO;

    @Autowired
    IBusinessBO businessBO;

    @Autowired
    IBusinessTableBO businessTableBO;

    @Autowired
    ITraceBO traceBO;

    @Autowired
    IInvestBO investBO;

    @Autowired
    IInvestTableBO investTableBO;

    @Autowired
    IContractBO contractBO;

    @Autowired
    IContractTemplateBO contractTemplateBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Override
    @Transactional
    public String uploadBusiness(String name, Long principal, Long profit,
            String hsbUrl, String hspzUrl, String fjUrl, String startDate,
            String endDate, String applyUser, String remark,
            String subjectCode, List<BusinessTable> list) {
        Subject subject = subjectBO.getSubject(subjectCode);
        if (subject == null) {
            throw new BizException("XN000000", "《" + subjectCode + "》项目不存在");
        }
        if (!ESubjectStatus.Started.getCode().equalsIgnoreCase(
            subject.getStatus())) {
            throw new BizException("XN000000", "《" + subjectCode + "》项目不处于开始阶段");
        }
        // 判断业务本金不大于标的募集金额
        checkPrincipal(subject.getProjectCode(), principal);

        // 保存业务
        EBusinessVisual visual = EBusinessVisual.YES; // 业务是否可见
        if (EQuote.NH_ZRR.getCode().equalsIgnoreCase(subject.getQuote())
                || EQuote.NH_GZR.getCode().equalsIgnoreCase(subject.getQuote())) {
            visual = EBusinessVisual.NO;
        }
        String code = OrderNoGenerater.generateM("BIZ");
        Date startDatetime = DateUtil.strToDate(startDate,
            DateUtil.DATA_TIME_PATTERN_1);
        Date endDatetime = DateUtil.strToDate(endDate,
            DateUtil.DATA_TIME_PATTERN_1);
        businessBO.saveBusiness(code, name, principal, profit, hsbUrl, hspzUrl,
            fjUrl, startDatetime, endDatetime, applyUser, remark, subjectCode,
            visual);
        if (CollectionUtils.isNotEmpty(list)) {
            Date now = new Date();
            for (BusinessTable ele : list) {
                ele.setBusinessCode(code);
                ele.setCreateDatetime(now);
                businessTableBO.saveBusinessTable(ele);
            }
        }
        return code;
    }

    @Override
    @Transactional
    public void reuploadBusiness(String code, String name, Long principal,
            Long profit, String hsbUrl, String hspzUrl, String fjUrl,
            String startDate, String endDate, String applyUser, String remark,
            List<BusinessTable> list) {
        Business business = businessBO.getBusiness(code);
        if (business == null) {
            throw new BizException("XN000000", "《" + code + "》业务不存在");
        }
        if (!EBusinessStatus.CHECK_NO.getCode().equalsIgnoreCase(
            business.getStatus())) {
            throw new BizException("XN000000", "《" + code
                    + "》业务状态不是审核不通过，不能重新提交");
        }
        Subject subject = subjectBO.getSubject(business.getSubjectCode());
        if (subject == null) {
            throw new BizException("XN000000", "《" + business.getSubjectCode()
                    + "》项目不存在");
        }
        // 判断业务本金不大于标的募集金额
        checkPrincipal(subject.getProjectCode(), principal);

        // 更新业务
        Date startDatetime = DateUtil.strToDate(startDate,
            DateUtil.DATA_TIME_PATTERN_1);
        Date endDatetime = DateUtil.strToDate(endDate,
            DateUtil.DATA_TIME_PATTERN_1);
        businessBO.refreshBusiness(code, name, principal, profit, hsbUrl,
            hspzUrl, fjUrl, startDatetime, endDatetime, applyUser, remark);
        // 删除table
        businessTableBO.removeBusinessTable(code);
        // 增加table
        if (CollectionUtils.isNotEmpty(list)) {
            Date now = new Date();
            for (BusinessTable ele : list) {
                ele.setBusinessCode(code);
                ele.setCreateDatetime(now);
                businessTableBO.saveBusinessTable(ele);
            }
        }
    }

    private void checkPrincipal(String projectCode, Long principal) {
        Project project = projectBO.getProject(projectCode);
        if (project == null) {
            throw new BizException("XN000000", "《" + projectCode + "》标的不存在");
        }
        if (project.getAmount().longValue() < principal.longValue()) {
            throw new BizException("XN000000", "业务本金不能大于标的募集金额");
        }
    }

    @Override
    @Transactional
    public void checkBusiness(String businessCode, String checkUser,
            String checkResult, String checkNote, String tradePwd) {
        Business business = getBusiness(businessCode);
        if (!EBusinessStatus.todoCheck.getCode().equalsIgnoreCase(
            business.getStatus())) {
            throw new BizException("XN000000", "《" + businessCode
                    + "》业务不在待审批状态");
        }
        // 检查操盘手的交易密码
        String subjectCode = business.getSubjectCode();
        Subject subject = subjectBO.getSubject(subjectCode);
        if (ESubjectStatus.END.getCode().equals(subject.getStatus())) {
            throw new BizException("XN000000", "《" + businessCode
                    + "》业务所对应的项目已结束");
        }
        sysUserBO.checkTradePwd(subject.getTrader(), tradePwd);
        // 业务审核处理
        if (EBoolean.YES.getCode().equalsIgnoreCase(checkResult)) { // 审核通过
            businessBO.passBusiness(businessCode, checkUser, checkNote);
            // 刷新项目记录
            subjectBO.refreshTotal(subjectCode, subject.getTotalPrincipal()
                    + business.getPrincipal(), subject.getTotalProfit()
                    + business.getProfit());
            // 刷新操盘手记录
            gsTraderBO.refreshTotal(subject.getTrader(),
                business.getPrincipal(), business.getProfit());
            // 形成合同，收款方和受款方合同:搜索这笔业务开始前确认认购列表,再搜打款记录表，形成n份业务收益合同
            Project project = projectBO.getProject(subject.getProjectCode());
            if (project == null) {
                throw new BizException("XN000000", "《"
                        + subject.getProjectCode() + "》标的不存在");
            }
            ContractTemplate contractTemplate = contractTemplateBO
                .getContractTemplate(project.getContractTemplate());
            if (contractTemplate == null) {
                throw new BizException("XN000000", "《"
                        + project.getContractTemplate() + "》合同模板不存在");
            }
            String contractCode = contractBO.generateBusiness(business,
                contractTemplate);
            businessBO.refreshContract(businessCode, contractCode);

            // 跟踪记录企业和业务,打款时间比业务开始时间早的打款方都要关联业务，当然这些都是已确认认购的
            Invest condition = new Invest();
            condition.setSubjectCode(business.getSubjectCode());
            // 搜出已确认的认购
            List<Invest> investList = investBO.queryInvestList(condition);
            if (CollectionUtils.isNotEmpty(investList)) {
                for (Invest invest : investList) {
                    List<InvestTable> investTableList = investTableBO
                        .queryInvestTableList(invest.getCode());
                    for (InvestTable investTable : investTableList) {
                        if (investTable.getLxstartDatetime().before(
                            business.getStartDatetime())) {
                            String companyCode = investTable.getFromCompany();
                            // 默认个体户
                            String type = ETraceType.FIRST2.getCode();
                            // 判断企业编号前端是否是FC
                            if (companyCode.contains(EPrefixOrderNo.company
                                .getCode())) {
                                type = ETraceType.FIRST1.getCode();
                            }
                            // 来方
                            traceBO.saveTrace(companyCode, businessCode, type);
                            // 受方
                            traceBO.saveTrace(investTable.getToCompany(),
                                businessCode, ETraceType.SECOND.getCode());
                        }
                    }
                }
            }
            // 有分成的客户发送短信
            if (EQuote.FC.getCode().equalsIgnoreCase(subject.getQuote())
                    || EQuote.BDFC.getCode().equalsIgnoreCase(
                        subject.getQuote())) {
                sendBusinessSms(business, subjectCode, subject.getName());
            }
        } else {
            businessBO.unpassBusiness(businessCode, checkUser, checkNote);
        }
    }

    private void sendBusinessSms(Business business, String subjectCode,
            String subjectName) {
        List<Invest> investList = investBO
            .queryConfirmedInvestList(subjectCode);
        if (CollectionUtils.isNotEmpty(investList)) {
            for (Invest invest : investList) {
                List<InvestTable> investTableList = investTableBO
                    .queryInvestTableList(invest.getCode());
                for (InvestTable investTable : investTableList) {
                    if (investTable.getLxstartDatetime().before(
                        business.getStartDatetime())) {
                        FDUser fdUser = fdUserBO.getUser(invest.getUserId());
                        // 发送短信
                        smsOutBO.sendSmsOut(fdUser.getMobile(),
                            "尊敬的客户，您认购的《" + subjectName + "》项目有业务提交，本次业务总收益额为"
                                    + business.getProfit() / 1000
                                    + "元。可立即登录生意家moom.cn 跟踪管理。",
                            ESmsBizType.InvestYes);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public List<Business> queryFrontBusinessList(String userId,
            String subjectCode) {
        List<Business> resultList = new ArrayList<Business>();
        // 查询已审核通过，且可见的业务
        Business condition = new Business();
        condition.setSubjectCode(subjectCode);
        condition.setStatus(EBusinessStatus.CHECK_YES.getCode());
        condition.setIsVisual(EBusinessVisual.YES.getCode());
        List<Business> businessList = businessBO.queryBusinessList(condition);
        // 判断该业务和用户跟踪关系关联
        if (CollectionUtils.isNotEmpty(businessList)) {
            for (Business business : businessList) {
                Long count = traceBO.getTotalCountByBussinessAndUser(userId,
                    business.getCode());
                if (count > 0) {
                    resultList.add(business);
                }
            }
        }
        return resultList;
    }

    public Paginable<Business> queryBusinessPage(int start, int limit,
            Business condition) {
        return businessBO.getPaginable(start, limit, condition);
    }

    @Override
    public Business getBusiness(String businessCode) {
        Business business = businessBO.getBusiness(businessCode);
        if (business == null) {
            throw new BizException("XN000000", "《" + businessCode + "》业务不存在");
        }
        return business;
    }
}
