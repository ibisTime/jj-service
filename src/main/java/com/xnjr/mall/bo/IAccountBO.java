/**
 * @Title IAccountBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:15:49 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import com.xnjr.mall.dto.res.XN802012Res;
import com.xnjr.mall.dto.res.XN802013Res;

public interface IAccountBO {

    /**
     * 
     * @param userAccountNumber
     * @param jfAccountNumber
     * @param amount
     * @return 
     * @create: 2016年7月21日 上午10:53:32 xieyj
     * @history:
     */
    public String doChargeOffline(String userAccountNumber,
            String jfAccountNumber, Long amount, String remark);

    /**
     * @param accountNumber
     * @param amount
     * @param fromType
     * @param fromCode
     * @param pdf
     * @param approveUser
     * @param approveNote
     * @param refNo
     * @return 
     * @create: 2016年6月15日 下午6:31:43 xieyj
     * @history:
     */
    public String doChargeOfflineWithoutApp(String accountNumber, Long amount,
            String fromType, String fromCode, String pdf, String approveUser,
            String approveNote, String refNo);

    /**
     * @param accountNumber
     * @param direction
     * @param amount
     * @param fee
     * @param remark
     * @return 
     * @create: 2016年6月12日 下午8:05:07 xieyj
     * @history:
     */
    public String doTransferOss(String accountNumber, String direction,
            Long amount, Long fee, String remark);

    /**
     * @param userId
     * @return 
     * @create: 2016年6月12日 下午9:14:13 xieyj
     * @history:
     */
    public XN802012Res getAccountByUserId(String userId);

    /**
     * @param userId
     * @return 
     * @create: 2016年6月12日 下午9:14:13 xieyj
     * @history:
     */
    public XN802013Res getXNBAccountByUserId(String userId);

    /**
     * @param userId
     * @return 
     * @create: 2016年6月12日 下午9:14:13 xieyj
     * @history:
     */
    public XN802013Res getCNYAccountByUserId(String userId);

}
