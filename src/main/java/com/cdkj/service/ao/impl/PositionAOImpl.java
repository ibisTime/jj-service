package com.cdkj.service.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.bo.IPositionBO;
import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Position;
import com.cdkj.service.exception.BizException;

@Service
public class PositionAOImpl implements IPositionAO {

    @Autowired
    private IPositionBO positionBO;

    @Override
    public String addPosition(Position data) {
        return positionBO.savePosition(data);
    }

    @Override
    public int editPosition(Position data) {
        if (!positionBO.isPositionExist(data.getCode())) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return positionBO.refreshPosition(data);
    }

    @Override
    public int dropPosition(String code) {
        if (!positionBO.isPositionExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return positionBO.removePosition(code);
    }

    @Override
    public Paginable<Position> queryPositionPage(int start, int limit,
            Position condition) {
        return positionBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Position> queryPositionList(Position condition) {
        return positionBO.queryPositionList(condition);
    }

    @Override
    public Position getPosition(String code) {
        return positionBO.getPosition(code);
    }

    @Override
    public int editPositionStatus(String code, String dealer, String dealNote) {
        if (!positionBO.isPositionExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return positionBO.refreshPositionStatus(code, dealer, dealNote);
    }

    @Override
    public int editPositionHot(String code, String isHot, String orderNo,
            String dealer) {
        if (!positionBO.isPositionExist(code)) {
            throw new BizException("xn0000", "该编号不存在");
        }
        return positionBO.refreshPositionHot(code, isHot, orderNo, dealer);
    }
}
