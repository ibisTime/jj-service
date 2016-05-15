package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDCompanyCardDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDCompanyCard;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月18日 上午11:42:35 
 * @history:
 */
@Repository("fdCompanyCardDAOImpl")
public class FDCompanyCardDAOImpl extends AMybatisTemplate implements
        IFDCompanyCardDAO {

    @Override
    public int insert(FDCompanyCard data) {
        return super.insert(NAMESPACE.concat("insert_fdCompanyCard"), data);
    }

    @Override
    public int delete(FDCompanyCard data) {
        return super.delete(NAMESPACE.concat("delete_fdCompanyCard"), data);
    }

    @Override
    public FDCompanyCard select(FDCompanyCard condition) {
        return (FDCompanyCard) super.select(
            NAMESPACE.concat("select_fdCompanyCard"), condition,
            FDCompanyCard.class);
    }

    @Override
    public Long selectTotalCount(FDCompanyCard condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdCompanyCard_count"), condition);
    }

    @Override
    public List<FDCompanyCard> selectList(FDCompanyCard condition) {
        return super.selectList(NAMESPACE.concat("select_fdCompanyCard"),
            condition, FDCompanyCard.class);
    }

    @Override
    public List<FDCompanyCard> selectList(FDCompanyCard condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdCompanyCard"),
            start, count, condition, FDCompanyCard.class);
    }

    @Override
    public int update(FDCompanyCard data) {
        return super.update(NAMESPACE.concat("update_fdCompanyCard"), data);
    }

}
