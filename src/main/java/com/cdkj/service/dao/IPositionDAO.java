package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Position;

public interface IPositionDAO extends IBaseDAO<Position> {
    String NAMESPACE = IPositionDAO.class.getName().concat(".");

    public int updateStatus(Position data);

    public int updateHot(Position data);
}
