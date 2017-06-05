package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.News;

//dao层 
public interface INewsDAO extends IBaseDAO<News> {
    String NAMESPACE = INewsDAO.class.getName().concat(".");

    public int upOrDown(News data);
}
