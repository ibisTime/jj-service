package com.cdkj.service.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.INewsAO;
import com.cdkj.service.bo.INewsBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.domain.News;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.enums.ENewsStatus;
import com.cdkj.service.exception.BizException;

@Service
public class NewsAOImpl implements INewsAO {

    @Autowired
    private INewsBO newsBO;

    @Override
    public String addNews(String title, String type, String sendPlatform,
            String summary, String content, String isPublish, String updater,
            String remark) {
        String status = null;
        if (EBoolean.NO.getCode().equals(isPublish)) {
            status = EBoolean.NO.getCode();
        } else {
            status = EBoolean.YES.getCode();
        }
        News data = new News();
        String code = OrderNoGenerater
            .generateM(EGeneratePrefix.NEWS.getCode());
        data.setCode(code);
        data.setTitle(title);
        data.setType(type);
        data.setSendPlatform(sendPlatform);
        data.setSummary(summary);
        data.setContent(content);
        data.setStatus(status);
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        newsBO.saveNews(data);
        return code;
    }

    @Override
    public void editNews(String code, String title, String type,
            String sendPlatform, String summary, String content,
            String isPublish, String updater, String remark) {
        News news = newsBO.getNews(code);
        if (news.getStatus().equals(EBoolean.NO.getCode())) {
            News data = new News();
            data.setCode(code);
            data.setTitle(title);
            data.setType(type);
            data.setSendPlatform(sendPlatform);
            data.setSummary(summary);
            data.setContent(content);
            data.setStatus(EBoolean.YES.getCode());
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            newsBO.refreshNews(data);
        }
    }

    @Override
    public void dropNews(String code) {
        if (!newsBO.isNewsExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        newsBO.removeNews(code);
    }

    @Override
    public Paginable<News> queryNewsPage(int start, int limit, News condition) {
        return newsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<News> queryNewsList(News condition) {
        return newsBO.queryNewsList(condition);
    }

    @Override
    public News getNews(String code) {
        return newsBO.getNews(code);
    }

    @Override
    public void shelves(String code, String updater) {
        News news = newsBO.getNews(code);
        if (news.getStatus().equals(ENewsStatus.DRAFT.getCode())
                || news.getStatus().equals(ENewsStatus.SOLDOUT.getCode())) {
            newsBO.shelves(code, updater);
        } else {
            throw new BizException("xn0000", "资讯已上架,不必重复上架");
        }
    }

    @Override
    public void soldOut(String code, String updater) {
        News news = newsBO.getNews(code);
        if (news.getStatus().equals(ENewsStatus.SHELVES.getCode())) {
            newsBO.soldOut(code, updater);
        } else {
            throw new BizException("xn0000", "资讯未上架,不可下架");
        }
    }
}
