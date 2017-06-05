package com.cdkj.service.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.News;

@Component
public interface INewsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addNews(String title, String type, String sendPlatform,
            String summary, String content, String isPublish, String updater,
            String remark);

    public void dropNews(String code);

    public void editNews(String code, String title, String type,
            String sendPlatform, String summary, String content,
            String isPublish, String updater, String remark);

    public Paginable<News> queryNewsPage(int start, int limit, News condition);

    public List<News> queryNewsList(News condition);

    public News getNews(String code);

    public void shelves(String code, String updater);

    public void soldOut(String code, String updater);

}
