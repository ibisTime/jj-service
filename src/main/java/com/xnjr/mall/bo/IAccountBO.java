/**
 * @Title IAccountBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:15:49 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:15:49 
 * @history:
 */
public interface IAccountBO {

    /**
     * 转入转出(front)
     * @param accountNumber
     * @param direction
     * @param amount
     * @param fee
     * @param remark
     * @param tradePwd 
     * @create: 2016年5月31日 下午5:48:42 xieyj
     * @history:
     */
    public void transferOrder(String accountNumber, String direction,
            Long amount, Long fee, String remark, String tradePwd);

}
