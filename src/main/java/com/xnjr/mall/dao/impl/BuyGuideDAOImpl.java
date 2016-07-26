package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IBuyGuideDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.BuyGuide;

/**
 * @author: luoqi 
 * @since: 2015年3月7日 下午3:49:54 
 * @history:
 */
@Repository("buyGuideDAOImpl")
public class BuyGuideDAOImpl extends AMybatisTemplate implements IBuyGuideDAO {

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(BuyGuide data) {
        return super.insert(NAMESPACE.concat("insert_buyGuide"), data);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(BuyGuide data) {
        return super.delete(NAMESPACE.concat("delete_buyGuide"), data);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public BuyGuide select(BuyGuide condition) {
        return super.select(NAMESPACE.concat("select_buyGuide"), condition,
            BuyGuide.class);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(BuyGuide condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_buyGuide_count"), condition);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<BuyGuide> selectList(BuyGuide condition) {
        return super.selectList(NAMESPACE.concat("select_buyGuide"), condition,
            BuyGuide.class);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<BuyGuide> selectList(BuyGuide condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_buyGuide"), start,
            count, condition, BuyGuide.class);
    }

    /** 
     * @see com.xnjr.cpzc.IBuyGuideDAO#update(com.xnjr.cpzc.domain.BuyGuide)
     */
    @Override
    public int update(BuyGuide data) {
        return super.update(NAMESPACE.concat("update_buyGuide"), data);
    }

    @Override
    public int updateStatus(BuyGuide data) {
        return super.update(NAMESPACE.concat("update_buyGuide_status"), data);
    }
}
