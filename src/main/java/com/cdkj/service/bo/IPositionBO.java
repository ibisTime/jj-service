package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Position;

public interface IPositionBO extends IPaginableBO<Position> {

    public boolean isPositionExist(String code);

    public void savePosition(Position data);

    public void removePosition(String code);

    public void refreshPosition(Position data);

    public void refreshPositionStatus(String code, String dealer,
            String dealNote);

    public void refreshPositionHot(String code, String isHot, String orderNo,
            String dealer);

    public List<Position> queryPositionList(Position condition);

    public Position getPosition(String code);

}
