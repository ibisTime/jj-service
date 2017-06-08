package com.cdkj.service.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IPositionBO;
import com.cdkj.service.bo.base.PaginableBOImpl;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dao.IPositionDAO;
import com.cdkj.service.domain.Position;
import com.cdkj.service.enums.EBoolean;
import com.cdkj.service.exception.BizException;

@Component
public class PositionBOImpl extends PaginableBOImpl<Position> implements
        IPositionBO {

    @Autowired
    private IPositionDAO positionDAO;

    @Override
    public boolean isPositionExist(String code) {
        Position condition = new Position();
        condition.setCode(code);
        if (positionDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void savePosition(Position data) {
        positionDAO.insert(data);
    }

    @Override
    public void removePosition(String code) {
        if (StringUtils.isNotBlank(code)) {
            Position data = new Position();
            data.setCode(code);
            positionDAO.delete(data);
        }
    }

    @Override
    public void refreshPosition(Position data) {
        positionDAO.update(data);
    }

    @Override
    public List<Position> queryPositionList(Position condition) {
        return positionDAO.selectList(condition);
    }

    @Override
    public Position getPosition(String code) {
        Position data = null;
        if (StringUtils.isNotBlank(code)) {
            Position condition = new Position();
            condition.setCode(code);
            data = positionDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该职位不存在");
            }
        }
        return data;
    }

    @Override
    public void refreshPositionStatus(Position position, String dealer,
            String dealNote) {
        position.setStatus(EBoolean.NO.getCode());
        position.setDealer(dealer);
        position.setDealNote(dealNote);
        position.setDealDatetime(new Date());
        positionDAO.updateStatus(position);
    }

    @Override
    public void refreshPositionHot(Position position, String location,
            String orderNo, String dealer) {
        position.setLocation(location);
        position.setOrderNo(StringValidater.toInteger(orderNo));
        position.setDealer(dealer);
        position.setDealDatetime(new Date());
        positionDAO.updateHot(position);
    }

    @Override
    public List<Position> queryPositionList(String status, String location,
            String orderNo) {
        Position condition = new Position();
        condition.setStatus(status);
        condition.setLocation(location);
        condition.setOrderNo(StringValidater.toInteger(orderNo));
        return positionDAO.selectList(condition);
    }
}
