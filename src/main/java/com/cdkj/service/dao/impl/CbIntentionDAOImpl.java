package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.ICbIntentionDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.CbIntention;

@Repository("CbIntentionDAOImpl")
public class CbIntentionDAOImpl extends AMybatisTemplate implements
        ICbIntentionDAO {

    @Override
    public int insert(CbIntention data) {
        return super.insert(NAMESPACE.concat("insert_CbIntention"), data);
    }

    @Override
    public int delete(CbIntention data) {
        return super.delete(NAMESPACE.concat("delete_CbIntention"), data);
    }

    @Override
    public CbIntention select(CbIntention condition) {
        return super.select(NAMESPACE.concat("select_CbIntention"), condition,
            CbIntention.class);
    }

    @Override
    public Long selectTotalCount(CbIntention condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_CbIntention_count"), condition);
    }

    @Override
    public List<CbIntention> selectList(CbIntention condition) {
        return super.selectList(NAMESPACE.concat("select_CbIntention"),
            condition, CbIntention.class);
    }

    @Override
    public List<CbIntention> selectList(CbIntention condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_CbIntention"), start,
            count, condition, CbIntention.class);
    }

    @Override
    public int update(CbIntention data) {
        return super.update(NAMESPACE.concat("update_CbIntention"), data);
    }

}
