package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGSTraderDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.GSTrader;

/** 
 * 操盘手
 * @author: wuql
 * @since: 2016年1月13日 上午10:39:03 
 * @history:
 */
@Repository("gsTraderDAOImpl")
public class IGSTraderDAOImpl extends AMybatisTemplate implements IGSTraderDAO {
    /** 
     * @see com.xnjr.moom.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(GSTrader data) {
        return super.insert("insert_gsTrader", data);
    }

    /** 
     * @see com.xnjr.moom.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(GSTrader data) {
        return super.delete("delete_gsTrader", data);
    }

    /** 
     * @see com.xnjr.moom.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public GSTrader select(GSTrader condition) {
        return super.select("select_gsTrader", condition, GSTrader.class);
    }

    /** 
     * @see com.xnjr.moom.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(GSTrader condition) {
        return super.selectTotalCount("select_gsTrader_count", condition);
    }

    /** 
     * @see com.xnjr.moom.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<GSTrader> selectList(GSTrader condition) {
        return super.selectList("select_gsTrader", condition, GSTrader.class);
    }

    /** 
     * @see com.xnjr.moom.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<GSTrader> selectList(GSTrader condition, int start, int count) {
        return super.selectList("select_gsTrader", start, count, condition,
            GSTrader.class);
    }

    /** 
     * @see com.xnjr.moom.IGSTraderDAO#update(com.xnjr.mall.domain.GSTrader)
     */
    @Override
    public int update(GSTrader data) {
        return super.update("update_gsTrader", data);
    }

    /** 
     * @see com.xnjr.moom.IGSTraderDAO#update(com.xnjr.mall.domain.GSTrader)
     */
    @Override
    public int updateMobile(GSTrader data) {
        return super.update("update_gsTraderMobile", data);
    }

    /** 
     * @see com.xnjr.moom.IGSTraderDAO#update(com.xnjr.mall.domain.GSTrader)
     */
    @Override
    public int updateTradePwd(GSTrader data) {
        return super.update("update_gsTrader_pwd", data);
    }

    @Override
    public int updateTotal(GSTrader data) {
        return super.update("update_total", data);
    }

}
