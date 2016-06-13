/**
 * @Title IAccountBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:15:49 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import com.xnjr.mall.dto.res.XN802011Res;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:15:49 
 * @history:
 */
public interface IAccountBO {

    /**
     * @param accountNumber
     * @param amount
     * @param fromType
     * @param fromCode
     * @param pdf
     * @param approveUser
     * @param approveNote
     * @return 
     * @create: 2016年6月13日 上午11:37:24 xieyj
     * @history:
     */
    public String doChargeOfflineWithoutApp(String accountNumber, Long amount,
            String fromType, String fromCode, String pdf, String approveUser,
            String approveNote);

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
    public XN802011Res getAccountByUserId(String userId);

}
