/**
 * @Title MerCardDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午5:30:52 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IMerCardDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.MerCard;

/** 
 * @author: xieyj 
 * @since: 2016年6月11日 下午5:30:52 
 * @history:
 */
@Repository("merCardDAOImpl")
public class MerCardDAOImpl extends AMybatisTemplate implements IMerCardDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(MerCard data) {
        return super.insert("insert_merCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(MerCard data) {
        return super.delete("delete_merCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public MerCard select(MerCard condition) {
        return super.select("select_merCard", condition, MerCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(MerCard condition) {
        return super.selectTotalCount("select_merCard_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<MerCard> selectList(MerCard condition) {
        return super.selectList("select_merCard", condition, MerCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<MerCard> selectList(MerCard condition, int start, int count) {
        return super.selectList("select_merCard", start, count, condition,
            MerCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IMerCardDAO#updateMerCard(com.xnjr.mall.domain.MerCard)
     */
    @Override
    public int updateMerCard(MerCard data) {
        return super.update("update_merCard", data);
    }

}
