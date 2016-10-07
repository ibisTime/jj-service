package com.cdkj.service.core;

import java.util.Date;

import com.cdkj.service.common.DateUtil;

public class InterestUtil {

    /**
     * 根据日化率，借款金额，计算每天利息
     * @param amount 金额
     * @param dayRate 日化率
     * @return 
     * @create: 2015年11月17日 上午10:48:06 myb858
     * @history:
     */
    public static Long getDayInterestByDateRate(Long amount, Double dayRate) {
        Long interest = (long) (amount * dayRate);
        return interest;
    }

    public static Long getInterest(Long amount, Double interestRate,
            int interestDays) {
        Long interest = (long) (amount * interestRate * interestDays / 365);
        return interest;
    }

    /**
     * 根据本金，利率(年化)，起息时间和还款时间算利息(适用个金所项目)
     * @param corpus 投资本金
     * @param interestRate 项目年华利率
     * @param interestStartDatetime 起息时间
     * @param repayDatetime 还款时间
     * @return 
     * @create: 2015年11月26日 下午8:28:18 xieyj
     * @history:
     */
    public static Long getInterest(Long corpus, Double interestRate,
            Date interestStartDatetime, Date repayDatetime) {
        int interestDays = DateUtil.daysBetween(interestStartDatetime,
            repayDatetime) + 1;
        Long interest = InterestUtil.getInterest(corpus, interestRate,
            interestDays);

        return interest;
    }
}
