/**
 * @Title PTCompanyCardDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年3月5日 下午4:02:19 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IPTCompanyCardDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.PTCompanyCard;

/** 
 * @author: xieyj 
 * @since: 2016年3月5日 下午4:02:19 
 * @history:
 */
@Repository("ptCompanyCardDAOImpl")
public class PTCompanyCardDAOImpl extends AMybatisTemplate implements
        IPTCompanyCardDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(PTCompanyCard data) {
        return super.insert("insert_ptCompanyCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(PTCompanyCard data) {
        return super.delete("delete_ptCompanyCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#updatePassPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int updatePassPTCompanyCard(PTCompanyCard data) {
        return super.update("update_passPTCompanyCard", data);

    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#updateNoPassPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int updateUnPassPTCompanyCard(PTCompanyCard data) {
        return super.update("update_unPassPTCompanyCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public PTCompanyCard select(PTCompanyCard condition) {
        return super.select("select_ptCompanyCard", condition,
            PTCompanyCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(PTCompanyCard condition) {
        return super.selectTotalCount("select_ptCompanyCard_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<PTCompanyCard> selectList(PTCompanyCard condition) {
        return super.selectList("select_ptCompanyCard", condition,
            PTCompanyCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<PTCompanyCard> selectList(PTCompanyCard condition, int start,
            int count) {
        return super.selectList("select_ptCompanyCard", start, count,
            condition, PTCompanyCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#update(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int update(PTCompanyCard data) {
        return super.update("update_ptCompanyCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#updateIsAcceptPTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int updateIsAcceptPTCompanyCard(PTCompanyCard data) {
        return super.update("update_isAcceptPTCompanyCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#updateJourDatePTCompanyCard(com.xnjr.mall.domain.PTCompanyCard)
     */
    @Override
    public int updateJourDatePTCompanyCard(PTCompanyCard data) {
        return super.update("update_jourDatePTCompanyCard", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#selectDetailList(com.xnjr.moom.domain.DetailPTCompanyCard)
     */
    @Override
    public List<PTCompanyCard> selectDetailList(PTCompanyCard condition) {
        return super.selectList("select_ptCompanyCardDetail", condition,
            PTCompanyCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#selectDetailList(com.xnjr.moom.domain.DetailPTCompanyCard, int, int)
     */
    @Override
    public List<PTCompanyCard> selectDetailList(PTCompanyCard condition,
            int start, int count) {
        return super.selectList("select_ptCompanyCardDetail", start, count,
            condition, PTCompanyCard.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyCardDAO#selectDetailTotalCount(com.xnjr.moom.domain.DetailPTCompanyCard)
     */
    @Override
    public Long selectDetailTotalCount(PTCompanyCard condition) {
        return super.selectTotalCount("select_ptCompanyCardDetail_count",
            condition);
    }
}
