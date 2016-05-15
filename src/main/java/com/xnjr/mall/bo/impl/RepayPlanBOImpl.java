package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IRepayPlanBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IRepayPlanDAO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.RepayPlan;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.EQuote;
import com.xnjr.mall.enums.ERepayDetailStatus;
import com.xnjr.mall.enums.ERepayPlanType;
import com.xnjr.mall.exception.BizException;

@Component
public class RepayPlanBOImpl extends PaginableBOImpl<RepayPlan> implements
        IRepayPlanBO {
    @Autowired
    private IRepayPlanDAO repayPlanDAO;

    @Override
    public void cancelSubjectRepay(Invest invest, Subject subject) {
        if (EQuote.NH_ZRR.getCode().equalsIgnoreCase(subject.getQuote())
                || EQuote.NH_GZR.getCode().equalsIgnoreCase(subject.getQuote())
                || EQuote.BDFC.getCode().equalsIgnoreCase(subject.getQuote())) {// 只有年化相关的,损失利息
            Long principal = invest.getInvestAmount();// 客户本金
            // Long repayProfit = InterestUtil.getInterest(principal,
            // subject.getQuoteValue1(), invest.getLxstartDatetime(),
            // subject.getEndDatetime());// 客户收益
            RepayPlan data = new RepayPlan();
            data.setCode(OrderNoGenerater.generateM("Repay"));
            data.setType(ERepayPlanType.LXM.getCode());
            data.setStatus(ERepayDetailStatus.todoRepay.getCode());
            data.setUserId(invest.getUserId());
            data.setRealName(invest.getRealName());

            data.setRepayDatetime(new Date());
            data.setRepayPrincipal(principal);
            // data.setRepayProfit(repayProfit);
            data.setFee(0L);
            data.setRemark(ERepayPlanType.LXM.getValue());

            data.setInvestCode(invest.getCode());
            data.setBusinessCode(null);
            data.setSubjectCode(subject.getCode());
            data.setBusinessProfit(0L);
            repayPlanDAO.insert(data);
        }
    }

    @Override
    public void stopSubjectRepay(Invest invest, List<Business> businessList,
            Subject subject) {
        Date now = new Date();
        Long principal = invest.getInvestAmount();// 本金
        if (EQuote.NH_ZRR.getCode().equalsIgnoreCase(subject.getQuote())
                || EQuote.NH_GZR.getCode().equalsIgnoreCase(subject.getQuote())) {
            // Long repayProfit = InterestUtil.getInterest(principal,
            // subject.getQuoteValue1(), invest.getLxstartDatetime(),
            // subject.getEndDatetime());// 收益
            RepayPlan data = new RepayPlan();
            data.setCode(OrderNoGenerater.generateM("Repay"));
            data.setType(ERepayPlanType.NH_JS.getCode());
            data.setStatus(ERepayDetailStatus.todoRepay.getCode());
            data.setUserId(invest.getUserId());
            data.setRealName(invest.getRealName());

            data.setRepayDatetime(now);
            data.setRepayPrincipal(principal);
            // data.setRepayProfit(repayProfit);
            data.setFee(0L);
            data.setRemark("年化收益");

            data.setInvestCode(invest.getCode());
            data.setBusinessCode(null);
            data.setSubjectCode(subject.getCode());
            Long businessProfit = 0L;
            for (Business business : businessList) {
                businessProfit = businessProfit + business.getProfit();
            }
            data.setBusinessProfit(businessProfit);
            repayPlanDAO.insert(data);

        } else if (EQuote.FC.getCode().equalsIgnoreCase(subject.getQuote())) {
            for (Business business : businessList) {// 跟业务有关
                RepayPlan data = new RepayPlan();
                data.setCode(OrderNoGenerater.generateM("Repay"));
                data.setType(ERepayPlanType.FC_JS.getCode());
                data.setStatus(ERepayDetailStatus.todoRepay.getCode());
                data.setUserId(invest.getUserId());
                data.setRealName(invest.getRealName());

                data.setRepayDatetime(now);
                data.setRepayPrincipal(principal);
                data.setFee(0L);

                data.setInvestCode(invest.getCode());
                data.setBusinessCode(business.getCode());
                data.setSubjectCode(subject.getCode());
                data.setBusinessProfit(business.getProfit());
                // if (invest.getLxstartDatetime().before(
                // business.getStartDatetime())) {// 投资早于业务开始时间的，才能享受利益
                // Long repayProfit = (long) (business.getProfit()
                // * subject.getQuoteValue1() * principal / business
                // .getPrincipal());
                // data.setRepayProfit(repayProfit);
                // data.setRemark("分成收益");
                // } else {
                // data.setRepayProfit(0L);
                // data.setRemark("投资迟于业务无分成");
                // }
                repayPlanDAO.insert(data);
            }
        } else if (EQuote.BDFC.getCode().equalsIgnoreCase(subject.getQuote())) {
            // Long baoD = InterestUtil.getInterest(principal,
            // subject.getQuoteValue1(), invest.getLxstartDatetime(),
            // subject.getEndDatetime());
            RepayPlan data = new RepayPlan();
            data.setCode(OrderNoGenerater.generateM("Repay"));
            data.setType(ERepayPlanType.BDFC_JS.getCode());
            data.setStatus(ERepayDetailStatus.todoRepay.getCode());
            data.setUserId(invest.getUserId());
            data.setRealName(invest.getRealName());

            data.setRepayDatetime(now);
            data.setRepayPrincipal(principal);
            // data.setRepayProfit(baoD);
            data.setFee(0L);
            data.setRemark("保底收益");

            data.setInvestCode(invest.getCode());
            data.setBusinessCode(null);
            data.setSubjectCode(subject.getCode());
            data.setBusinessProfit(0L);
            repayPlanDAO.insert(data);
            // 分成部分
            Long remainedBaoD = null;// baoD;
            for (Business business : businessList) {// 跟业务有关
                RepayPlan data1 = new RepayPlan();
                data1.setCode(OrderNoGenerater.generateM("Repay"));
                data1.setType(ERepayPlanType.BDFC_JS.getCode());
                data1.setStatus(ERepayDetailStatus.todoRepay.getCode());
                data1.setUserId(invest.getUserId());
                data1.setRealName(invest.getRealName());

                data1.setRepayDatetime(now);
                data1.setRepayPrincipal(principal);
                data1.setFee(0L);

                data1.setInvestCode(invest.getCode());
                data1.setBusinessCode(business.getCode());
                data1.setSubjectCode(subject.getCode());
                data1.setBusinessProfit(business.getProfit());

                // if (invest.getLxstartDatetime().before(
                // business.getStartDatetime())) {// 投资早于业务开始时间的，才能享受利益
                // Long fenC = null;
                // if (business.getProfit() - remainedBaoD <= 0) {
                // fenC = 0L;
                // remainedBaoD = remainedBaoD - business.getProfit();
                // } else {
                // fenC = (long) ((business.getProfit() - remainedBaoD)
                // * subject.getQuoteValue2() * principal / business
                // .getPrincipal());
                // remainedBaoD = 0L;
                // }
                //
                // data1.setRepayProfit(fenC);
                // data1.setRemark("分成收益");
                // } else {
                // data1.setRepayProfit(0L);
                // data1.setRemark("投资迟于业务无分成");
                // }
                repayPlanDAO.insert(data1);
            }
        }
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        RepayPlan repayPlan = null;
        if (StringUtils.isNotBlank(code)) {
            RepayPlan condition = new RepayPlan();
            condition.setCode(code);
            repayPlan = repayPlanDAO.select(condition);
        }
        return repayPlan;
    }

    @Override
    public void repayAll(RepayPlan repayPlan, String remark,
            ERepayDetailStatus status) {
        repayPlan.setStatus(status.getCode());
        repayPlan.setRealRepayDatetime(new Date());
        repayPlan.setRealRepayPrincipal(repayPlan.getRepayPrincipal());
        repayPlan.setRealRepayProfit(repayPlan.getRepayProfit());
        repayPlan.setRealFee(repayPlan.getFee());
        repayPlan.setRemark(remark);
        repayPlanDAO.repayAll(repayPlan);
    }

    @Override
    public RepayPlan sumPP(String userId) {
        RepayPlan repayPlan = null;
        if (StringUtils.isNotBlank(userId)) {
            RepayPlan condition = new RepayPlan();
            condition.setUserId(userId);
            repayPlan = repayPlanDAO.sumPP(condition);
        }
        return repayPlan;
    }

    @Override
    public boolean isMinusKHProfitBak(RepayPlan repayPlan) {
        if (ERepayPlanType.LXM.getCode().equalsIgnoreCase(repayPlan.getType())) {
            return true;
        }
        if (ERepayPlanType.NH_JS.getCode()
            .equalsIgnoreCase(repayPlan.getType())) {// 同一个项目多次投资的情况。做一次利益相减
            RepayPlan condition = new RepayPlan();
            condition.setSubjectCode(repayPlan.getSubjectCode());
            List<RepayPlan> list = repayPlanDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                for (RepayPlan ele : list) {
                    if (!ele.getCode().equalsIgnoreCase(repayPlan.getCode())
                            && !ERepayDetailStatus.todoRepay.getCode()
                                .equalsIgnoreCase(ele.getStatus())) {
                        return false;
                    }
                }
                return true;
            } else {
                throw new BizException("XN000000", repayPlan.getSubjectCode()
                        + "项目无对应还款记录");
            }
        }
        if (ERepayPlanType.FC_JS.getCode()
            .equalsIgnoreCase(repayPlan.getType())) {// 多次业务多次投资：一次业务做一次相减
            return true;
        }

        if (ERepayPlanType.BDFC_JS.getCode().equalsIgnoreCase(
            repayPlan.getType())) {
            if (repayPlan.getRepayProfit() == 0) {
                return false;
            }
            return true;
        }
        throw new BizException("XN000000", repayPlan.getCode() + "还款错误");

    }

    /** 
     * @see com.xnjr.mall.bo.IRepayPlanBO#isMinusKHProfitBak(com.xnjr.mall.domain.RepayPlan)
     */
    @Override
    public boolean isMinusKHProfit(RepayPlan repayPlan) {
        if (ERepayPlanType.LXM.getCode().equalsIgnoreCase(repayPlan.getType())) {
            return true;
        }
        if (ERepayPlanType.NH_JS.getCode()
            .equalsIgnoreCase(repayPlan.getType())
                || ERepayPlanType.FC_JS.getCode().equalsIgnoreCase(
                    repayPlan.getType())
                || ERepayPlanType.BDFC_JS.getCode().equalsIgnoreCase(
                    repayPlan.getType())) {
            RepayPlan condition = new RepayPlan();
            condition.setSubjectCode(repayPlan.getSubjectCode());
            List<RepayPlan> list = repayPlanDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                for (RepayPlan ele : list) {
                    if (!ele.getCode().equalsIgnoreCase(repayPlan.getCode())
                            && !ERepayDetailStatus.todoRepay.getCode()
                                .equalsIgnoreCase(ele.getStatus())) {
                        return false;
                    }
                }
                return true;
            } else {
                throw new BizException("XN000000", repayPlan.getSubjectCode()
                        + "项目无对应还款记录");
            }
        }
        throw new BizException("XN000000", repayPlan.getCode() + "还款错误");
    }

    @Override
    public boolean isNeedPrincipal(RepayPlan repayPlan) {
        if (ERepayPlanType.LXM.getCode().equalsIgnoreCase(repayPlan.getType())
                || ERepayPlanType.NH_JS.getCode().equalsIgnoreCase(
                    repayPlan.getType())) {
            return true;
        } else {// 分成和保底+分成。同一次投资还一次
            RepayPlan condition = new RepayPlan();
            condition.setInvestCode(repayPlan.getInvestCode());
            List<RepayPlan> list = repayPlanDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                for (RepayPlan ele : list) {
                    if (!ele.getCode().equalsIgnoreCase(repayPlan.getCode())
                            && !ERepayDetailStatus.todoRepay.getCode()
                                .equalsIgnoreCase(ele.getStatus())) {
                        return false;
                    }
                }
                return true;
            } else {
                throw new BizException("XN000000", repayPlan.getInvestCode()
                        + "投资无对应还款记录");
            }
        }
    }
}
