package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IInvestTableDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.InvestTable;

/**
 * 认购打款记录DAO
 * @author: wuql
 * @since: 2016年1月20日 下午7:49:46 
 * @history:
 */
@Repository("investTableDAOImpl")
public class InvestTableDAOImpl extends AMybatisTemplate implements
        IInvestTableDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(InvestTable data) {
        return super.insert("insert_investTable", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(InvestTable data) {
        return super.delete("delete_investTable", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IInvestTableDAO#update(com.xnjr.mall.domain.InvestTable)
     */
    @Override
    public int update(InvestTable data) {
        return super.update("update_investTable", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public InvestTable select(InvestTable condition) {
        return super.select("select_investTable", condition, InvestTable.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(InvestTable condition) {
        return super.selectTotalCount("select_investTable_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<InvestTable> selectList(InvestTable condition) {
        return super.selectList("select_investTable", condition,
            InvestTable.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<InvestTable> selectList(InvestTable condition, int start,
            int count) {
        return super.selectList("select_investTable", start, count, condition,
            InvestTable.class);
    }

    @Override
    public Long selectSumAmount(InvestTable condition) {
        return super.selectTotalCount("select_SumAmount", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.IInvestTableDAO#selectSubjectInvestTable(com.xnjr.mall.domain.InvestTable)
     */
    @Override
    public List<InvestTable> selectSubjectInvestTable(InvestTable condition) {
        return super.selectList("select_subjectInvestTable", condition,
            InvestTable.class);
    }
}
