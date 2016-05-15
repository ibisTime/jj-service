/**
 * @Title InvestDAOImpl.java 
 * @Package com.xnjr.pop.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 上午10:32:12 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IInvestDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.Subject;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午10:32:12 
 * @history:
 */
@Repository("investDAOImpl")
public class InvestDAOImpl extends AMybatisTemplate implements IInvestDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Invest data) {
        return super.insert("insert_invest", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Invest data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Invest select(Invest condition) {
        return super.select("select_invest", condition, Invest.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Invest condition) {
        return super.selectTotalCount("select_invest_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Invest> selectList(Invest condition) {
        return super.selectList("select_invest", condition, Invest.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Invest> selectList(Invest condition, int start, int count) {
        return super.selectList("select_invest", start, count, condition,
            Invest.class);
    }

    /**
     * @see com.xnjr.mall.dao.IInvestDAO#selectTotalAmount(com.xnjr.mall.domain.Invest)
     */
    @Override
    public Long selectTotalAmount(Invest condition) {
        return super.selectTotalCount("select_total_amount", condition);
    }

    @Override
    public int cancelInvest(Invest data) {
        return super.update("update_cancelInvest", data);
    }

    @Override
    public int confirmInvest(Invest data) {
        return super.update("update_confirmInvest", data);
    }

    @Override
    public List<Subject> selectMySubjectList(Invest condition) {
        return super.selectList("select_my_invest_subject", condition,
            Subject.class);
    }
}
