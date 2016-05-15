/**
 * @Title RepayDetailBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月28日 下午2:38:31 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDCompanyBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IRepayDetailBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.InterestUtil;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IRepayDetailDAO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.domain.RepayDetail;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.enums.EQuote;
import com.xnjr.mall.enums.ERepayDetailStatus;
import com.xnjr.mall.enums.ERepayDetailType;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年4月28日 下午2:38:31 
 * @history:
 */
@Component
public class RepayDetailBOImpl extends PaginableBOImpl<RepayDetail> implements
        IRepayDetailBO {

    @Autowired
    private IRepayDetailDAO repayDetailDAO;

    @Autowired
    IFDCompanyBO fdCompanyBO;

    @Autowired
    IFDUserBO fdUserBO;

    /**
     * @see com.xnjr.mall.bo.IRepayDetailBO#cancelSubjectRepay(com.xnjr.mall.domain.InvestTable, java.lang.String, com.xnjr.mall.domain.Subject)
     */
    @Override
    public void cancelSubjectRepay(Invest invest,
            List<InvestTable> investTableList, Subject subject) {
        Date now = new Date();
        if (EQuote.NH_ZRR.getCode().equalsIgnoreCase(subject.getQuote())
                || EQuote.NH_GZR.getCode().equalsIgnoreCase(subject.getQuote())
                || EQuote.BDFC.getCode().equalsIgnoreCase(subject.getQuote())) {// 只有年化相关的,损失利息
            for (InvestTable investTable : investTableList) {
                // 本金
                Long principal = investTable.getAmount();
                RepayDetail bjRepayDetail = new RepayDetail();
                bjRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                bjRepayDetail.setType(ERepayDetailType.BJ.getCode());
                bjRepayDetail.setStatus(ERepayDetailStatus.todoRepay.getCode());
                bjRepayDetail.setTowho(investTable.getFromCompany());
                bjRepayDetail
                    .setTowhoName(getName(investTable.getFromCompany()));

                bjRepayDetail.setRepayDatetime(now);
                bjRepayDetail.setAmount(principal);
                bjRepayDetail.setBusinessProfit(0L);
                bjRepayDetail.setRemark("流项目 本金");
                bjRepayDetail.setSubjectCode(subject.getCode());
                repayDetailDAO.insert(bjRepayDetail);

                // 可能有的年化收益
                Long repayProfit = InterestUtil.getInterest(
                    investTable.getAmount(), subject.getQuoteValue1(),
                    investTable.getLxstartDatetime(), subject.getEndDatetime());// 收益
                RepayDetail lxRepayDetail = new RepayDetail();
                lxRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                lxRepayDetail.setType(ERepayDetailType.LX.getCode());
                lxRepayDetail.setStatus(ERepayDetailStatus.todoRepay.getCode());
                lxRepayDetail.setTowho(investTable.getFromCompany());
                lxRepayDetail
                    .setTowhoName(getName(investTable.getFromCompany()));

                lxRepayDetail.setRepayDatetime(now);
                lxRepayDetail.setAmount(repayProfit);
                lxRepayDetail.setBusinessProfit(0L);
                lxRepayDetail.setRemark("流项目 年化收益");
                lxRepayDetail.setSubjectCode(subject.getCode());
                repayDetailDAO.insert(lxRepayDetail);
            }
        }
    }

    /** 
     * @see com.xnjr.mall.bo.IRepayDetailBO#stopSubjectRepay(com.xnjr.mall.domain.Invest, java.util.List, com.xnjr.mall.domain.Subject)
     */
    @Override
    public void stopSubjectRepay(Invest invest,
            List<InvestTable> investTableList, List<Business> businessList,
            Subject subject) {
        /** 
         * 根据报价模式生成每笔打款的还款计划
         */
        Date now = new Date();
        // 业务总收益计算
        Long businessProfit = 0L;
        for (Business business : businessList) {
            businessProfit = businessProfit + business.getProfit();
        }
        // 年化
        if (EQuote.NH_ZRR.getCode().equalsIgnoreCase(subject.getQuote())
                || EQuote.NH_GZR.getCode().equalsIgnoreCase(subject.getQuote())) {
            for (InvestTable investTable : investTableList) {
                // 生成本次打款的本金还款计划
                Long principal = investTable.getAmount();
                RepayDetail bjRepayDetail = new RepayDetail();
                bjRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                bjRepayDetail.setType(ERepayDetailType.BJ.getCode());
                bjRepayDetail.setStatus(ERepayDetailStatus.todoRepay.getCode());
                bjRepayDetail.setTowho(investTable.getFromCompany());
                bjRepayDetail
                    .setTowhoName(getName(investTable.getFromCompany()));

                bjRepayDetail.setRepayDatetime(now);
                bjRepayDetail.setAmount(principal);
                bjRepayDetail.setRemark("年化本金");
                bjRepayDetail.setBusinessCode(null);
                bjRepayDetail.setSubjectCode(subject.getCode());

                bjRepayDetail.setBusinessProfit(businessProfit);
                repayDetailDAO.insert(bjRepayDetail);

                // 利息还款计划
                Long repayProfit = InterestUtil.getInterest(
                    investTable.getAmount(), subject.getQuoteValue1(),
                    investTable.getLxstartDatetime(), subject.getEndDatetime());// 收益
                RepayDetail lxRepayDetail = new RepayDetail();
                lxRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                lxRepayDetail.setType(ERepayDetailType.LX.getCode());
                lxRepayDetail.setStatus(ERepayDetailStatus.todoRepay.getCode());
                lxRepayDetail.setTowho(investTable.getFromCompany());
                lxRepayDetail
                    .setTowhoName(getName(investTable.getFromCompany()));

                lxRepayDetail.setRepayDatetime(now);
                lxRepayDetail.setAmount(repayProfit);
                lxRepayDetail.setRemark("年化收益");
                lxRepayDetail.setBusinessCode(null);
                lxRepayDetail.setSubjectCode(subject.getCode());

                lxRepayDetail.setBusinessProfit(businessProfit);
                repayDetailDAO.insert(lxRepayDetail);
            }
            // 分成
        } else if (EQuote.FC.getCode().equalsIgnoreCase(subject.getQuote())) {
            for (InvestTable investTable : investTableList) {
                // 生成本次打款的本金还款计划
                Long principal = investTable.getAmount();
                RepayDetail bjRepayDetail = new RepayDetail();
                bjRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                bjRepayDetail.setType(ERepayDetailType.BJ.getCode());
                bjRepayDetail.setStatus(ERepayDetailStatus.todoRepay.getCode());
                bjRepayDetail.setTowho(investTable.getFromCompany());
                bjRepayDetail
                    .setTowhoName(getName(investTable.getFromCompany()));

                bjRepayDetail.setRepayDatetime(now);
                bjRepayDetail.setAmount(principal);
                bjRepayDetail.setRemark("分成本金");
                bjRepayDetail.setBusinessCode(null);
                bjRepayDetail.setSubjectCode(subject.getCode());
                bjRepayDetail.setBusinessProfit(businessProfit);
                repayDetailDAO.insert(bjRepayDetail);

                // 分成
                for (Business business : businessList) {// 跟业务有关
                    RepayDetail fcRepayDetail = new RepayDetail();
                    fcRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                    fcRepayDetail.setType(ERepayDetailType.LX.getCode());
                    fcRepayDetail.setStatus(ERepayDetailStatus.todoRepay
                        .getCode());
                    fcRepayDetail.setTowho(investTable.getFromCompany());
                    fcRepayDetail.setTowhoName(getName(investTable
                        .getFromCompany()));

                    fcRepayDetail.setRepayDatetime(now);
                    fcRepayDetail.setRemark("分成收益");
                    fcRepayDetail.setBusinessCode(business.getCode());
                    fcRepayDetail.setSubjectCode(subject.getCode());

                    fcRepayDetail.setBusinessProfit(business.getProfit());
                    if (investTable.getLxstartDatetime().before(
                        business.getStartDatetime())) {// 投资早于业务开始时间的，才能享受利益
                        Long repayProfit = (long) (business.getProfit()
                                * subject.getQuoteValue1() * principal / business
                            .getPrincipal());
                        fcRepayDetail.setAmount(repayProfit);
                        fcRepayDetail.setRemark("分成收益");
                    } else {
                        fcRepayDetail.setAmount(0L);
                        fcRepayDetail.setRemark("投资迟于业务无分成");
                    }
                    repayDetailDAO.insert(fcRepayDetail);
                }
            }
            // 保底+分成
        } else if (EQuote.BDFC.getCode().equalsIgnoreCase(subject.getQuote())) {
            for (InvestTable investTable : investTableList) {
                // 生成本次打款的本金还款计划
                Long principal = investTable.getAmount();
                RepayDetail bjRepayDetail = new RepayDetail();
                bjRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                bjRepayDetail.setType(ERepayDetailType.BJ.getCode());
                bjRepayDetail.setStatus(ERepayDetailStatus.todoRepay.getCode());
                bjRepayDetail.setTowho(investTable.getFromCompany());
                bjRepayDetail
                    .setTowhoName(getName(investTable.getFromCompany()));

                bjRepayDetail.setRepayDatetime(now);
                bjRepayDetail.setAmount(principal);
                bjRepayDetail.setRemark("保底+分成 本金");
                bjRepayDetail.setBusinessCode(null);
                bjRepayDetail.setSubjectCode(subject.getCode());
                bjRepayDetail.setBusinessProfit(businessProfit);
                repayDetailDAO.insert(bjRepayDetail);

                // 生成本次打款的保底收益还款计划
                Long bdRepayProfit = InterestUtil.getInterest(
                    investTable.getAmount(), subject.getQuoteValue1(),
                    investTable.getLxstartDatetime(), subject.getEndDatetime());// 收益
                RepayDetail bdRepayDetail = new RepayDetail();
                bdRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                bdRepayDetail.setType(ERepayDetailType.LX.getCode());
                bdRepayDetail.setStatus(ERepayDetailStatus.todoRepay.getCode());
                bdRepayDetail.setTowho(investTable.getFromCompany());
                bdRepayDetail
                    .setTowhoName(getName(investTable.getFromCompany()));

                bdRepayDetail.setRepayDatetime(now);
                bdRepayDetail.setAmount(bdRepayProfit);
                bdRepayDetail.setRemark("保底+分成 保底收益");
                bdRepayDetail.setBusinessCode(null);
                bdRepayDetail.setSubjectCode(subject.getCode());
                bdRepayDetail.setBusinessProfit(businessProfit);
                repayDetailDAO.insert(bdRepayDetail);

                // 分成
                Long remainedBaoD = bdRepayProfit;// baoD;
                for (Business business : businessList) {// 跟业务有关
                    RepayDetail fcRepayDetail = new RepayDetail();
                    fcRepayDetail.setCode(OrderNoGenerater.generateME("Repay"));
                    fcRepayDetail.setType(ERepayDetailType.LX.getCode());
                    fcRepayDetail.setStatus(ERepayDetailStatus.todoRepay
                        .getCode());
                    fcRepayDetail.setTowho(investTable.getFromCompany());
                    fcRepayDetail.setTowhoName(getName(investTable
                        .getFromCompany()));

                    fcRepayDetail.setRepayDatetime(now);
                    fcRepayDetail.setRemark("保底+分成 分成收益");
                    fcRepayDetail.setBusinessCode(business.getCode());
                    fcRepayDetail.setSubjectCode(subject.getCode());

                    fcRepayDetail.setBusinessProfit(business.getProfit());

                    if (investTable.getLxstartDatetime().before(
                        business.getStartDatetime())) {// 投资早于业务开始时间的，才能享受利益
                        Long fenC = null;
                        if (business.getProfit() - remainedBaoD <= 0) {
                            fenC = 0L;
                            remainedBaoD = remainedBaoD - business.getProfit();
                        } else {
                            fenC = (long) ((business.getProfit() - remainedBaoD)
                                    * subject.getQuoteValue2() * principal / business
                                .getPrincipal());
                            remainedBaoD = 0L;
                        }

                        fcRepayDetail.setAmount(fenC);
                        fcRepayDetail.setRemark("保底+分成 分成收益");
                    } else {
                        fcRepayDetail.setAmount(0L);
                        fcRepayDetail.setRemark("投资迟于业务无分成");
                    }

                    repayDetailDAO.insert(fcRepayDetail);
                }
            }
        }
    }

    /** 
     * @see com.xnjr.mall.bo.IRepayDetailBO#getRepayDetail(java.lang.String)
     */
    @Override
    public RepayDetail getRepayDetail(String code) {
        RepayDetail repayDetail = null;
        if (StringUtils.isNotBlank(code)) {
            RepayDetail condition = new RepayDetail();
            condition.setCode(code);
            repayDetail = repayDetailDAO.select(condition);
        }
        return repayDetail;
    }

    /** 
     * @see com.xnjr.mall.bo.IRepayDetailBO#isMinusKHProfit(com.xnjr.mall.domain.RepayPlan)
     */
    @Override
    public boolean isMinusKHProfit(RepayDetail repayDetail) {
        RepayDetail condition = new RepayDetail();
        condition.setSubjectCode(repayDetail.getSubjectCode());
        condition.setType(ERepayDetailType.LX.getCode());
        List<RepayDetail> list = repayDetailDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (RepayDetail ele : list) {
                if (!ele.getCode().equalsIgnoreCase(repayDetail.getCode())
                        && !ERepayDetailStatus.todoRepay.getCode()
                            .equalsIgnoreCase(ele.getStatus())) {
                    return false;
                }
            }
            return true;
        } else {
            throw new BizException("XN000000", repayDetail.getSubjectCode()
                    + "项目无对应还款记录");
        }
    }

    private String getName(String fromCompany) {
        String name = null;
        if (fromCompany.startsWith(EPrefixOrderNo.company.getCode())) {
            FDCompany fdCompany = fdCompanyBO.getCompany(fromCompany);
            name = fdCompany.getName();
        } else if (fromCompany.startsWith(EPrefixOrderNo.user.getCode())) {
            FDUser fdUser = fdUserBO.getUser(fromCompany);
            name = fdUser.getRealName();
        }
        return name;
    }

    @Override
    public void repayDetail(RepayDetail repayDetail, String remark,
            ERepayDetailStatus status) {
        repayDetail.setStatus(status.getCode());
        repayDetail.setRealRepayDatetime(new Date());
        repayDetail.setRealAmount(repayDetail.getAmount());
        repayDetail.setRemark(remark);
        repayDetailDAO.repayDetail(repayDetail);
    }

    @Override
    public Long getTotalInvest(List<String> towhoList) {
        RepayDetail condition = new RepayDetail();
        condition.setTowhoList(towhoList);
        condition.setType(ERepayDetailType.BJ.getCode());
        return repayDetailDAO.getTotalInvest(condition);
    }

    @Override
    public Long getTotalProfit(List<String> towhoList) {
        RepayDetail condition = new RepayDetail();
        condition.setTowhoList(towhoList);
        condition.setType(ERepayDetailType.LX.getCode());
        return repayDetailDAO.getTotalProfit(condition);
    }

}
