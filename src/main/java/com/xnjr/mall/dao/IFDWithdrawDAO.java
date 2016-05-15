package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDWithdraw;

/**
 * 取现
 * @author: duanjiewen
 * @since: 2016年4月19日 下午2:39:52 
 * @history:
 */
public interface IFDWithdrawDAO extends IBaseDAO<FDWithdraw> {
    String NAMESPACE = IFDWithdrawDAO.class.getName().concat(".");

    /**
     * 审核取现订单
     * @param data
     * @return 
     * @create: 2016年4月19日 下午2:43:21 duanjiewen
     * @history:
     */
    public int updateApproveOrder(FDWithdraw data);

    /**
     * 支付取现订单
     * @param data
     * @return 
     * @create: 2016年4月19日 下午2:44:03 duanjiewen
     * @history:
     */
    public int updatePayOrder(FDWithdraw data);

    /**
     * 对账
     * @param data
     * @return 
     * @create: 2016年4月19日 下午2:44:49 duanjiewen
     * @history:
     */
    public int updateCheckOrder(FDWithdraw data);
}
