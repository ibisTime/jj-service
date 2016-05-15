package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.GSTrader;

public interface IGSTraderDAO extends IBaseDAO<GSTrader> {
    String NAMESPACE = IGSTraderDAO.class.getName().concat(".");

    public int update(GSTrader data);

    /** 
     * 更新手机号
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateMobile(GSTrader data);

    /** 
     * 重置交易密码
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateTradePwd(GSTrader data);

    /**
     * 刷新累计交易金额
     * @param data
     * @return 
     * @create: 2016年1月24日 下午4:09:53 myb858
     * @history:
     */

    public int updateTotal(GSTrader data);

}
