/**
 * @Title IGoodsAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午1:11:19 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Goods;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午1:11:19 
 * @history:
 */
public interface IGoodsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 货详情查询
     * @param code
     * @return 
     * @create: 2016年5月29日 下午1:23:14 haiqingzheng
     * @history:
     */
    public Goods getGoods(String code);

    /**
     * 货分页查询
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年5月29日 下午1:23:01 haiqingzheng
     * @history:
     */
    public Paginable<Goods> queryGoodsPage(int start, int limit, Goods condition);

    /**
     * 根据货的型号，获取货起始编号
     * @param modelCode
     * @return 
     * @create: 2016年5月29日 下午1:24:47 haiqingzheng
     * @history:
     */
    public String getGoodsCodeStart(String modelCode);
}
