package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGSAJourDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.GSAccountJour;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午4:32:28 
 * @history:
 */
@Repository("gsAJourDAOImpl")
public class GSAJourDAOImpl extends AMybatisTemplate implements IGSAJourDAO {

    @Override
    public int insert(GSAccountJour data) {
        return super.insert(NAMESPACE.concat("insert_gsAccountJour"), data);
    }

    @Override
    public int delete(GSAccountJour data) {
        return 0;
    }

    @Override
    public GSAccountJour select(GSAccountJour condition) {
        return super.select(NAMESPACE.concat("select_gsAccountJour"),
            condition, GSAccountJour.class);
    }

    @Override
    public Long selectTotalCount(GSAccountJour condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_gsAccountJour_count"), condition);
    }

    @Override
    public List<GSAccountJour> selectList(GSAccountJour condition) {
        return super.selectList(NAMESPACE.concat("select_gsAccountJour"),
            condition, GSAccountJour.class);
    }

    @Override
    public List<GSAccountJour> selectList(GSAccountJour condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_gsAccountJour"),
            start, count, condition, GSAccountJour.class);
    }

    @Override
    public int updateCheck(GSAccountJour data) {
        return super.update("update_gsAccountCheck", data);
    }

}
