package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.BuyGuide;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午10:39:37 
 * @history:
 */
public interface IBuyGuideAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 新增
     * @param data
     * @return 
     * @create: 2015年8月27日 下午2:22:02 xieyj
     * @history:
     */
    public String addBuyGuide(BuyGuide data);

    /**
     * 修改
     * @param data
     * @return 
     * @create: 2015年8月27日 下午2:22:25 xieyj
     * @history:
     */
    public int editBuyGuide(BuyGuide data);

    /**
     * 分页查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public Paginable<BuyGuide> queryBuyGuidePage(int start, int limit,
            BuyGuide condition);

    /**
     * 列表查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public List<BuyGuide> queryBuyGuideList(BuyGuide condition);

    /**
     * 详情
     * @param code
     * @return 
     * @create: 2016年5月24日 上午9:07:33 xieyj
     * @history:
     */
    public BuyGuide getBuyGuide(String code);

}
