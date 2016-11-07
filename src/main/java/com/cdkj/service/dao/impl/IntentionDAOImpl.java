package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.common.PropertiesUtil;
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
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.select(NAMESPACE.concat("select_intention"), condition,
            Intention.class);
    }

    @Override
    public Long selectTotalCount(Intention condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(
            NAMESPACE.concat("select_intention_count"), condition);
    }

    @Override
    public List<Intention> selectList(Intention condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_intention"),
            condition, Intention.class);
    }

    @Override
    public List<Intention> selectList(Intention condition, int start, int count) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
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

    @Override
    public List<Intention> selectFWList(Intention condition, int start,
            int count) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_intention_fw"), start,
            count, condition, Intention.class);
    }

    @Override
    public Long selectFWTotalCount(Intention condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(
            NAMESPACE.concat("select_intention_count_fw"), condition);
    }

    @Override
    public Long selectXQTotalCount(Intention condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(
            NAMESPACE.concat("select_intention_count_xq"), condition);
    }

    @Override
    public List<Intention> selectXQList(Intention condition, int start,
            int count) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_intention_xq"), start,
            count, condition, Intention.class);
    }

    @Override
    public Long selectJLTotalCount(Intention condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(
            NAMESPACE.concat("select_intention_count_jl"), condition);
    }

    @Override
    public List<Intention> selectJLList(Intention condition, int start,
            int count) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_intention_jl"), start,
            count, condition, Intention.class);
    }

    @Override
    public Long selectZWTotalCount(Intention condition) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectTotalCount(
            NAMESPACE.concat("select_intention_count_zw"), condition);
    }

    @Override
    public List<Intention> selectZWList(Intention condition, int start,
            int count) {
        condition.setUserDB(PropertiesUtil.Config.USER_DB);
        return super.selectList(NAMESPACE.concat("select_intention_zw"), start,
            count, condition, Intention.class);
    }
}
