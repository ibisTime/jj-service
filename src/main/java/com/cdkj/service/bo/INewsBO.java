package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.News;



//CHECK ��鲢��ע�� 
public interface INewsBO extends IPaginableBO<News> {


	public boolean isNewsExist(String code);


	public String saveNews(News data);


	public int removeNews(String code);


	public int refreshNews(News data);


	public List<News> queryNewsList(News condition);


	public News getNews(String code);


}