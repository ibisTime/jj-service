/**
 * @Title IBankAO.java 
 * @Package com.ibis.account.ao 
 * @Description 
 * @author miyb  
 * @date 2015-6-16 下午4:35:17 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BKBank;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: miyb 
 * @since: 2015-6-16 下午4:35:17 
 * @history:
 */
@ServiceModule
public interface IBKBankAO {
    String DEFAULT_ORDER_COLUMN = "code";

    /** 
     * 新增银行
     * @param data
     * @return 
     * @create: 2015-5-19 下午3:44:46 miyb
     * @history: 
     */
    public String addBKBank(BKBank data);

    /**
     * 删除银行
     * @param bankNo 
     * @create: 2015年3月14日 下午3:32:21 茜茜
     * @history:
     */
    public boolean dropBKBank(String code);

    /** 
     * 更新银行
     * @param data
     * @return 
     * @create: 2015-5-19 下午4:18:50 miyb
     * @history: 
     */
    public boolean editBKBank(BKBank data);

    /** 
     * 按条件分页查询银行
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015-5-19 下午3:27:39 miyb
     * @history: 
     */
    public Paginable<BKBank> queryBKBankPage(int start, int limit,
            BKBank condition);

    /** 
     * 按条件列表查询银行
     * @param condition
     * @return 
     * @create: 2015-5-19 下午3:33:44 miyb
     * @history: 
     */
    public List<BKBank> queryBKBankList(BKBank condition);

    /**
     * 根据code获取银行详情
     * @param code
     * @return 
     * @create: 2016年4月15日 上午10:26:58 xieyj
     * @history:
     */
    public BKBank getBKBank(String code);
}
