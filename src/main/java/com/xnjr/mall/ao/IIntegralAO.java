package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Integral;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午10:39:37 
 * @history:
 */
public interface IIntegralAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 添加积分二维码
     * @param data
     * @return 
     * @create: 2016年7月20日 下午6:23:49 xieyj
     * @history:
     */
    public String addIntegral(Integral data);

    /**
     * 删除积分二维码
     * @param code
     * @return 
     * @create: 2016年7月26日 下午1:22:41 xieyj
     * @history:
     */
    public int dropIntegral(String code);

    /**
     * 上架/下架积分二维码
     * @param code
     * @param updater
     * @param updateResult
     * @param remark
     * @return 
     * @create: 2016年7月22日 上午10:55:10 xieyj
     * @history:
     */
    public int approveIntegral(String code, String updater,
            String updateResult, String remark);

    /**
     * 扫一扫加积分二维码
     * @param code
     * @param userId
     * @return 
     * @create: 2016年7月21日 上午8:57:18 xieyj
     * @history:
     */
    public void bugIntegral(String code, String userId);

    /**
     * 积分分页查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public Paginable<Integral> queryIntegralPage(int start, int limit,
            Integral condition);

    /**
     * 积分列表查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public List<Integral> queryIntegralList(Integral condition);

    /**
     * 积分详情
     * @param code
     * @return 
     * @create: 2016年5月24日 上午9:07:33 xieyj
     * @history:
     */
    public Integral getIntegral(String code);
}
