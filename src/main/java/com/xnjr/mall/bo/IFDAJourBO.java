/**
 * @Title IAJourBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:19:46 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.enums.EBoolean;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:19:46 
 * @history:
 */
public interface IFDAJourBO extends IPaginableBO<FDAccountJour> {
    /**
     * 对账结果录入
     * @param aJNo
     * @param checkUser
     * @param checkResult
     * @return 
     * @create: 2016年1月15日 下午2:44:53 myb858
     * @history:
     */
    public int doCheckAccount(Long aJNo, String checkUser, EBoolean checkResult);

    /**
     * 形成账户流水
     * @param accountNumber
     * @param preAmount
     * @param amount
     * @param bizType
     * @param refNo
     * @param remark 
     * @create: 2016年5月4日 下午5:11:37 xieyj
     * @history:
     */
    public void addJour(String accountNumber, Long preAmount, Long amount,
            String bizType, String refNo, String remark);

    /**
     * 获取单条账户流水记录
     * @param ajNo
     * @return 
     * @create: 2015-5-5 上午11:21:13 miyb
     * @history:
     */
    public FDAccountJour getAccountJour(Long ajNo);

    /**
     * 获取账户流水列表
     * @param condition
     * @return 
     * @create: 2015-5-5 上午11:21:44 miyb
     * @history:
     */
    public List<FDAccountJour> queryAccountJourList(FDAccountJour condition);
}
