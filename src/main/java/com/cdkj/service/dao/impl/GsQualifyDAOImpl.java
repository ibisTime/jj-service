package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.IGsQualifyDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.GsQualify;

@Repository("gsQualifyDAOImpl")
public class GsQualifyDAOImpl extends AMybatisTemplate implements IGsQualifyDAO {

    @Override
    public int insert(GsQualify data) {
        return super.insert(NAMESPACE.concat("insert_gsQualify"), data);
    }

    @Override
    public int delete(GsQualify data) {
        return super.delete(NAMESPACE.concat("delete_gsQualify"), data);
    }

    @Override
    public GsQualify select(GsQualify condition) {
        return super.select(NAMESPACE.concat("select_gsQualify"), condition,
            GsQualify.class);
    }

    @Override
    public Long selectTotalCount(GsQualify condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_gsQualify_count"), condition);
    }

    @Override
    public List<GsQualify> selectList(GsQualify condition) {
        return super.selectList(NAMESPACE.concat("select_gsQualify"),
            condition, GsQualify.class);
    }

    @Override
    public List<GsQualify> selectList(GsQualify condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_gsQualify"), start,
            count, condition, GsQualify.class);
    }

    @Override
    public int update(GsQualify data) {
        return super.update(NAMESPACE.concat("update_gsQualify"), data);
    }

    @Override
    public int approvel(GsQualify data) {
        return super.update(NAMESPACE.concat("update_approvel"), data);
    }

}
