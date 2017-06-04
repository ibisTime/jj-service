package com.cdkj.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.service.dao.INewsDAO;
import com.cdkj.service.dao.base.support.AMybatisTemplate;
import com.cdkj.service.domain.News;

@Repository("NewsDAOImpl")
public class NewsDAOImpl extends AMybatisTemplate implements INewsDAO {

    @Override
    public int insert(News data) {
        return super.insert(NAMESPACE.concat("insert_News"), data);
    }

    @Override
    public int delete(News data) {
        return super.delete(NAMESPACE.concat("delete_News"), data);
    }

    @Override
    public News select(News condition) {
        return super.select(NAMESPACE.concat("select_News"), condition,
            News.class);
    }

    @Override
    public Long selectTotalCount(News condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_News_count"),
            condition);
    }

    @Override
    public List<News> selectList(News condition) {
        return super.selectList(NAMESPACE.concat("select_News"), condition,
            News.class);
    }

    @Override
    public List<News> selectList(News condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_News"), start, count,
            condition, News.class);
    }

    @Override
    public int update(News data) {
        return super.update(NAMESPACE.concat("update_News"), data);
    }

}
