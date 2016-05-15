/**
 * @Title IFDAccountBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:15:49 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDAccount;
import com.xnjr.mall.enums.EAccountStatus;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:15:49 
 * @history:
 */
public interface IFDAccountBO extends IPaginableBO<FDAccount> {
    /**
     * 获取账户
     * @param accountNumber
     * @return 
     * @create: 2015-5-4 下午5:33:28 miyb
     * @history:
     */
    public FDAccount getAccount(String accountNumber);

    /** 
     * 获取账户
     * @param userId
     * @return 
     * @create: 2015-5-6 上午11:18:46 miyb
     * @history: 
     */
    public FDAccount getAccountByUserId(String userId);

    /**
     * 获取账户列表
     * @param data
     * @return 
     * @create: 2015-5-4 下午5:33:47 miyb
     * @history:
     */
    public List<FDAccount> queryAccountList(FDAccount data);

    /**
     * 分配账户
     * @param userId
     * @param currency
     * @return 
     * @create: 2015-5-4 下午5:34:16 miyb
     * @history:
     */
    public String distributeAccount(String userId, String realName,
            String currency);

    /**
     * 更新账户余额，形成需要对账的流水记录
     * @param accountNumber 账号
     * @param transAmount 账户余额的发生金额(有正负之分)
     * @param bizType 业务类型
     * @param refNo 关联订单号
     * @param remark
     * @return 
     * @create: 2015-5-4 下午5:34:37 miyb
     * @history:
     */
    public int refreshAmount(String accountNumber, Long transAmount,
            String bizType, String refNo, String remark);

    /**
     * 根据用户编号更新账户余额，不形成流水记录
     * @param userId
     * @return 
     * @create: 2016年5月1日 下午5:45:56 xieyj
     * @history:
     */
    public int refreshAmountWithoutJour(String userId);

    /**
     * 更新账户状态
     * @param accountNumber
     * @param status
     * @return 
     * @create: 2015-5-4 下午5:35:31 miyb
     * @history:
     */
    public int refreshStatus(String accountNumber, EAccountStatus status);

    public void refreshRealName(String userId, String realName);

    public Long getTotalAccountAmount(String userId);
}
