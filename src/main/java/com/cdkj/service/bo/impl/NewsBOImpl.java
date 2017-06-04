package com.cdkj.service.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.INewsBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.EGeneratePrefix;
import com.cdkj.service.core.OrderNoGenerater;
import com.cdkj.service.dao.INewsDAO;
import com.cdkj.service.domain.News;
import com.cdkj.service.exception.BizException;

@Component
public class NewsBOImpl extends PaginableBOImpl<News> implements INewsBO {

    @Autowired
    private INewsDAO NewsDAO;

    @Override
    public boolean isNewsExist(String code) {
        News condition = new News();
        condition.setCode(code);
        if (NewsDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveNews(News data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.NEWS.getCode());
            data.setCode(code);
            NewsDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeNews(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            News data = new News();
            data.setCode(code);
            count = NewsDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshNews(News data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = NewsDAO.update(data);
        }
        return count;
    }

    @Override
    public List<News> queryNewsList(News condition) {
        return NewsDAO.selectList(condition);
    }

    @Override
    public News getNews(String code) {
        News data = null;
        if (StringUtils.isNotBlank(code)) {
            News condition = new News();
            condition.setCode(code);
            data = NewsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
