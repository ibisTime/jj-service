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
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:36:42 
 * @history:
 */
@ServiceModule
public interface IInvestAO {

    String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 认购
     * @param userId
     * @param projectCode
     * @param investAmount
     * @param tradePwd
     * @return 
     * @create: 2016年1月19日 下午7:35:52 myb858
     * @history:
     */
    public String invest(String userId, String projectCode, Long investAmount,
            String tradePwd);

    /**
     * 确认认购
     * @param investCode
     * @param investAmount
     * @param tradePwd
     * @param remark 
     * @create: 2016年1月27日 下午3:43:07 myb858
     * @history:
     */
    public void confirmInvest(String investCode, Long investAmount,
            String tradePwd, String remark);

    /**
     * 取消认购
     * @param investCode
     * @param tradePwd
     * @param remark 
     * @create: 2016年1月19日 下午8:22:22 myb858
     * @history:
     */
    public void cancelInvest(String investCode, String tradePwd, String remark);

    /**
     * 分页查询认购记录
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年11月13日 上午11:56:10 xieyj
     * @history:
     */
    public Paginable<Invest> queryInvestPage(int start, int limit,
            Invest condition);

    /**
     * 查询认购记录
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年11月13日 上午11:56:10 xieyj
     * @history:
     */
    public List<Invest> queryInvestList(Invest condition);

    /**
     * 认购详情
     * @param investCode
     * @return 
     * @create: 2016年1月19日 上午11:12:21 wuql
     * @history:
     */
    public Invest getInvest(String investCode);

    /**
     * 我投资的项目列表
     * @param userId
     * @param status
     * @return 
     * @create: 2016年5月2日 下午6:01:42 xieyj
     * @history:
     */
    public List<Subject> queryMySubjectList(String userId, String status);

    /**
     * 我投资的项目列表,分两部分，1：认购+标的列表展示；2：已确认认购后，去展示项目信息(项目需根据业务反推)
     * @param condition
     * @return 
     * @create: 2016年1月24日 下午2:26:28 myb858
     * @history:
     */
    public List<Object> queryMyInvestSubjectList(String userId);

    /**
     * 我投资的投资列表
     * @param condition
     * @return 
     * @create: 2016年1月24日 下午2:26:28 myb858
     * @history:
     */
    public List<Invest> queryMyInvestList(Invest condition);

}
