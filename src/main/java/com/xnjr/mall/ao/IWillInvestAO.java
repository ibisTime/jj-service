/**
 * @Title IInvestAO.java 
 * @Package com.xnjr.pop.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 上午11:36:42 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.WillInvest;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:36:42 
 * @history:
 */
@ServiceModule
public interface IWillInvestAO {

    String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 认购
     * @param userId
     * @param projectCode
     * @param nowAmount
     * @param nowNote
     * @param tradePwd
     * @return 
     * @create: 2016年4月26日 上午8:15:20 xieyj
     * @history:
     */
    public String invest(String userId, String projectCode, Long nowAmount,
            String nowNote, String tradePwd);

    /**
     * 分页查询认购记录
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年11月13日 上午11:56:10 xieyj
     * @history:
     */
    public Paginable<WillInvest> queryInvestPage(int start, int limit,
            WillInvest condition);

    /**
     * 查询认购记录列表
     * @param condition
     * @return 
     * @create: 2016年4月26日 下午3:00:56 xieyj
     * @history:
     */
    public List<WillInvest> queryInvestList(WillInvest condition);

    /**
     * 认购详情
     * @param investCode
     * @return 
     * @create: 2016年1月19日 上午11:12:21 wuql
     * @history:
     */
    public WillInvest getInvest(String investCode);

    /**
     * 我投资的项目列表
     * @param condition
     * @return 
     * @create: 2016年1月24日 下午2:26:28 myb858
     * @history:
     */
    public List<WillInvest> queryMyInvestList(WillInvest condition);

}
