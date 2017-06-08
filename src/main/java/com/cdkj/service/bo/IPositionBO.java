package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Position;

public interface IPositionBO extends IPaginableBO<Position> {

    public boolean isPositionExist(String code);

    public void savePosition(Position data);

    public void removePosition(String code);

    public void refreshPosition(Position data);

    public void refreshPositionStatus(Position position, String dealer,
            String dealNote);

    public void refreshPositionHot(Position position, String location,
            String orderNo, String dealer);

    public List<Position> queryPositionList(Position condition);

    public Position getPosition(String code);

    public List<Position> queryPositionList(String status, String location,
            String orderNo);

}
