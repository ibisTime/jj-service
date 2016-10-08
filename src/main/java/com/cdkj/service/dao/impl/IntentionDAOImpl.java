package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IIntentionDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.Intention;

@Repository("intentionDAOImpl")
public class IntentionDAOImpl extends AMybatisTemplate implements IIntentionDAO {

    @Override
    public int insert(Intention data) {
        return super.insert(NAMESPACE.concat("insert_intention"), data);
    }

    @Override
    public int delete(Intention data) {
        return super.delete(NAMESPACE.concat("delete_intention"), data);
    }

    @Override
    public Intention select(Intention condition) {
        return super.select(NAMESPACE.concat("select_intention"), condition,
            Intention.class);
    }

    @Override
    public Long selectTotalCount(Intention condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_intention_count"), condition);
    }

    @Override
    public List<Intention> selectList(Intention condition) {
        return super.selectList(NAMESPACE.concat("select_intention"),
            condition, Intention.class);
    }

    @Override
    public List<Intention> selectList(Intention condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_intention"), start,
            count, condition, Intention.class);
    }

    /** 
     * @see com.cdkj.service.dao.base.IBaseDAO#update(java.lang.Object)
     */
    @Override
    public int update(Intention data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.cdkj.service.dao.IIntentionDAO#updateStatus(com.cdkj.service.domain.Intention)
     */
    @Override
    public int updateStatus(Intention data) {
        return super.update(NAMESPACE.concat("update_intention_status"), data);
    }

}
