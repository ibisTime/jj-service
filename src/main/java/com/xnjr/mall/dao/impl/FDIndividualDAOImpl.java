package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDIndividualDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDIndividual;

/**
 * 资金方-个体户
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:01:57 
 * @history:
 */
@Repository("fdIndividualDAOImpl")
public class FDIndividualDAOImpl extends AMybatisTemplate implements
        IFDIndividualDAO {

    @Override
    public int insert(FDIndividual data) {
        return super.insert(NAMESPACE.concat("insert_fdIndividual"), data);
    }

    @Override
    public int delete(FDIndividual data) {
        return super.delete(NAMESPACE.concat("delete_fdIndividual"), data);
    }

    @Override
    public FDIndividual select(FDIndividual condition) {
        return (FDIndividual) super.select(
            NAMESPACE.concat("select_fdIndividual"), condition,
            FDIndividual.class);
    }

    @Override
    public Long selectTotalCount(FDIndividual condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdIndividual_count"), condition);
    }

    @Override
    public List<FDIndividual> selectList(FDIndividual condition) {
        return super.selectList(NAMESPACE.concat("select_fdIndividual"),
            condition, FDIndividual.class);
    }

    @Override
    public List<FDIndividual> selectList(FDIndividual condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdIndividual"), start,
            count, condition, FDIndividual.class);
    }

    @Override
    public int update(FDIndividual data) {
        return super.update(NAMESPACE.concat("update_fdIndividual"), data);
    }

}
