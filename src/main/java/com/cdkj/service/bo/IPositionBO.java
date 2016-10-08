package com.cdkj.service.bo;

import java.util.List;

import com.cdkj.service.bo.base.IPaginableBO;
import com.cdkj.service.domain.Position;

public interface IPositionBO extends IPaginableBO<Position> {

    public boolean isPositionExist(String code);

    public String savePosition(Position data);

    public int removePosition(String code);

    public int refreshPosition(Position data);

    public int refreshPositionStatus(String code, String dealer, String dealNote);

    public int refreshPositionHot(String code, String isHot, String orderNo,
            String dealer);

    public List<Position> queryPositionList(Position condition);

    public Position getPosition(String code);

}
