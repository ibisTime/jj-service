package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.INewsBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.dao.INewsDAO;
import com.cdkj.service.domain.News;
import com.cdkj.service.enums.ENewsStatus;
import com.cdkj.service.exception.BizException;

@Component
public class NewsBOImpl extends PaginableBOImpl<News> implements INewsBO {

    @Autowired
    private INewsDAO newsDAO;

    @Override
    public boolean isNewsExist(String code) {
        News condition = new News();
        condition.setCode(code);
        if (newsDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveNews(News data) {
        newsDAO.insert(data);
    }

    @Override
    public int removeNews(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            count = newsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshNews(News data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = newsDAO.update(data);
        }
        return count;
    }

    @Override
    public List<News> queryNewsList(News condition) {
        return newsDAO.selectList(condition);
    }

    @Override
    public News getNews(String code) {
        News data = null;
        if (StringUtils.isNotBlank(code)) {
            News condition = new News();
            condition.setCode(code);
            data = newsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "记录不存在");
            }
        }
        return data;
    }

    @Override
    public void shelves(String code, String updater) {
        News data = new News();
        data.setCode(code);
        data.setStatus(ENewsStatus.SHELVES.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        newsDAO.upOrDown(data);
    }

    @Override
    public void soldOut(String code, String updater) {
        News data = new News();
        data.setCode(code);
        data.setStatus(ENewsStatus.SOLDOUT.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        newsDAO.upOrDown(data);
    }
}
