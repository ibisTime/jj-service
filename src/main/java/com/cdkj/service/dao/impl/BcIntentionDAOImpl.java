package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IBcIntentionDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.BcIntention;

@Repository("bcIntentionDAOImpl")
public class BcIntentionDAOImpl extends AMybatisTemplate implements
        IBcIntentionDAO {

    @Override
    public int insert(BcIntention data) {
        return super.insert(NAMESPACE.concat("insert_bcIntention"), data);
    }

    @Override
    public int delete(BcIntention data) {
        return super.delete(NAMESPACE.concat("delete_bcIntention"), data);
    }

    @Override
    public BcIntention select(BcIntention condition) {
        return super.select(NAMESPACE.concat("select_bcIntention"), condition,
            BcIntention.class);
    }

    @Override
    public Long selectTotalCount(BcIntention condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bcIntention_count"), condition);
    }

    @Override
    public List<BcIntention> selectList(BcIntention condition) {
        return super.selectList(NAMESPACE.concat("select_bcIntention"),
            condition, BcIntention.class);
    }

    @Override
    public List<BcIntention> selectList(BcIntention condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_bcIntention"), start,
            count, condition, BcIntention.class);
    }

    @Override
    public int update(BcIntention data) {
        return super.update(NAMESPACE.concat("update_bcIntention"), data);
    }
}
