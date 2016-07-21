package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGoodsOrderDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.GoodsOrder;

/** 
 * @author: zuixian 
 * @since: 2016年7月21日 上午9:43:20 
 * @history:
 */
@Repository("goodsOrderDAOImpl")
public class GoodsOrderDAOImpl extends AMybatisTemplate implements
        IGoodsOrderDAO {

    @Override
    public int insert(GoodsOrder data) {
        return super.insert(NAMESPACE.concat("insert_goodsOrder"), data);
    }

    @Override
    public int delete(GoodsOrder data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public GoodsOrder select(GoodsOrder condition) {
        return super.select(NAMESPACE.concat("select_goodsOrder"), condition,
            GoodsOrder.class);
    }

    @Override
    public Long selectTotalCount(GoodsOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_goodsOrder_count"), condition);
    }

    @Override
    public List<GoodsOrder> selectList(GoodsOrder condition) {
        return super.selectList(NAMESPACE.concat("select_goodsOrder"),
            condition, GoodsOrder.class);
    }

    @Override
    public List<GoodsOrder> selectList(GoodsOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_goodsOrder"), start,
            count, condition, GoodsOrder.class);
    }

    @Override
    public int updateGoodsOrderApprove(GoodsOrder data) {
        return super.update("update_goodsOrderApprove", data);
    }

}
