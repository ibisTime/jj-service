package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDCompanyAccount;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:07:37 
 * @history:
 */
public interface IFDCompanyAccountDAO extends IBaseDAO<FDCompanyAccount> {
    String NAMESPACE = IFDCompanyAccountDAO.class.getName().concat(".");

    /** 
     * 修改账户余额
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateAmount(FDCompanyAccount data);

    /** 
     * 修改账户冻结金额（一定同时更改账户余额）
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateFrozenAmount(FDCompanyAccount data);

    /** 
     * 修改账户状态
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateStatus(FDCompanyAccount data);
}
