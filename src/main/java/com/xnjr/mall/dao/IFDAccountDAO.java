/**
 * @Title IFDAccountDAO.java 
 * @Package com.ibis.account.dao 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:07:37 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDAccount;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:07:37 
 * @history:
 */
public interface IFDAccountDAO extends IBaseDAO<FDAccount> {
    String NAMESPACE = IFDAccountDAO.class.getName().concat(".");

    /** 
     * 修改账户余额
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateAmount(FDAccount data);

    /** 
     * 修改账户冻结金额（一定同时更改账户余额）
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateFrozenAmount(FDAccount data);

    /** 
     * 修改账户状态
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateStatus(FDAccount data);

    public int updateRealName(FDAccount data);

    /**
     * 统计该用户账户总金额
     * @param data
     * @return 
     * @create: 2016年5月1日 下午5:16:50 xieyj
     * @history:
     */
    public Long selectTotalAmount(FDAccount data);
}
