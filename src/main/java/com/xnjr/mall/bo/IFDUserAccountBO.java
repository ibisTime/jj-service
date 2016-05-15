/**
 * @Title IFDUserAccountBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午9:37:57 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.enums.EAccountStatus;
import com.xnjr.mall.enums.EBizType;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:37:57 
 * @history:
 */
public interface IFDUserAccountBO extends IPaginableBO<FDUserAccount> {
    /**
     * 获取账户
     * @param accountNumber
     * @return 
     * @create: 2015-5-4 下午5:33:28 miyb
     * @history:
     */
    public FDUserAccount getAccount(String accountNumber);

    /** 
     * 获取账户
     * @param userId
     * @return 
     * @create: 2015-5-6 上午11:18:46 miyb
     * @history: 
     */
    public FDUserAccount getAccountByUserId(String userId);

    /**
     * 获取账户列表
     * @param data
     * @return 
     * @create: 2015-5-4 下午5:33:47 miyb
     * @history:
     */
    public List<FDUserAccount> queryAccountList(FDUserAccount data);

    /**
     * 分配账户
     * @param userId
     * @param realName
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
     * 更新账户余额,无流水(传对象，解决事务)
     * @param fdCompanyAccount 个人账户
     * @param transAmount 发生金额
     * @return 
     * @create: 2016年5月4日 下午4:08:02 xieyj
     * @history:
     */
    public int refreshAmountWithdrawJour(FDUserAccount fdUserAccount,
            Long transAmount);

    /**
     * 更新账户余额，形成不需要对账的流水记录
     * @param accountNumber
     * @param transAmount
     * @param bizType
     * @param refNo
     * @return 
     * @create: 2016年1月18日 下午1:56:19 myb858
     * @history:
     */
    public int refreshAmountWithoutCheck(String accountNumber,
            Long transAmount, String bizType, String refNo);

    /**
     * 更新账户状态
     * @param accountNumber
     * @param status
     * @return 
     * @create: 2015-5-4 下午5:35:31 miyb
     * @history:
     */
    public int refreshStatus(String accountNumber, EAccountStatus status);

    /**
     * 冻结金额（余额减少frezenAmount，冻结金额加上frezenAmount，同时记录2流水）
     * @param accountNumber 账号
     * @param freezeAmount 冻结金额（正数）
     * @param bizType 业务类型
     * @param refNo 关联订单号
     * @return 
     * @create: 2015-5-9 下午3:46:59 miyb
     * @history:
     */
    public void freezeAmount(String accountNumber, Long freezeAmount,
            EBizType bizType, String refNo);

    /**
     * 解冻金额（2种：一解冻的金额不返到余额；二解冻的金额返到余额。前者只记录冻结流水，后者不仅记录冻结流水，还记录资金流水）
     * @param accountNumber 账号
     * @param unfreezeAmount 冻结金额（正数）
     * @param bizType 业务类型
     * @param refNo 关联订单号
     * @param backFlag 是否返回到余额
     * @return 
     * @create: 2015-5-9 下午3:46:59 miyb
     * @history:
     */
    public void unfreezeAmount(String accountNumber, Long unfreezeAmount,
            EBizType bizType, String refNo, boolean backFlag);

}
