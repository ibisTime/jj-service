package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.spring.ServiceModule;

/**
 * @author: xieyj 
 * @since: 2016年4月23日 下午5:03:53 
 * @history:
 */
@ServiceModule
public interface IFDAJourAO {
    String DEFAULT_ORDER_COLUMN = "aj_no";

    public Paginable<FDAccountJour> queryAccountJourPage(int start, int limit,
            FDAccountJour condition);

    public Paginable<FDAccountJour> queryFrontAccountJourPage(int start,
            int limit, String userId, FDAccountJour condition);

    /**
     *  对账结果录入：告诉系统哪些交易流水已对账待调帐,此时红冲蓝补的订单已经生成
     * @param ajNo
     * @param type
     * @param checkUser
     * @param amount 
     * @param remark 
     * @create: 2016年1月18日 下午1:37:49 myb858
     * @history:
     */
    public void doCheckJour(Long ajNo, String type, String checkUser,
            Long amount, String remark);

    /**
     * 对账审批:免对账
     * @param hlNo
     * @param updater
     * @param approveResult
     * @param remark 
     * @create: 2016年5月1日 上午11:29:57 xieyj
     * @history:
     */
    public void doApproveCheckJour(String hlNo, String updater,
            String approveResult, String remark);
}
