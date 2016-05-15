package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGSStructureDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.GSStructure;

/**
 * 结构
 * @author: Gejin 
 * @since: 2016年4月13日 上午11:04:12 
 * @history:
 */
@Repository("gsStructureDAOImpl")
public class GSStructureDAOImpl extends AMybatisTemplate implements
        IGSStructureDAO {

    @Override
    public int insert(GSStructure data) {
        return super.insert("insert_gsStructure", data);
    }

    @Override
    public int delete(GSStructure data) {
        return super.delete("delete_gsStructure", data);
    }

    @Override
    public GSStructure select(GSStructure condition) {
        return super.select("select_gsStructure", condition, GSStructure.class);
    }

    @Override
    public Long selectTotalCount(GSStructure condition) {
        return super.selectTotalCount("select_gsStructure_count", condition);
    }

    @Override
    public List<GSStructure> selectList(GSStructure condition) {
        return super.selectList("select_gsStructure", condition,
            GSStructure.class);
    }

    @Override
    public List<GSStructure> selectList(GSStructure condition, int start,
            int count) {
        return super.selectList("select_gsStructure", start, count, condition,
            GSStructure.class);
    }

    @Override
    public int updateStructure(GSStructure data) {
        return super.update("update_updateStructure", data);
    }

}
