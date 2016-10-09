package com.cdkj.service.dao;

import java.util.List;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Intention;

public interface IIntentionDAO extends IBaseDAO<Intention> {
    String NAMESPACE = IIntentionDAO.class.getName().concat(".");

    public int updateStatus(Intention data);

    public Long selectFWTotalCount(Intention condition);

    public List<Intention> selectFWList(Intention condition, int start,
            int count);

    public Long selectXQTotalCount(Intention condition);

    public List<Intention> selectXQList(Intention condition, int start,
            int count);

    public Long selectJLTotalCount(Intention condition);

    public List<Intention> selectJLList(Intention condition, int start,
            int count);

    public Long selectZWTotalCount(Intention condition);

    public List<Intention> selectZWList(Intention condition, int start,
            int count);

}
