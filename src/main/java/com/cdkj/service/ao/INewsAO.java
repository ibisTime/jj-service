package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.News;

@Component
public interface INewsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addNews(News data);

    public int dropNews(String code);

    public int editNews(News data);

    public Paginable<News> queryNewsPage(int start, int limit, News condition);

    public List<News> queryNewsList(News condition);

    public News getNews(String code);

}
