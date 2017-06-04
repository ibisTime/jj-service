package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.INewsAO;
import com.cdkj.service.bo.INewsBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.News;
import com.cdkj.service.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class NewsAOImpl implements INewsAO {

	@Autowired
	private INewsBO NewsBO;

	@Override
	public String addNews(News data) {
		return NewsBO.saveNews(data);
	}

	@Override
	public int editNews(News data) {
		if (!NewsBO.isNewsExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return NewsBO.refreshNews(data);
	}

	@Override
	public int dropNews(String code) {
		if (!NewsBO.isNewsExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return NewsBO.removeNews(code);
	}

	@Override
	public Paginable<News> queryNewsPage(int start, int limit,
			News condition) {
		return NewsBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<News> queryNewsList(News condition) {
		return NewsBO.queryNewsList(condition);
	}

	@Override
	public News getNews(String code) {
		return NewsBO.getNews(code);
	}
}