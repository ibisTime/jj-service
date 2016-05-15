/**
 * @Title WillInvestDAOImpl.java 
 * @Package com.xnjr.pop.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 上午10:32:12 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IWillInvestDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.WillInvest;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午10:32:12 
 * @history:
 */
@Repository("willInvestDAOImpl")
public class WillInvestDAOImpl extends AMybatisTemplate implements
        IWillInvestDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(WillInvest data) {
        return super.insert("insert_willInvest", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(WillInvest data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public WillInvest select(WillInvest condition) {
        return super.select("select_willInvest", condition, WillInvest.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(WillInvest condition) {
        return super.selectTotalCount("select_willInvest_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<WillInvest> selectList(WillInvest condition) {
        return super.selectList("select_willInvest", condition,
            WillInvest.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<WillInvest> selectList(WillInvest condition, int start,
            int count) {
        return super.selectList("select_willInvest", start, count, condition,
            WillInvest.class);
    }

}
