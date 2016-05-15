package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDBankCardDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDBankCard;

/**
 * @author: xieyj 
 * @since: 2016年4月23日 上午8:58:58 
 * @history:
 */
@Repository("fdBankCardDAOImpl")
public class FDBankCardDAOImpl extends AMybatisTemplate implements
        IFDBankCardDAO {

    @Override
    public int insert(FDBankCard data) {
        return super.insert(NAMESPACE.concat("insert_fdBankCard"), data);
    }

    @Override
    public int delete(FDBankCard data) {
        return super.delete(NAMESPACE.concat("delete_fdBankCard"), data);
    }

    @Override
    public FDBankCard select(FDBankCard condition) {
        return (FDBankCard) super.select(NAMESPACE.concat("select_fdBankCard"),
            condition, FDBankCard.class);
    }

    @Override
    public Long selectTotalCount(FDBankCard condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdBankCard_count"), condition);
    }

    @Override
    public List<FDBankCard> selectList(FDBankCard condition) {
        return super.selectList(NAMESPACE.concat("select_fdBankCard"),
            condition, FDBankCard.class);
    }

    @Override
    public List<FDBankCard> selectList(FDBankCard condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdBankCard"), start,
            count, condition, FDBankCard.class);
    }

    @Override
    public int update(FDBankCard data) {
        return super.update(NAMESPACE.concat("update_fdBankCard"), data);
    }

}
