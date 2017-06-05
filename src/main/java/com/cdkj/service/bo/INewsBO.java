package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.News;

public interface INewsBO extends IPaginableBO<News> {

    public boolean isNewsExist(String code);

    public void saveNews(News data);

    public int removeNews(String code);

    public int refreshNews(News data);

    public List<News> queryNewsList(News condition);

    public News getNews(String code);

    public void shelves(String code, String updater);

    public void soldOut(String code, String updater);

}
